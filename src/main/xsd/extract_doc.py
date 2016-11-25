import xml.etree.ElementTree as ET
import sys
import os
import pprint
import re
import json
import codecs
from enum import Rename


def parseElements(filename, namespace, types) :
	ET.register_namespace("ms","http://www.meta-share.org/OMTD-SHARE_XMLSchema")
	ET.register_namespace("xs","http://www.w3.org/2001/XMLSchema")
	ET.register_namespace("","http://www.meta-share.org/OMTD-SHARE_XMLSchema")
	tree = ET.parse(filename)
	root = tree.getroot()
	nodes = root.findall(".//xs:documentation/../..",namespace)
	for node in nodes :
		if 'name' in node.attrib:
			nodeName = node.attrib['name']
			#thisDoc = {}
			thisDesLabel = {}
			doc = node.findall('.//xs:documentation',namespace)
			thisDesLabel['desc'] = doc[0].text
			label = node.findall('.//label',namespace)
			if len(label) > 0 :
				thisDesLabel['label'] = label[0].text
			else:
				thisDesLabel['label'] = None
			#thisDoc[nodeName] = thisDesLabel
			if nodeName in types :
				if types[nodeName]['desc'] is None :
					if doc[0].text != None :
						types[nodeName]['desc'] = doc[0].text
						print('[+] ' + nodeName + ' found duplicate definition with Description (Replacing...) ')
					else:
						print ('[-] ' + nodeName + ' found duplicate definition with no Description (Ignoring...)')
				else:
					print ('[-] ' + nodeName + ' found duplicate definition (Keeping first and ignoring rest...) ')
				#print '\t' + str(doc[0].text)
				#print '\t' + str(types[nodeName]['desc'])
			types[nodeName] = thisDesLabel
	return types

def printElements(filename, types):
	with open(filename,'w') as f:
		f.write('export class Description {\n\tdesc: string;\n\tlabel: string;\n}\n')
		for name in types:
			desc = finalDoc[name]['desc']
			label = finalDoc[name]['label']
			if label is None:
				label = name
				print(name + " has no available label")
			if desc is None:
				desc = "Description not available"
				# print(name + " has no available description")
			# m = re.match('(.*?)Type$',name)
			# if m is not None:
			# 	name = m.group(1)
			f.write("export var " + name + "Desc = {\n")
			f.write("\t" + "desc : \"" + desc.replace('"','\\"') +"\",\n")
			f.write("\t" + "label : \"" + label.replace('"','\\"') +"\"\n")
			f.write("}\n\n")
		# f.write(json.dumps(finalDoc))
		f.close()

def parseEnumValues(node,path,namespace, arr):
	doc = node.findall(path,namespace)
	for enum in doc:
		label = enum.find("./xs:annotation/xs:appinfo/xs:label",namespace)
		if label is not None :
			arr.append( (enum.attrib['value'] , label.text) )
		else :
			arr.append( (enum.attrib['value'] , enum.attrib['value']))

def parseEnums(filename,namespace,types):
	tree = ET.parse(filename)
	root = tree.getroot()
	nodes = root.findall(".//xs:attribute[@name]/xs:simpleType/xs:restriction/xs:enumeration/../../..",namespace)
	for node in nodes :
		nodeName = node.attrib['name']
		if nodeName not in types:
			types[nodeName] = []
			parseEnumValues(node,".//xs:enumeration",namespace,types[nodeName])
		else:
			print "Duplicate enum found " + nodeName
	
	nodes = root.findall(".//xs:simpleType[@name]/xs:restriction/xs:enumeration/../..",namespace)
	for node in nodes :
		nodeName = node.attrib['name']
		if nodeName not in types:
			types[nodeName] = []
			parseEnumValues(node,".//xs:enumeration",namespace,types[nodeName])
		else:
			print "Duplicate enum found " + nodeName

	nodes = root.findall(".//xs:element[@name]/xs:simpleType/xs:restriction/xs:enumeration/../../..",namespace)
	for node in nodes :
		nodeName = node.attrib['name']
		if nodeName not in types:
			types[nodeName] = []
			parseEnumValues(node,".//xs:enumeration",namespace,types[nodeName])
		else:
			print "Duplicate enum found " + nodeName
			
	return types

def printEnums(filename, types):
	with codecs.open(filename,'w',"utf-8") as f:
		f.write('''
class EnumValues {
	[key: string]: string;
}

''')
		for name in types:

			f.write("export var " + name + "Enum = {\n")
			for val in types[name][:-1]:
				left,right = val
				f.write("\t" + Rename.rename(left) +" : \"" + right.replace('"','\\"') +"\",\n")

			left,right = types[name][-1]
			f.write("\t" + Rename.rename(left) +" : \"" + right.replace('"','\\"') +"\"\n")
			f.write("}\n\n")
		# f.write(json.dumps(finalDoc))
		f.close()

def parse_files(directory):
	finalDoc = {}
	enums = {}
	namespace = {'xs' : "http://www.w3.org/2001/XMLSchema" , 'ms' : "http://www.meta-share.org/OMTD-SHARE_XMLSchema"}
	for file in os.listdir(directory):
		filename,extension = os.path.splitext(file)
		if extension == ".xsd" :
			parseElements(directory + "/" + file,namespace,finalDoc)
			parseEnums(directory + "/" + file,namespace,enums)
	return (finalDoc,enums)


if __name__ == "__main__" :

	for arg in sys.argv :
		if arg == '-v' :
			verbose = True
		elif arg != sys.argv[0] :
			finalDoc,enums = parse_files(arg)
			printElements('descriptions.ts',finalDoc)
			printEnums('enumerations.ts',enums)
	
	
