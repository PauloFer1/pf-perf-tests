package simulation

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

class BasicSimulation extends Simulation {
  val httpConf = http.baseURL("https://www.google.com/")
  val scn = scenario("Basic Simulation")
    .exec(http("request_1")
      .get(""))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
