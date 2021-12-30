db.test.aggregate(
  {
    $unwind:{
      path:"$credit"
    }
  },
  { 
    $addFields:{
   doubleCreditBalance:{
     $convert:{
        input: "$credit.balance",
        to: "double",
        onError: "$credit.balance"
        }
      } 
    }
  },
  {
    $group:{
      _id: "$credit.currency",
      doubleCreditBalance:{$sum:"$doubleCreditBalance"}
    }
  }
  )