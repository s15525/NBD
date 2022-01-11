var mapFunction = function() {
  values = {
    floatWeight:parseFloat(this.weight),
    floatHeight:parseFloat(this.height)
  }
	emit(this.sex,values);
};

var reduceFunction = function(Key, Values) {
    map = {
      weight:0,
      height:0,
      countGroup:0 
    }
    for(var i = 0; i<Values.length; i++){
      map.weight += Values[i].floatWeight
      map.height += Values[i].floatHeight
      map.countGroup += 1
    }
    
    map.weight = map.weight/map.countGroup
    map.height = map.height/map.countGroup
    
    return map;
};

db.test.mapReduce(
    mapFunction,
    reduceFunction,
    {
		out: "map_reduce",
	}
);

db.map_reduce.find({}).toArray();