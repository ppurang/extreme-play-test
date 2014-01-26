package extreme.play

import org.specs2._
import org.purang.net.http._
import TestDataGen._
import AsynchSupport._

class RegistrationSpec extends Specification with SystemUnderTest   {
  sequential

  def is = s2"""
    extreme.play.RegistrationSpec

    The SUT should
      register valid requests                           $register
      not register already known names                  $knownName
      not register already known url                    $knownUrl
      not register already known url variation          $knownUrlVariation
      un-register valid request                         ${`un-register`}
                                                        """


  def registerRequest(json: String = aRegistrationJson()): Request = POST > registration >> ContentType(ApplicationJson) >>> json

  def register = (registerRequest() status) must ===(201)    //todo check for location header

  def knownName = {
    val known = aName
    val req = registerRequest(aRegistrationJson(name = known))
    req.status must ===(201)

    val reqKN = registerRequest(aRegistrationJson(name = known))
    reqKN.status must ===(409)
  }

  def knownUrl = {
    val knownUrl = aUrl
    val req = registerRequest(aRegistrationJson(url = knownUrl))
    req.status must ===(201)

    val reqKU = registerRequest(aRegistrationJson(url = knownUrl))
    reqKU.status must ===(409)
  }

  def knownUrlVariation = {
    val knownUrl = aUrl
    val req = registerRequest(aRegistrationJson(url = knownUrl))
    req.status must ===(201)

    val reqV = registerRequest(aRegistrationJson(url = s"$knownUrl/"))
    reqV.status must ===(409)
  }

  def `un-register` = {
    val Some((id, secret)) = for {
      map <- registerRequest().toMap()
      serverId <- map.get("serverId")
      playerAuth <- map.get("playerAuth")
      id <- serverId.string
      secret <- playerAuth.string
    } yield (id, secret)

    (DELETE > unregister(id) >> ("player-auth-key" `:` secret)).status must ===(204)
  }

}