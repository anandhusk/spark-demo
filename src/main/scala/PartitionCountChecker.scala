import Initializer.createSparkSession
import org.apache.spark.sql.functions.spark_partition_id

object PartitionCountChecker {
  def main(args: Array[String]): Unit = {
    val spark = createSparkSession("Simple Application")
    val path = getClass.getResource("Student_Data.csv").getPath
    spark.sparkContext.setLogLevel("ERROR")
    val df = spark
      .read
      .option("delimiter", "|")
      .option("header", value = true)
      .csv(path)

    df.show(false)
    println(df.count())
    println(df.rdd.getNumPartitions)
    df.repartition(2).select(spark_partition_id.as("part_id")).groupBy("part_id").count().show(false)
  }

}
