ar heightvar =
db.test.aggregate([
    {"$addFields":{
        "heightDouble":{
            "$convert":{
                input: "$height",
                to: "double",
                onError:"$height"
            }
        }
    }},
    {"$match":{
        "heightDouble":{
                $gte:190
            }
    }}
]).map(function(d) {
    return d._id;
});

heightvar.forEach(function(myDoc) {
    db.test.deleteOne( {"_id": myDoc});
});