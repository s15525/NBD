var mapFunction = function() {
  emit(this.job,1)
};

var reduceFunction = function(Key, Values) {
    return Array.sum(Values);
};

db.test.mapReduce(
    mapFunction,
    reduceFunction,
    {
		out: "map_reduce",
	}
);