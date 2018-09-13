#!/bin/bash
PGPASSWORD=${2}
#for i in addenda event indicator manager measurement provider service einfrauser vocabulary; do
for i in application component corpus incompletecorpus language lexical corpusbuildingstate workflow operation filestats; do
#for i in incompletecorpus; do
	psql -h $1 -Uvrasidas registry <<endOfMessage
	delete from resourcetype_indexfield where resourcetype_name ='$i';
	delete from indexfield where resourcetype_name ='$i';

endOfMessage
 	for f in float string boolean integer; do
 		psql -h $1 -Uvrasidas registry <<endOfMessage
 		delete from ${f}indexedfield_values where ${f}indexedfield_id in (select id from ${f}indexedfield where resource_id in (select id from resource where fk_name='$i'));
 		delete from ${f}indexedfield where resource_id in (select id from resource where fk_name='$i');
endOfMessage
	done
	psql -h $1 -Uvrasidas registry <<endOfMessage
	delete from resourceversion where parent_id in ( select id from resource where fk_name='$i');
	delete from resource where fk_name='$i';
	delete from resourcetype where name='$i';
	drop view if exists $i._view;
endOfMessage
#	curl -X DELETE http://$1:8080/omtd-registry/resourceType/$i
curl -X DELETE http://$1:9222/$i
done


psql -h $1 -Uvrasidas registry <<endOfMessage
delete from schemadatabase where originalurl like '%.xsd';
endOfMessage
