db.test.aggregate([
   {
    $addFields:{
     doubleWeight:{
       $convert:{
         input: "$weight",
         to: "double"
       }
     },
     doubleHeight:{
       $convert:{
         input:"$height",
         to: "double"
       }
     }
   }},
   { $group:{
      _id : "$sex", 
      avg_weight : {$avg : "$doubleWeight"},
      avg_height : {$avg : "$doubleHeight"}
    }
  }
])