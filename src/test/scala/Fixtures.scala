import com.typesafe.config.ConfigFactory

object Fixtures {
  val conf =  ConfigFactory.load()

  val serverToTest = Option(conf.getString("extreme.server")).getOrElse("http://localhost:9000")
  val playerToTest = Option(conf.getString("extreme.player")).getOrElse("http://localhost:5000")

}
