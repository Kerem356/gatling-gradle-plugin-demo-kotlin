package webtours

import io.gatling.javaapi.core.CoreDsl.*
import kotlin.random.Random
import webtours.Actions.chooseFF
import webtours.Actions.chooseFlight
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
        .pause(Random.nextLong(0, 3))
        .exec(login)
        .pause(Random.nextLong(0, 3))
        .exec(openFlights)
        .pause(Random.nextLong(0, 3))
        .exec(chooseFlight)
        .pause(Random.nextLong(0, 3))
        .exec(chooseFF)
        .pause(Random.nextLong(0, 3))
        .exec(paymentData)
        .pause(Random.nextLong(0, 3))
        .exec(openHomePage)
}