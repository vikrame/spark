//Input Data
error: file not found
warning: name node failure
error: null pointer exception
warning: hive issue

val inputRDD = sc.textFile("/tmp/error.txt")
val errRDD = inputRDD.filter(line=> line.contains("error"))
val warnRDD = inputRDD.filter(line=>line.contains("warn"))
val badRDD = errRDD.union(warnRDD)
