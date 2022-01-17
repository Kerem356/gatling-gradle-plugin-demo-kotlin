package webtours

import io.gatling.javaapi.core.*
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import webtours.CommonScenario.scn
import java.time.Duration

class LongBuyFlight : Simulation() {

    private val httpProtocol = http
        .baseUrl("http://www.load-test.ru:1080")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
        .upgradeInsecureRequestsHeader("1")
        .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
        .disableCaching()

    init {
        setUp(
        scn.injectClosed(
            rampConcurrentUsers(0).to(5).during(60),
            constantConcurrentUsers(5).during(3540)
        )
        )
            .protocols(httpProtocol)
            .maxDuration(Duration.ofMinutes(70))
    }
}