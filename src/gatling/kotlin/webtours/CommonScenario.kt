package webtours

import io.gatling.javaapi.core.CoreDsl.*
import kotlin.random.Random
import webtours.Actions.chooseFF
import webtours.Actions.chooseFlight
import webtours.Actions.getUserSession
import webtours.Actions.login
import webtours.Actions.openHomePage
import webtours.Actions.openFlights
import webtours.Actions.paymentData
import webtours.Feeders.city_depart
import webtours.Feeders.city_arrive

object CommonScenario {

    val scn = scenario("Buy simple flight")
        .feed(city_depart)
        .feed(city_arrive)
        .exec(openHomePage)
        .exec(getUserSession)
        .exec(login)
        .exec(openFlights)
        .exec(chooseFlight)
        .exec(chooseFF)
        .exec(paymentData)
        .exec(openHomePage)
}