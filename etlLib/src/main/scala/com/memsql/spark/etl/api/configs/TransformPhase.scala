package com.memsql.spark.etl.api.configs

import spray.json._
import TransformPhaseKind._

case class UserTransformConfig(value: String) extends PhaseConfig

object TransformPhase extends DefaultJsonProtocol {
  val userConfigFormat = jsonFormat1(UserTransformConfig)

  def readConfig(kind: TransformPhaseKind, config: JsValue): PhaseConfig = {
    kind match {
      case TransformPhaseKind.User => userConfigFormat.read(config)
    }
  }

  def writeConfig(kind: TransformPhaseKind, config: PhaseConfig): JsValue = {
    kind match {
      case TransformPhaseKind.User => userConfigFormat.write(config.asInstanceOf[UserTransformConfig])
    }
  }
}