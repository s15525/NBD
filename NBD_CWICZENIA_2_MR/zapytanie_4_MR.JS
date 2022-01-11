var mapFunction = function() {
  var weight = parseFloat(this.weight);
	var height = parseFloat(this.height);
	var heightTo2 = height * height;
	var bmi = weight/heightTo2;
  emit(this.nationality,bmi)
};

var reduceFunction = function(Key, Values) {
    map ={
    bmiAvg:0,
    bmiMin:0,
    bmiMax:0
    }
    var count = 0;
    var bmiSum = 0;
    map.bmiMin = Values[0];
    map.bmiMax = Values[0];
    for(var i = 1; i<Values.length; i++){
		bmiSum += Values[i];
		map.bmiMin = Math.min(map.bmiMin,Values[i]);
		map.bmiMax = Math.max(map.bmiMax,Values[i]);
		count += 1;
	}
	  map.bmiAvg = bmiSum/count;
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