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
  import Fixtures._

  implicit def any2Future[A](a: => A) = Future {
    a
  }

  def ??? = throw new PendingException("pending exception", null, false, false)

  feature("Player registration") {
    info("allow players to register at http://localhost:9000/player/{uuid}")

    scenario("valid register") (pendingUntilFixed{
      Given("a valid payload")
      val payload =
        """{
          | "name" : "whatever",
          | "url" : "http://spray-it.herokuapp.com/play"
          |}
        """.stripMargin
      When("it is registered")
      val url = new URL(s"$serverToTest/player/")
      val post: HttpRequest = POST(url).addBody(payload).toRequest
      val deferredPost = post.apply

      def location: Headers => Option[String] = _.flatMap {
        _.list.find(_._1 == HttpHeaders.LOCATION).map(_._2)
      }

      val futureMaybeHeaderList : HttpResponse => Option[Headers] =
        response => if (response.code.code == 201)
          Option(response.headers)
        else
          None

        val locationHeader = (Await.result(deferredPost.flatMap(futureMaybeHeaderList(_).map(location(_))), 5.second))

        Then("a valid location is returned")
        locationHeader should not be(None)

        //locationHeader.getOrElse("") should (startWith(s"$serverToTest"))
      ???
    })

    scenario("invalid payload")(pendingUntilFixed {
      Given("an invalid payload")
      val payload =
        """{
          | "url" : "http://spray-it.herokuapp.com/play"
          |}
        """.stripMargin

      When("when it is registered")
      val url = new URL(s"$serverToTest/player/")
      val post: HttpRequest = POST(url).addBody(payload).toRequest
      val deferredPost = post.apply

      Then("bad request is raised")
      Await.result(deferredPost, 5.second).code.code  should be(400)
    })

  }
}

