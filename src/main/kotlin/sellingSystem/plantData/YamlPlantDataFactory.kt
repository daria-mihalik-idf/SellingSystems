package sellingSystem.plantData

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import sellingSystem.plant.entity.PlantEntity

class YamlPlantDataFactory : PlantDataProvider {

  override val filePath: String = "database.yaml"

  override fun getPlantData(): PlantEntity {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath).use {
      ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
          .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true).readValue(it, PlantEntity::class.java)
    }
  }
}