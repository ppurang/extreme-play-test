import com.stackmob.newman.request.HttpRequest
import com.stackmob.newman.response.HttpResponse
import extreme.play.test.PendingException
import java.util.UUID
import org.apache.http.HttpHeaders
import org.scalatest._

import com.stackmob.newman._
import java.net.URL
import org.scalatest.matchers.ShouldMatchers
import scala.concurrent.{Await, Future}
import com.stackmob.newman.dsl._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._


class RegisterSpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()

  def ??? = throw new PendingException("pending exception", null, false, false)

  feature("Player registration") {
    info("allow players to register at http://localhost:9000/player/{uuid}")

    scenario("valid register") (pendingUntilFixed{
      Given("a valid payload")
      val payload =
        """{
          | "name" : "whatever",
          | "url" : "http://localhost:5000/play"
          |}
        """.stripMargin
      When("it is registered with a valid uuid")
      val url = new URL(s"http://localhost:9000/player/")
      val put: HttpRequest = POST(url).addBody(payload).toRequest
      val deferredPut = put.apply

      /*      val future = for {
        response <- executedPut
        if response.code.code == 201
        headers <- Future{response.headers}
      } yield headers*/



      def header : HeaderList => Option[Header]= _.list.find(h => h._1 == "Location")

      implicit def any2Future[A](a: => A) = Future {
        a
      }

      def location: Headers => Option[String] = _.flatMap {
        _.list.find(_._1 == HttpHeaders.LOCATION).map(_._2)
      }

      val futureMaybeHeaderList : HttpResponse => Option[Headers] =
        response => if (response.code.code == 201)
          Option(response.headers)
        else
          None


        println(Await.result(deferredPut.flatMap(futureMaybeHeaderList(_)), 1.second))

        Then("a valid location is returned")
        // val location = put.map(_.map(_.headers.map(_.list.filter(_._1 == "Location"))).get.headOption)
        //location.unsafePerformIO() should be (Option(List("Location" -> s"http://localhost:9000/player/$uuid" )))
        And("the player can be retrieved")
      //GET(url).executeUnsafe.code should be(200)
    })

    scenario("invalid payload")(pendingUntilFixed {
      Given("an invalid payload")
      When("when it is registered with a valid uuid")
      Then("bad request is raised")
      ???
    })

  }
}

