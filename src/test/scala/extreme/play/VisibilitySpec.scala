package extreme.play

import org.specs2._
import org.purang.net.http._
import AsynchSupport._

class VisibilitySpec extends Specification with SystemUnderTest {
  def is = s2"""
    extreme.play.VisibilitySpec

    The SUT should
      validate visible urls                             $visible
      invalidate invisible urls                         $invisible
                                                        """

  def visible = (GET > visibility("http://google.com") status) must ===(200)

  def invisible =  (GET > visibility("http://localhozt") status) must ===(404)

}