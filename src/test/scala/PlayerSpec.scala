import com.stackmob.newman.response.HttpResponse
import com.stackmob.newman.SprayHttpClient
import java.nio.charset.Charset
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import com.stackmob.newman._
import com.stackmob.newman.dsl._
import java.net.URL
import org.scalatest.matchers.ShouldMatchers
import scalaz.CharSet

class PlayerSpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()
  //implicit val client = new ApacheHttpClient()

  before {

  }

  feature("Player registration and withdrawl") {
    info("It is all about player's lifecycle")
    //info("I should be able to register myself")

    scenario("register") {

      Given("A valid payload")
      val payload =
        """{
          | "name" : "whatever",
          | "uri" : "http://someotherhost:8080/play"
          |}
        """.stripMargin
      When("the payload is posted to the correct api endpoint")
      val url = new URL("http://localhost:9000/player")
      val post = POST(url)
      post.addBody(payload)

      Then("a valid location is returned")
      post.prepareAsync.map(_.map(_.headers.map(_.list.filter(_._1 == "Location"))).get.headOption).unsafePerformIO() should be (Option(List("Location" -> "http://localhost:9000/player/1" )))
    }

  }
}

