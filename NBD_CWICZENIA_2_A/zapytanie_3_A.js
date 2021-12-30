db.test.aggregate(
  {"$group": {
    _id:"$job"
  }}
)