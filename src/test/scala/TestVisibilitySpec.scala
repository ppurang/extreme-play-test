import com.stackmob.newman.response.HttpResponse
import extreme.play.test.PendingException
import java.util.UUID
import org.scalatest._

import com.stackmob.newman._
import com.stackmob.newman.dsl._
import scala.concurrent._
import scala.concurrent.duration._
import java.net.URL
import org.scalatest.matchers.ShouldMatchers


class TestVisibilitySpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()

  feature("Judge connectivity") {
    info("before registering check if the server can actually see the player at /test?url={player url}")

    scenario("up"){
      Given("A valid player url")
      val url = "http://localhost:5000/"
      When("it is submitted to the /test?url={player url}")
      val xtreme = s"http://localhost:9000/test?url=$url"
      Then("it returns a 200")
      val response: HttpResponse = Await.result(GET(new URL(xtreme)).toRequest.apply, 1 second)
      response.code.code should be(200)
    }

    scenario("down")(pendingUntilFixed{
      Given("An invalid player url")
      When("it is submitted to the /test?url={player url}")
      Then("it returns a 404")
      throw new PendingException("pending exception", null, false, false)
    })
  }

}

