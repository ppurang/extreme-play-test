import com.typesafe.config.ConfigFactory

object Fixtures {
  val conf =  ConfigFactory.load()

  val serverToTest = Option(conf.getString("extreme.server")).getOrElse("http://localhost:9000")

}
