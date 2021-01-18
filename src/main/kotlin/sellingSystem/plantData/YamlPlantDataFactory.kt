package sellingSystem.plantData

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import sellingSystem.plant.entity.PlantStock

class YamlPlantDataFactory : PlantDataProvider {

  override val filePath: String = "plantList.yaml"

  override fun getPlantData(): PlantStock {
    return resourceFileToObject(filePath, PlantStock::class.java) ?: throw IllegalStateException(
        "Data Source is empty")
  }

  @Suppress("UNCHECKED_CAST")
  fun <T> resourceFileToObject(filePath: String, objectClass: Class<T>): T? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)?.use {
      ObjectMapper(YAMLFactory())
          .registerModule(KotlinModule())
          .readValue(it, objectClass)
    }
  }
}