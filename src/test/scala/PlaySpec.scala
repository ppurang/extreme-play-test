/*
import extreme.play.test.PendingException
import java.util.UUID
import org.scalatest._

import com.stackmob.newman._
import org.scalatest.matchers.ShouldMatchers


class PlaySpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()
  //implicit val client = new ApacheHttpClient()

  before {

  }
  def ??? = throw new PendingException("pending exception", null, false, false)
  val uuid = UUID.randomUUID()

  feature("Play a player using the url") {
    info("It should be possible to play with a player using /play and a URL")

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

    scenario("play with incorrect answer")(pendingUntilFixed{
      Given("A valid player url that doesn't know the answer")
        val player = ???
        And("A question and answer")
        val q = "what is 10+20?"
        val a = 30
        val p = 100
      When("it is submitted to the /play?url=$url&q=$q&a=$a&p=$p")
      Then("response indicates a reward of -100 points")
      ???
    })

    scenario("play with player not responding within some time limit")(pendingUntilFixed{
      Given("A valid player url that doesn't respond within the given time limit")
        val player = ???
        And("A question and answer")
        val q = "what is 10+20?"
        val a = 30
        val p = 100
        val t = 10
      When("it is submitted to the /play?url=$url&q=$q&a=$a&p=$p&t=$t")
      Then("response indicates a reward of -1000 points")
      ???
    })

    scenario("play with player responding very slowly but correctly")(pendingUntilFixed{
      Given("A valid player url that responds slowly but correctly")
        val player = ???
        And("A question and answer")
        val q = "what is 10+20?"
        val a = 30
        val p = 100
      When("it is submitted to the /play?url=$url&q=$q&a=$a&p=$p&t=$t&s=$s")
      Then("response indicates a reward of 50 points")
      ???
    })

    scenario("play with player responding very slowly and incorrectly")(pendingUntilFixed{
      Given("A valid player url that responds slowly and incorrectly")
        val player = ???
        And("A question and answer")
        val q = "what is 10+20?"
        val a = 30
        val p = 100
      When("it is submitted to the /play?url=$url&q=$q&a=$a&p=$p&t=$t&s=$s")
      Then("response indicates a reward of -150 points")
      ???
    })



  }

}

*/
