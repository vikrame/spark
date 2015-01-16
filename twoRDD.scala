//Transformations involing two RDDs

//Dataset 1
val data1 = sc.parallelize(List(1,2,3))
//data1: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[6] at parallelize at <console>:12

//Dataset 2
val data2 = sc.paralleize(List(3,4,5))
//data2: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[7] at parallelize at <console>:12

//Union
val myUnion = data1.union(data2)
//myUnion: org.apache.spark.rdd.RDD[Int] = UnionRDD[8] at union at <console>:16

myUnion.collect()
//res4: Array[Int] = Array(1, 2, 3, 3, 4, 5)

//Intersection
val myInter = data1.intersection(data2)
//myInter: org.apache.spark.rdd.RDD[Int] = MappedRDD[14] at intersection at <console>:16

myInter.collect()
//res5: Array[Int] = Array(3)

//Subtract
val mySub = data1.subtract(data2)
//mySub: org.apache.spark.rdd.RDD[Int] = MappedRDD[18] at subtract at <console>:16

mySub.collect()
//res6: Array[Int] = Array(1, 2)

//Cartesian
val myCart = data1.cartesian(data2)
//myCart: org.apache.spark.rdd.RDD[(Int, Int)] = CartesianRDD[19] at cartesian at <console>:16

myCart.collect()
//res7: Array[(Int, Int)] = Array((1,3), (1,4), (1,5), (2,3), (2,4), (2,5), (3,3), (3,4), (3,5))
