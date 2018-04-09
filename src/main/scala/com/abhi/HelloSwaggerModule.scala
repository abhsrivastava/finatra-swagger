package com.abhi

import com.jakehschwartz.finatra.swagger.SwaggerModule
import io.swagger.models.{Info, Swagger}
import javax.inject.Singleton
import com.google.inject.Provides

object HelloSwaggerModule extends SwaggerModule {
  @Singleton
  @Provides
  def swagger: Swagger = {
    val swagger = new Swagger()
    val info = new Info()
    info
      .description("This is Hello World Project")
      .version("1.0.0")
      .title("Hello World API")
    swagger
      .info(info)
    swagger
  }
}
