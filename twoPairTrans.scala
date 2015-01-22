//Datset 1
//100Vikram Elango 10000 2015-01-22 1000
//200Amanada clarke 10000 2015-01-22 1001
//300Emily Thorne 10000 2015-01-22 1002
//400David Clarke 10000 2015-01-22 1003
//500Daniel Grayson 10000 2015-01-22 1000
//600Conrad Grayson 10000 2015-01-22 1001
//700Nolan Ross 10000 2015-01-22 1002
//800Jack Porter 10000 2015-01-22 1003
//900Charlotte Clarke 10000 2015-01-22 1004

//Dataset2
//1000 Computer
//1001 Geek
//1002 Hacker
//1003 Bartender
//1005 Student

val myEmp = sc.textFile("/tmp/emp.txt")

val myDep = sc.textFile("/tmp/dep.txt")

 val myEmpPair = myEmp.map(x=>(x.split(" ")(5),x))
 //res5: Array[(String, String)] = Array((1000,100 Vikram Elango 10000 2015-01-22 1000), 
 //(1001,200 Amanada clarke 10000 2015-01-22 1001), (1002,300 Emily Thorne 10000 2015-01-22 1002),
 //(1003,400 David Clarke 10000 2015-01-22 1003), (1000,500 Daniel Grayson 10000 2015-01-22 1000),
 //(1001,600 Conrad Grayson 10000 2015-01-22 1001), (1002,700 Nolan Ross 10000 2015-01-22 1002),
 //(1003,800 Jack Porter 10000 2015-01-22 1003), (1004,900 Charlotte Clarke 10000 2015-01-22 1004))

val myDepPair = myDep.map((x=>(x.split(" ")(0),x))
//res6: Array[(String, String)] = Array((1000,1000 Computer), (1001,1001 Geek), (1002,1002 Hacker),
//(1003,1003 Bartender), (1005,1005 Student))

val mySub = myEmpPair.subtractByKey(myDepPair)
//res7: Array[(String, String)] = Array((1004,900 Charlotte Clarke 10000 2015-01-22 1004))

val mySub1 = myDepPair.subtractByKey(myEmpPair)
//res8: Array[(String, String)] = Array((1005,1005 Student))



