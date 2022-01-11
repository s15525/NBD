var mapFunction = function() {
  if(this.nationality=='Poland'&&this.sex=='Female'){
		for(var i = 0; i<this.credit.length; i++){
			emit(this.credit[i].currency,parseFloat(this.credit[i].balance));
		}	
	}
};

var reduceFunction = function(Key, Values) {
   map = {
      sumBalance:0,
      avgBalance:0
   }
   var count = 0
   for(var i = 0; i<Values.length; i++){
		map.sumBalance +=Values[i];
		count += 1;
	}
	map.avgBalance = map.sumBalance/count;
	return map
};

db.test.mapReduce(
    mapFunction,
    reduceFunction,
    {
		out: "map_reduce",
	}
);

db.map_reduce.find({}).toArray();