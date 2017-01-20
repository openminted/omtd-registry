import xml.etree.ElementTree as ET
import sys
import os
import pprint
import re

MAX_ENUM = 300
verbose = False

class Rename:

	@staticmethod
	def rename(name):
		if name is '':
			name = 'BLANK'
		new_name = name
		match = re.match('^[^0-9][a-zA-Z_0-9]+$',name)
		if match is None:
			new_name = re.sub(r'\s',"",name)
			new_name = re.sub(r'/',"_",name)
			new_name = re.sub(r'[^\w\d_]','_', new_name)
			if re.match('\d.*',new_name) is not None :
				new_name = 'V' + new_name
		else:
			new_name = re.sub(r'([a-z])([A-Z])',r"\1_\2",name)
		return new_name.upper()


def create_appInfo(node, namespace) :
	annotation = node.findall('./xs:annotation',namespace) 
	if not annotation:
		#print 'Creating xs:annotation node under ' + node.tag
		annotation = ET.Element('xs:annotation')
		node.insert(0,annotation)
		appInfo = ET.SubElement(annotation,'xs:appinfo')
	else:
		#print 'Using existing xs:annotation node'
		annotation = annotation[0]
		appInfo = annotation.findall('./xs:appinfo',namespace)
		if len(appInfo) == 0 :
			#print '\tCreating new appInfo node'
			appInfo = ET.SubElement(annotation,'xs:appinfo')
		else:
			appInfo = appInfo[0]
			#print 'Using ' + appInfo[0].tag

	return appInfo

def rename_enum(n,namespace, appInfo,node) :
	enums = n.findall('./xs:restriction/xs:enumeration',namespace)
	if len(enums) > 0 :
		cl = ET.SubElement(appInfo,'jaxb:typesafeEnumClass')
		if len(enums) > MAX_ENUM :
			cl.set('map','false')
	if 'name' in node.attrib:
		cl.set('name', node.attrib['name'] + 'Enum')
		if verbose :
			print 'Naming the enum ' + node.attrib['name']
	if len(enums) > 0 : 
		for enum in enums :
			if 'value' in enum.attrib :
				if len(enum.attrib['value']) == 0 :
					rename = 'BLANK'
					if verbose :
						print '\tReplacing empty string \tto\t ' + rename.upper()
					clRenaming = ET.Element('jaxb:typesafeEnumMember')
					clRenaming.set('value',enum.attrib['value'])
					clRenaming.set('name',rename.upper())
					cl.insert(0,clRenaming)
				else:
					rename = enum.attrib['value']
					if re.match('^[^0-9][a-zA-Z_+\-=/0-9]+$',rename) is None:
						rename = re.sub(r'\s',"",enum.attrib['value'])
						rename = re.sub(r'[^\w\d_]','_', rename)			
						if re.match('\d.*',rename) is not None :
							rename = 'V' + rename	
						if rename != enum.attrib['value'] :
							clRenaming = ET.Element('jaxb:typesafeEnumMember')
							clRenaming.set('value',enum.attrib['value'])
							clRenaming.set('name',rename.upper())
							cl.insert(0,clRenaming)
						if verbose :
							print '\tRenaming <<<' + enum.attrib['value'] + '>>> \tto\t ' + rename.upper()
				#else:
					#print '\tParsing <<<'+enum.attrib['value'] + '>>>'

def simplify_choices(node,namespace):
	
	elements = node.findall(".//xs:element",namespace)
	if 'type' in elements[0].attrib or 'ref' in elements[0].attrib:
		element = elements[0]
		appInfo = create_appInfo(element,namespace)
		#ET.SubElement(appInfo,"simplify:as-reference-property")
		#print .getpath(appInfo)
	else:
		appInfo = create_appInfo(node,namespace)
		ET.SubElement(appInfo,"simplify:as-element-property")


def modify(filename, namespace) :
	ET.register_namespace("ms","http://www.meta-share.org/OMTD-SHARE_XMLSchema")
	ET.register_namespace("xs","http://www.w3.org/2001/XMLSchema")
	ET.register_namespace("","http://www.meta-share.org/OMTD-SHARE_XMLSchema")
	tree = ET.parse(filename)
	root = tree.getroot()
	#print root.attrib
	root.set('xmlns:ms',"http://www.meta-share.org/OMTD-SHARE_XMLSchema")
	root.set('xmlns:jaxb',"http://java.sun.com/xml/ns/jaxb")
	root.set('jaxb:version',"1.0")
	# ".//xs:simpleType/xs:restriction/xs:enumeration"
	nodes = root.findall(".//xs:simpleType/xs:restriction/xs:enumeration/../../..",namespace)
	for node in nodes :
		#if 'name' in node.attrib :
			#print(node.attrib['name'])
		for n in node.findall("./xs:simpleType",namespace) :
			appInfo = create_appInfo(n,namespace)
			rename_enum(n,namespace,appInfo,node)

	# nodes = root.findall(".//xs:choice",namespace)
	# for node in nodes :
	# 	simplify_choices(node,namespace)
	# if len(nodes) > 0 :
	# 	root.set('jaxb:extensionBindingPrefixes',"simplify")			
	# 	root.set('xmlns:simplify',"http://jaxb2-commons.dev.java.net/basic/simplify")
			

	return tree

if __name__ == "__main__" :
	namespace = {'xs' : "http://www.w3.org/2001/XMLSchema" , 'ms' : "http://www.meta-share.org/OMTD-SHARE_XMLSchema"}
	for arg in sys.argv :
		if arg == '-v' :
			verbose = True
		elif arg != sys.argv[0] :
			modfile = os.path.basename(arg)
			original = os.path.abspath(arg)
			if os.path.isfile(modfile) :
				statsM = os.stat(modfile)
				statsO = os.stat(original)		
				if statsM.st_mtime < statsO.st_mtime :
					print '[+] Original file modified creating ' + modfile
					xml = modify(arg,namespace)
					xml.write(modfile)
				else:
					print '[ ] Unchanged file ' + modfile
			else:
				print '[+] Creating file ' + modfile
				xml = modify(arg,namespace)
				xml.write(modfile)
