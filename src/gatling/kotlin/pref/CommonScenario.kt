package pref

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*

//object CommonScenario {
//    fun apply() = CommonScenario().scn
//}

object CommonScenario {

    val scn = scenario("Com scen1")
            .exec(Actions.getMainPage)

}