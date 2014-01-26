package extreme.play

import com.typesafe.config.{Config, ConfigFactory}
import net.ceedubs.ficus.FicusConfig._
import org.purang.net.http._
import AsynchSupport._
import Utils._

trait SystemUnderTest extends SUTConfig {
  //System.setProperty("asynch.debug", "true")

  //make sure that the SUT's up and returning 200 for "/"
  require(eventually(5)(breather(200))(() => {
      (GET > root).optionStatus
    }) == Some(200), "Is the server to be tested up and running?"
  )
}


trait SUTConfig {
  lazy val config = ConfigFactory.load("test.conf")

  val sut = config.as[Config]("sut")
  val urls = sut.as[Config]("urls")

  def root = urls.as[String]("root")
  def registration = urls.as[String]("registration")
  def unregister(implicit serverid: String) = urls.as[String]("unregister").format(serverid)
  def visibility(implicit playerUrl: String) = urls.as[String]("visibility").format(playerUrl)
}
