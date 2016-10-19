import xml.etree.ElementTree as ET
import sys
import os
import pprint
import re
import json



def parse(filename, namespace, types) :
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
						print '[+] ' + nodeName + ' found duplicate definition with Description (Replacing...) '
					else:
						print '[-] ' + nodeName + ' found duplicate definition with no Description (Ignoring...)'
				else:
					print '[-] ' + nodeName + ' found duplicate definition (Keeping first and ignoring rest...) '
				#print '\t' + str(doc[0].text)
				#print '\t' + str(types[nodeName]['desc'])
			types[nodeName] = thisDesLabel
	return types

if __name__ == "__main__" :
	namespace = {'xs' : "http://www.w3.org/2001/XMLSchema" , 'ms' : "http://www.meta-share.org/OMTD-SHARE_XMLSchema"}
	finalDoc = {}
	for arg in sys.argv :
		if arg == '-v' :
			verbose = True
		elif arg != sys.argv[0] :
			parse(arg,namespace,finalDoc)
	with open('descriptions.json','w') as f:
		f.write(json.dumps(finalDoc))
		f.close()
	
