package extreme.play


object TestDataGen {
  import com.nicta.rng.Rng
  import Rng._

  implicit def run[T]: Rng[T] => T = r => r.run.unsafePerformIO()

  def aName : String = alphas1(20).map(_.list.mkString)

  def aUrl : String = s"http://$aName"

  def aRegistrationJson(name: String = aName, url: String = aUrl) : String = s"""{"name": "$name", "url" : "$url"}"""

}