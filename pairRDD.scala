//line1| This is line number 10
//line2| This is line number 11
//line3| This is line number 12
//line4| This is line number 13
//line1| This is line number 14
//line2| This is line number 15
//line3| This is line number 16
//line4| This is line number 17

val input = sc.textFile("/tmp/vikram.txt")

val pairRDD = input.map(x => (x.split(" ")(0), x))
//res2: Array[(String, String)] = Array((line1,line1 This is line number 10), (line2,line2 This is line number 11), 
//(line3,line3 This is line number 12), (line4,line4 This is line number 13), (line1,line1 This is line number 14), 
//(line2,line2 This is line number 15), (line3,line3 This is line number 16), (line4,line4 This is line number 17))
 
//Group By key
val myGroup = pairRDD.groupByKey()

myGroup.collect()
//res3: Array[(String, Iterable[String])] = Array((line2,CompactBuffer(line2 This is line number 11, line2 This is line number 15)),
//(line4,CompactBuffer(line4 This is line number 13, line4 This is line number 17)), 
//(line3,CompactBuffer(line3 This is line number 12, line3 This is line number 16)), 
//(line1,CompactBuffer(line1 This is line number 10, line1 This is line number 14)))

myGroup.count()
//res4: Long = 4

val pRDD = input.map(x => (x.split(" ")(0), x.split(" ")(5)))
//pRDD: org.apache.spark.rdd.RDD[(String, String)] = MappedRDD[6] at map at <console>:14

pRDD.collect()
//res5: Array[(String, String)] = Array((line1,10), (line2,11), (line3,12), (line4,13), 
//(line1,14), (line2,15), (line3,16), (line4,17))

val myRBK = pRDD.reduceByKey((x,y) => x+y )

myRBK.collect()
//To be checked again -> + on String is causing concatenation. Not sure how to cast it int/long at this point in time
//res6: Array[(String, String)] = Array((line2,1115), (line4,1317), (line3,1216), (line1,1014))

val myMV = pairRDD.mapValues(x=> x.split(" ")(5) + " Hi")
//res8: Array[(String, String)] = Array((line1,10 Hi), (line2,11 Hi), (line3,12 Hi), 
//(line4,13 Hi), (line1,14 Hi), (line2,15 Hi), (line3,16 Hi), (line4,17 Hi))

val myKeys = pairRDD.keys() // Does not work :S

val myKeys = pairRDD.keys
//res9: Array[String] = Array(line1, line2, line3, line4, line1, line2, line3, line4)

val myValues = pairRDD.values
//res11: Array[String] = Array(line1 This is line number 10, line2 This is line number 11, 
//line3 This is line number 12, line4 This is line number 13, line1 This is line number 14, 
//line2 This is line number 15, line3 This is line number 16, line4 This is line number 17)

 val mySort = pairRDD.sortByKey()
 //res12: Array[(String, String)] = Array((line1,line1 This is line number 10), (line1,line1 This is line number 14), 
 //(line2,line2 This is line number 11), (line2,line2 This is line number 15), 
 //(line3,line3 This is line number 12), (line3,line3 This is line number 16), 
 (line4,line4 This is line number 13), (line4,line4 This is line number 17))
