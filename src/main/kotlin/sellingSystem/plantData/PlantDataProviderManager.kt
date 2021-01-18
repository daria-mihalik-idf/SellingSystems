package sellingSystem.plantData

import sellingSystem.plant.entity.PlantStock

class PlantDataProviderManager {
  fun getPlantData(file: DataSource): PlantStock {
    return when (file) {
      DataSource.YAML -> {
        YamlPlantDataFactory().getPlantData()
      }
    }
  }
}