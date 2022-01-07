package webtours

import io.gatling.javaapi.core.*
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import webtours.CommonScenario.scn
import java.time.Duration

class BuyFlight : Simulation() {

    private val httpProtocol = http
        .baseUrl("http://www.load-test.ru:1080")
        .inferHtmlResources(AllowList(), DenyList())
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
        .upgradeInsecureRequestsHeader("1")
        .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")

//    init {
//        setUp(
//            scn.injectOpen(
//                atOnceUsers(1),
//
//            )
//        )
//            .protocols(httpProtocol)
//            .maxDuration(Duration.ofHours(1))
//    }

    init {
        setUp(
            scn.injectOpen(
                incrementUsersPerSec(1.0)
                .times(10)
                .eachLevelLasting(60)
                .separatedByRampsLasting(3)
                .startingFrom(1.0)
            )
        )
            .protocols(httpProtocol)
            .maxDuration(Duration.ofMinutes(61))
    }
}
