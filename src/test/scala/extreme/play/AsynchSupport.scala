package extreme.play

import argonaut._, Argonaut._
import scalaz._, Scalaz._
import org.purang.net.http._
import ning._

object AsynchSupport {

  implicit class ExecutedRequestOps(val executed: ExecutedRequest) extends AnyVal {


    def optionStatus: Option[Int] = executed.fold(
      t =>  None,
      r => Some(r._1)
    )

    def status: Int = executed.fold(
      t =>  -1,
      _._1
    )

    def body: Option[String] = executed.fold(
      _ => None,
      _._3
    )

    def json: Option[Json] = executed.fold(
      _ => None,
      _._3.flatMap(Parse.parseOption)
    )

    def assoc(key: String): Option[List[Json.JsonAssoc]] = {
      for {
        j <- json
        l <- j.assoc
      } yield l.filter(_._1 == key)
    }

    def value(key: String): Option[Json] = for {
      vl <- assoc(key)
      ho <- vl.headOption
    } yield ho._2

    def values(keys: String*): Seq[Json] = for {
      key <- keys
      vl <- assoc(key)
      ho <- vl.headOption
    } yield ho._2

    def toMap() : Option[Map[JsonField, Json]] = json.flatMap(_.obj.map(_.toMap))
  }

  implicit val RequestToExecutedRequestOps: Request => ExecutedRequestOps = r => ExecutedRequestOps(r ~> {
    x => x
  })
}