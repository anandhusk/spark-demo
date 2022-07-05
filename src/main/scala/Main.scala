import Initializer.createSparkSession

object Main {
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
  }
}