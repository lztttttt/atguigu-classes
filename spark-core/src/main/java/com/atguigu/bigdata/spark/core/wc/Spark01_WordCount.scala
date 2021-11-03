package com.atguigu.bigdata.spark.core.wc
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {

  def main(args: Array[String]): Unit = {
    val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext()
    sc.stop()
  }
}
