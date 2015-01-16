//Action RDDs

//Data
val myAction = sc.parallelize(List(1,2,3,3))
//myAction: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[20] at parallelize at <console>:12

//Collect
myAction.collect
//res8: Array[Int] = Array(1, 2, 3, 3)

//Count
myAction.count()
res9: Long = 4

//Count By Value
//Number of times each element occurs in the RDD

myAction.countByValue()
//res10: scala.collection.Map[Int,Long] = Map(1 -> 1, 2 -> 1, 3 -> 2)

