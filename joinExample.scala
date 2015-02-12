//emp.dat

100 Vikram Elango 10000 2015-01-22 1000
200 Amanada clarke 10000 2015-01-22 1001
300 Emily Thorne 10000 2015-01-22 1002
400 David Clarke 10000 2015-01-22 1003
500 Daniel Grayson 10000 2015-01-22 1000
600 Conrad Grayson 10000 2015-01-22 1001
700 Nolan Ross 10000 2015-01-22 1002
800 Jack Porter 10000 2015-01-22 1003
900 Charlotte Clarke 10000 2015-01-22 1004

//dep.dat

1000 Computer
1001 Geek
1002 Hacker
1003 Bartender
1005 Student

//Code

val empRDD = sc.textFile("/tmp/vikram/emp.dat")
val empPairRDD = empRDD.map( x => (x.split(" ")(5).toInt, x))
val depRDD = sc.textFile("/tmp/vikram/dep.dat")
val depPairRDD = depRDD.map( x=> (x.split(" ")(0).toInt, x))
val joinRDD = empPairRDD.join(depPairRDD)
val finalRDD = joinRDD.map{ case(key, value) => (key, value._1.split(" ")(1) + "," + value._2.split(" ")(1))}
finalRDD.saveAsTextFile("/tmp/vikram/output")

//Output
-sh-4.1$ cd output
-sh-4.1$ ls -lrt
total 8
-rw-r--r-- 1 nbsalpid alpided 84 Feb 12 10:20 part-00001
-rw-r--r-- 1 nbsalpid alpided 86 Feb 12 10:20 part-00000
-rw-r--r-- 1 nbsalpid alpided  0 Feb 12 10:20 _SUCCESS
-sh-4.1$ cat part-00001
(1001,Amanada,Geek)
(1001,Conrad,Geek)
(1003,David,Bartender)
(1003,Jack,Bartender)
-sh-4.1$ cat part-00000
(1002,Emily,Hacker)
(1002,Nolan,Hacker)
(1000,Vikram,Computer)
(1000,Daniel,Computer)
