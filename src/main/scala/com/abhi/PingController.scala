package com.abhi
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.util.Future
import io.paradoxical.finatra.swagger.{SwaggerSupport}

case class Pong(message: String)
class PingController extends Controller with SwaggerSupport {
  implicit protected val swagger = PingSwaggerDocument  
  get("/ping", swagger { o => 
    o.summary("This is GET PING request")
    .tag("ping")
    .responseWith[Pong](200, "The Pong Message")
  }) { request: Request => 
    info("ping")
    val p = Pong("Result from GET /ping")
    Future.value(p)
  }
}