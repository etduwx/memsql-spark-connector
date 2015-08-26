package com.memsql.spark.interface.api

import com.memsql.spark.etl.api._
import com.memsql.spark.etl.api.configs.PhaseConfig

case class PipelineInstance(extractor: ByteArrayExtractor,
                            extractConfig: PhaseConfig,
                            transformer: ByteArrayTransformer,
                            transformConfig: PhaseConfig,
                            loader: Loader,
                            loadConfig: PhaseConfig)