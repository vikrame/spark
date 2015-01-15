//Create RDD using Parallelize command

val myList = sc.parallelize(List(1,2,3,4,4))
//myList: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:12

//Transformation RDD

//Map
val myMap = myList.map(x=>x+1)
//myMap: org.apache.spark.rdd.RDD[Int] = MappedRDD[1] at map at <console>:14

myMap.collect()
//res1: Array[Int] = Array(2, 3, 4, 5, 5)

//Flatmap
val myFlatMap = myList.flatMap(x=>x.to(3))
//myFlatMap: org.apache.spark.rdd.RDD[Int] = FlatMappedRDD[2] at flatMap at <console>:14

myFlatMap.collect()
//res2: Array[Int] = Array(1, 2, 3, 2, 3, 3)

//Filter
val myFilter = myList.filter(x=> x!=4)
//myFilter: org.apache.spark.rdd.RDD[Int] = FilteredRDD[3] at filter at <console>:14

myFilter.collect()
//res3: Array[Int] = Array(1, 2, 3)
