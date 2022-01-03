package pref

import io.gatling.javaapi.core.*

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import pref.perf.httpProtocol

class Debug: Simulation() {

    init {
        setUp(CommonScenario.scn.injectOpen(atOnceUsers(1)))
                .protocols(httpProtocol)
    }
}