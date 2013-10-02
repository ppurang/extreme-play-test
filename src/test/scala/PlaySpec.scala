import extreme.play.test.PendingException
import java.util.UUID
import org.scalatest._

import com.stackmob.newman._
import org.scalatest.matchers.ShouldMatchers


class PlaySpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter with ShouldMatchers {
  implicit val client = new SprayHttpClient()

  before {

  }
  def ??? = throw new PendingException("pending exception", null, false, false)
  val uuid = UUID.randomUUID()

}

