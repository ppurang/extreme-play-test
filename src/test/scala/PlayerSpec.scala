import com.stackmob.newman.request.HttpRequest
import com.stackmob.newman.response.HttpResponse
import com.stackmob.newman.SprayHttpClient
import extreme.play.test.PendingException
import java.nio.charset.Charset
import java.util.UUID
import org.apache.http.HttpHeaders
import org.scalatest.exceptions.{TestFailedException, TestPendingException}
import org.scalatest._

import com.stackmob.newman._
import java.net.URL
import org.scalatest.matchers.ShouldMatchers
import scala.concurrent.{Await, Future}
import com.stackmob.newman.dsl._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._



class PlayerSpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()

  before {

  }
  def ??? = throw new PendingException("pending exception", null, false, false)
  val uuid = UUID.randomUUID()

}

