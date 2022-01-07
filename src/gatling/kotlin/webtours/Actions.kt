package webtours

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import io.gatling.javaapi.http.HttpRequestActionBuilder

object Actions {

    val openHomePage: HttpRequestActionBuilder = http("open homePage")
        .get("/webtours/")
        .resources(
            http("get userSession")
                .get("/cgi-bin/nav.pl?in=home")
                .check(css("[name='userSession']", "value").exists())
                .check(css("[name='userSession']", "value").saveAs("userSession"))
        )

    val login: HttpRequestActionBuilder = http("login")
        .post("/cgi-bin/login.pl")
        .formParam("userSession", "#{userSession}")
        .formParam("username", "gatl1")
        .formParam("password", "gatl1")
        .formParam("login.x", "43")
        .formParam("login.y", "14")
        .formParam("JSFormSubmit", "off")

    val openFlights: HttpRequestActionBuilder = http("openFlights")
        .get("/cgi-bin/welcome.pl?page=search")

    val chooseFlight: HttpRequestActionBuilder = http("chooseFlight")
        .post("/cgi-bin/reservations.pl")
        .formParam("advanceDiscount", "0")
        .formParam("depart", "#{city_depart}")
        .formParam("departDate", "01/05/2022")
        .formParam("arrive", "#{city_arrive}")
        .formParam("returnDate", "01/06/2022")
        .formParam("numPassengers", "1")
        .formParam("seatPref", "None")
        .formParam("seatType", "Coach")
        .formParam("findFlights.x", "24")
        .formParam("findFlights.y", "5")
        .formParam(".cgifields", "roundtrip")
        .formParam(".cgifields", "seatType")
        .formParam(".cgifields", "seatPref")
        .check(css("[name='outboundFlight']","value").exists())
        .check(css("[name='outboundFlight']","value").findRandom().saveAs("outboundFlight_type"))

    val chooseFF: HttpRequestActionBuilder = http("chooseFF")
        .post("/cgi-bin/reservations.pl")
        .formParam("outboundFlight", "#{outboundFlight_type}")
        .formParam("numPassengers", "1")
        .formParam("advanceDiscount", "0")
        .formParam("seatType", "Coach")
        .formParam("seatPref", "None")
        .formParam("reserveFlights.x", "44")
        .formParam("reserveFlights.y", "9")

    val paymentData: HttpRequestActionBuilder =  http("paymentDetails")
        .post("/cgi-bin/reservations.pl")
        .formParam("firstName", "")
        .formParam("lastName", "")
        .formParam("address1", "")
        .formParam("address2", "")
        .formParam("pass1", " ")
        .formParam("creditCard", "")
        .formParam("expDate", "")
        .formParam("oldCCOption", "")
        .formParam("numPassengers", "1")
        .formParam("seatType", "Coach")
        .formParam("seatPref", "None")
        .formParam("outboundFlight", "#{outboundFlight_type}")
        .formParam("advanceDiscount", "0")
        .formParam("returnFlight", "")
        .formParam("JSFormSubmit", "off")
        .formParam("buyFlights.x", "11")
        .formParam("buyFlights.y", "2")
        .formParam(".cgifields", "saveCC")
}