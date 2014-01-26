/*
import extreme.play.test.PendingException
import java.util.UUID
import org.scalatest._

import org.purang.net.http._
import org.purang.net.http.ning._


class VisibilityTestingSpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with Matchers with extreme.play.SystemUnderTest with AsynchSupport {

  def ??? = throw new PendingException("pending exception", null, false, false)
  val uuid = UUID.randomUUID()

  feature("Judge connectivity") {
    info("before registering check if the server can actually see the player at /connect?url={player url}")

    scenario("up"){
      Given("any valid url")
      implicit val player = "http://google.com"
      When("it is submitted to the /test?url={player url}")
      val url : String = visibility
      Then("it returns a 200")
      200 should === ((GET > url) : Int) //wth thanks
    }

    scenario("down"){
      Given("any invalid url")
      implicit val player = "http://localhozt"
      When("it is submitted to the /test?url={player url}")
      val url : String = visibility
      Then("it returns a 404")
      404 should === ((GET > url) : Int) //wth thanks
    }
  }

}

*/
