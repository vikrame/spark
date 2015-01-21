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
 
