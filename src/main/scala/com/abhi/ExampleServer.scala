package com.abhi

import com.twitter.finagle.http.{Response, Request}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter
import io.paradoxical.finatra.swagger.SwaggerController
import io.swagger.models.Info

class ExampleServer extends HttpServer {

  PingSwaggerDocument.info(new Info()
      .description("Ping as a service")
      .version("0.0.1")
      .title("Pinged Piper")
  )
  
  override def defaultFinatraHttpPort = ":9999"
  override def configureHttp(router: HttpRouter) = {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add(new SwaggerController(swagger = PingSwaggerDocument))
      .add[PingController]
  }
}