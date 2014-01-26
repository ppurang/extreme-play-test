/*
import extreme.play.test.PendingException
import java.util.UUID
import org.scalatest._

import com.stackmob.newman._
import org.scalatest.matchers.ShouldMatchers


class ScoringSpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()
  //implicit val client = new ApacheHttpClient()

  def ??? = throw new PendingException("pending exception", null, false, false)
  val uuid = UUID.randomUUID()

  feature("") {
    info("")

    scenario("play with correct answer")(pendingUntilFixed{
      Given("A valid player url that knows the answer")
        val player = ???
        And("A question and answer")
        val q = "what is 10+20?"
        val a = 30
        val p = 100
      When("it is submitted to the /play?url=$url&q=$q&a=$a&p=$p")
      Then("response indicates a reward of 100 points")
      ???
    })

  }

}

*/
