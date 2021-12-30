db.test.aggregate(
  {
    "$addFields":{
      "heightDouble":{
            "$convert":{
                input: "$height",
                to: "double"
            }
        },
		"weightDouble":{
            "$convert":{
                input: "$weight",
                to: "double"
            }
        }
    }
  },
  {
    "$addFields":{
      "squareHeight":{$multiply:["$heightDouble","$heightDouble"]}
    }
  },
  {
    "$addFields":{
      "BMIAVG":{$divide:["$weightDouble","$squareHeight"]},
      "BMIMIN":{$divide:["$weightDouble","$squareHeight"]},
      "BMIMAX":{$divide:["$weightDouble","$squareHeight"]}
    }
  }
  ,{"$group": {
    _id:"$nationality",
    BMIAVG:{$avg:"$BMIAVG"},
    BMIMIN:{$min:"$BMIMIN"},
    BMIMAX:{$max:"$BMIMAX"}
  }}
  )