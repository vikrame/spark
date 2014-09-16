
//  Launch Spark Scala Shell:

// First, launch Spark Scala Shell like described in first lab exercise
// and then run the following commands.

// Create some data programmatically to create a new RDD
// and then run some commands on RDD using the API.

val data = 1 to 10000

// create an RDD based on that data
val distData = sc.parallelize(data)

// use a filter to select values less than 10
distData.filter(_ < 10).collect()

distData.filter(_ < 10).collect().foreach(println)

distData.cache

// Try collect method again after calling cache.
distData.filter(_ < 10).collect().foreach(println)


// Simple Spark Apps: WordCount
// Word Count on a local file

val f = sc.textFile("README.md")
f.count()
