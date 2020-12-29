package sellingSystem.plantData

import sellingSystem.plant.entity.PlantEntity

class PlantDataProviderManager {
  fun getPlantData(file: FileType): PlantEntity {
    return when (file) {
      FileType.JSON -> {
        JsonPlantDataFactory().getPlantData()
      }
      FileType.YAML -> {
        YamlPlantDataFactory().getPlantData()
      }
    }
  }
}