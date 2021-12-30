db.test.aggregate(
  {
    "$unwind":{
      path: "$credit"
    }
  },
  {
    "$match":{
      "nationality":'Poland'
    }
  },
  {
    "$addFields":{
      doubleCreditBalance:{
      "$convert":{
        input: "$credit.balance",
        to: "double"
      }
      }
    }
  },
   {"$group": {
    _id:"$credit.currency",
    creditBalanceAVG:{$avg:"$doubleCreditBalance"},
    creditBalanceSUM:{$sum:"$doubleCreditBalance"}
  }}
  )