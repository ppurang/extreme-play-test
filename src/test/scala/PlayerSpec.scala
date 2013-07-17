import com.stackmob.newman.response.HttpResponse
import com.stackmob.newman.SprayHttpClient
import extreme.play.test.PendingException
import java.nio.charset.Charset
import java.util.UUID
import org.scalatest.exceptions.{TestFailedException, TestPendingException}
import org.scalatest._

import com.stackmob.newman._
import com.stackmob.newman.dsl._
import java.net.URL
import org.scalatest.matchers.ShouldMatchers
import scalaz.CharSet


class PlayerSpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()

  before {

  }
  def ??? = throw new PendingException("pending exception", null, false, false)
  val uuid = UUID.randomUUID()

  feature("Player registration") {
    info("allow players to register at http://localhost:9000/player/{uuid}")

    scenario("valid register") {
      Given("a valid payload")
      val payload =
        """{
          | "name" : "whatever",
          | "uri" : "http://someotherhost:8080/play"
          |}
        """.stripMargin
      When("it is registered with a valid uuid")
      val url = new URL(s"http://localhost:9000/player/$uuid")
      val put = PUT(url).addBody(payload).prepareAsync

      Then("a valid location is returned")
      val location = put.map(_.map(_.headers.map(_.list.filter(_._1 == "Location"))).get.headOption)
      location.unsafePerformIO() should be (Option(List("Location" -> s"http://localhost:9000/player/$uuid" )))
      And("the player can be retrieved")
      GET(url).executeUnsafe.code should be(200)
    }

    scenario("invalid uuid")(pendingUntilFixed{
      Given("an invalid uuid")
      When("it is registered")
      Then("bad request is raised")
      ???
    })

    scenario("invalid payload")(pendingUntilFixed {
      Given("an invalid payload")
      When("when it is registered with a valid uuid")
      Then("bad request is raised")
      ???
    })

  }

  //should this even be allowed?
  feature("Player withdrawl") {
    info("allow players to withdraw  at http://localhost:9000/player/{uuid}")
    //info("I should be able to register myself")

    scenario("withdrawl") {
      Given("a valid player uuid")
      val wuuid = UUID.randomUUID()
      val payload =
        """{
          | "name" : "whatever",
          | "uri" : "http://someotherhost:8080/play"
          |}
        """.stripMargin
      val url = new URL(s"http://localhost:9000/player/$wuuid")
      PUT(url).addBody(payload).executeUnsafe.code should be(201)

      When("the player withdraws using delete")
      DELETE(url).executeUnsafe
      Then("that player isn't registered anymore")
      GET(url).executeUnsafe.code should be(404)
    }

    scenario("invalid uuid")(pendingUntilFixed{
      Given("an invalid uuid")
      When("it is withdrawn")
      Then("bad request is raised")
      ???
    })

    scenario("not found")(pendingUntilFixed {
      Given("a valid uuid that hasn't been registered")
      When("it is withdrawn")
      Then("not found is raised")
      ???
    })

  }






}

