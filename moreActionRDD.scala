//Dataset
val myNumber = sc.parallelize(List(1,2,3,4,5,6,7,8,9))


//Reduce
//Takes in a function which operates on elements of same type 
//Returns element of same type
//Performs sum count and other aggregation operations.
val myReduce = myNumber.reduce( (x,y) => x+y )
//myReduce: Int = 45

//Aggregate
//Same as reduce, but returns different typeof argument

 val result = myNumber.aggregate((0,0))(
 | (a,b) => (a._1+b, a._2+1),
 | (a1,a2) => (a1._1+a2._1, a1._2+a2._2))

//result: (Int, Int) = (45,9)

//Calcualte Avg
 val avg = result._1 / result._2
//avg: Int = 5
