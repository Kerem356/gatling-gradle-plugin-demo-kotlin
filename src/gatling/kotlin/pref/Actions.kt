package pref

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*

object Actions {

    val getMainPage = http("getMainPage")
            .get("/")
            .check(status().`is`(200))

}