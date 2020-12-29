package sellingSystem.plantData

interface PlantDataProvider {

  val filePath: String

  fun getPlantData(): Any
}