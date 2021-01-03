package sellingSystem.plantData

import sellingSystem.plant.entity.PlantStock

interface PlantDataProvider {

  val filePath: String

  fun getPlantData(): PlantStock?
}