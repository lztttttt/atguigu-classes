package com.atguigu.bigdata.spark.core.wc
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {

  def main(args: Array[String]): Unit = {
    val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparConf)
    val lines: RDD[String] = sc.textFile(path = "datas")
    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordGroup: RDD[(String, Iterable[String])] = words.groupBy(word=>word)
    val wordToCount = wordGroup.map{
      case(word,list) => {
        (word, list.size)
      }
    }
    val res: Array[(String, Int)] = wordToCount.collect()
    res.foreach(println)
    sc.stop()
  }
}
