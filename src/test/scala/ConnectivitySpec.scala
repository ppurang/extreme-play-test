import extreme.play.test.PendingException
import java.util.UUID
import org.scalatest._

import com.stackmob.newman._
import com.stackmob.newman.dsl._
import java.net.URL
import org.scalatest.matchers.ShouldMatchers


class ConnectivitySpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()
  //implicit val client = new ApacheHttpClient()

  before {

  }
  def ??? = throw new PendingException("pending exception", null, false, false)
  val uuid = UUID.randomUUID()

  feature("Judge connectivity") {
    info("before registering check if the server can actually see the player at /connect?url={player url}")

    scenario("up")(pendingUntilFixed{
      Given("A valid player url")
      When("it is submitted to the /connect?url={player url}")
      Then("it returns a 200")
      ???
    })

    scenario("down")(pendingUntilFixed{
      Given("An invalid player url")
      When("it is submitted to the /connect?url={player url}")
      Then("it returns a 404")
      ???
    })
  }

}

