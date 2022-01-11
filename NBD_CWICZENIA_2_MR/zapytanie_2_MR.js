var mapFunction = function() {
  for(var i = 0; i<this.credit.length; i++){
		emit(this.credit[i].currency,parseFloat(this.credit[i].balance));
	}
};

var reduceFunction = function(Key, Values) {
    var counter = 0
    for(var i = 0; i<Values.length; i++){
		counter += Values[i]
	  }
    return counter;
};

db.test.mapReduce(
    mapFunction,
    reduceFunction,
    {
		out: "map_reduce",
	}
);

db.map_reduce.find({}).toArray();