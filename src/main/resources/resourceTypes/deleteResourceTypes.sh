#!/bin/bash

for i in application component corpus incompletecorpus language lexical corpusbuildingstate workflow; do
#for i in incompletecorpus; do
	psql -h $1 -Uvrasidas registry <<endOfMessage
delete from resourcetype_indexfield where resourcetype_name ='$i';
delete from indexfield where resourcetype_name ='$i';
delete from resourcetype where name='$i';
endOfMessage
	curl -X DELETE http://$1:9200/$i
done

psql -h $1 -Uvrasidas registry <<endOfMessage
delete from schemadatabase where originalurl like '%.xsd';
endOfMessage
