package com.abhi

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.util.Future
import io.paradoxical.finatra.swagger.SwaggerSupport

class PingController extends Controller with SwaggerSupport {
  implicit protected val swagger = PingSwaggerDocument  
  get("/ping", swagger { o => 
    o.summary("This is GET PING request")
    .tag("ping")
    .responseWith[Pong](200, "The Pong Message")
  }) { request: Request => 
    info("get to ping")
    val p = Pong("Result from GET /ping")
    Future.value(p)
  }
  post("/ping", swagger { o=> 
    o.summary("This is POST PING request")
    .tag("Ping")
    .bodyParam[PingRequest]("Custom Ping Request Message")
    .responseWith[Pong](200, "The custom pong message")
  }) { request: PingRequest => 
    info("post to ping")
    Pong(s"${request.message} received and was processed")
  }
}