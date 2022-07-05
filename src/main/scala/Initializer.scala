import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Initializer {

  def createSparkSession(appName: String): SparkSession = {
    val sc = new SparkConf()
      .setMaster("local[2]")
      .setAppName(appName)

    SparkSession.builder().config(sc).getOrCreate()
  }
}
