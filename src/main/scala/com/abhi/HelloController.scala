package com.abhi

import com.jakehschwartz.finatra.swagger.SwaggerController
import javax.inject.Inject
import io.swagger.models.Swagger
import com.twitter.finagle.http.{Request, Response}

class HelloController @Inject()(s: Swagger) extends SwaggerController {
  override implicit protected val swagger = s
  getWithDoc("/hello/:name") { o => 
    o.summary("Say Hello to the person")
     .tag("Hello")
     .routeParam[String]("name", "name of the person")
     .responseWith[String](200, "Hello person")
  } {request : Request => 
    val name = request.getParam("name")
    response.ok.json(s"Hello $name")
  }
}