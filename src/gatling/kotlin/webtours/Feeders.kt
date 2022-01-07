package webtours

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.FeederBuilder

object Feeders {

    val city_depart: FeederBuilder.Batchable<String> = csv("city_depart.csv").random().eager()
    val city_arrive: FeederBuilder.Batchable<String> = csv("city_arrive.csv").random().eager()
}