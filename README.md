|||| LISTE DES COMMANDES POUR INITIALISER REPLICA SET ET SHARDS|||


docker exec -it configsvr mongosh --port 27017


rs.initiate({
_id: "configReplSet",
configsvr: true,
members: [{ _id: 0, host: "configsvr:27017" }]
})

docker restart mongos ??


docker exec -it shard1_mongo1 mongosh --port 27017


rs.initiate({
_id: "shard1ReplSet",
members: [
{ _id: 0, host: "shard1_mongo1:27017" },
{ _id: 1, host: "shard1_mongo2:27017" },
{ _id: 2, host: "shard1_arbiter:27017", arbiterOnly: true }
]
})


docker exec -it shard2_mongo1 mongosh --port 27017

rs.initiate({
_id: "shard2ReplSet",
members: [
{ _id: 0, host: "shard2_mongo1:27017" },
{ _id: 1, host: "shard2_mongo2:27017" },
{ _id: 2, host: "shard2_arbiter:27017", arbiterOnly: true }
]
})



docker exec -it mongos mongosh --port 27017

sh.addShard("shard1ReplSet/shard1_mongo1:27017")
sh.addShard("shard2ReplSet/shard2_mongo1:27017")

A CETTE ETAPE, RELANCER LE CONTENEUR APP QUI EST SUREMENT DOWN

sh.enableSharding("mongoprojectdb2")

use mongoprojectdb2
db.commandes.createIndex({ date: 1})
sh.shardCollection("mongoprojectdb2.commandes", { date: 1 })
var dateLimite = ISODate("2015-02-26T00:00:00Z")
sh.addShardTag("shard1ReplSet", "recent")
sh.addShardTag("shard2ReplSet", "old")

sh.addTagRange(
"mongoprojectdb2.orders",
{ orderDate: MinKey },
{ orderDate: dateLimite },
"old"
)
{


sh.addTagRange(
"mongoprojectdb2.orders",
{ orderDate: dateLimite },
{ orderDate: MaxKey },
"recent"
)
{

var splitDate = new ISODate("2015-02-26T00:00:00Z");

sh.splitAt("mongoprojectdb2.commandes", { "date": splitDate });

sh.status()

vous devriez voir :

chunks: [
{ min: { date: MinKey() }, max: { date: ISODate('2015-02-26T00:00:00.000Z') }, 'on shard': 'shard1ReplSet', 'last modified': Timestamp({ t: 2, i: 0 }) },
{ min: { date: ISODate('2015-02-26T00:00:00.000Z') }, max: { date: MaxKey() }, 'on shard': 'shard2ReplSet', 'last modified': Timestamp({ t: 2, i: 1 }) }

RESTART LE CONTAINER APP AU CAS OU
