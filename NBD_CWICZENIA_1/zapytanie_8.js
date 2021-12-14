db.test.updateMany(
  {
    "location.city":"Moscow"
    
  },{
    $set:{"location.city":"Moskwa"}
  })