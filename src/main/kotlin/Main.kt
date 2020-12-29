import sellingSystem.plant.entity.FlowerPlant
import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plant.entity.TreePlant
import sellingSystem.plantData.FileType
import sellingSystem.plantData.PlantDataProviderManager
import sellingSystem.sellingsystem.SellingSystem
import kotlin.reflect.full.memberProperties

fun main() {
  println("Do you want to get a full list of plants? Yes/No")
  val result = readLine()
  if (result == "Yes") {
    PlantWrapper(PlantDataProviderManager().getPlantData(FileType.YAML)).getStocks()
  } else if (result == "No") {
    println("Exit from system")
  }
}

class PlantWrapper(override val plantEntity: PlantEntity) : SellingSystem {
  override fun getStocks() {
    for (prop in PlantEntity::class.memberProperties) {
      println("${prop.get(plantEntity)}")
    }
  }
}

fun getPlantPrice1(list: MutableList<FlowerPlant>, flower: String): Int {
  var flowerPrice = 0
  list.forEach {
    if (it.name == flower) flowerPrice = it.price
  }
  return flowerPrice
}

fun getPlantPrice2(list: MutableList<TreePlant>, tree: String): Int {
  var treePrice = 0
  list.forEach {
    if (it.name == tree) treePrice = it.price
  }
  return treePrice
}