package com.abhi

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.filters.CommonFilters
import com.jakehschwartz.finatra.swagger.DocsController

object HelloServerMain extends HelloServer
class HelloServer extends HttpServer {
  override protected def modules = Seq(HelloSwaggerModule)
  override def defaultFinatraHttpPort = ":8080"
  override def configureHttp(router: HttpRouter) = {
    router
      .filter[CommonFilters]
      .add[HelloController]
      .add[DocsController]
  }
}