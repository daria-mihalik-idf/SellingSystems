package sellingSystem.sellingsystem
import sellingSystem.plant.entity.PlantEntity

class Flower : SellingSystem {

//    fun getPrice(type: PlantType): Int {
//    return when (type) {
//      PlantType.ROSE -> Rose().getPlantPrice()
//      PlantType.GERBERA -> Gerbera().getPlantPrice()
//      PlantType.LILIES -> Lilies().getPlantPrice()
//      else -> throw IllegalArgumentException("No flowers")
//    }
//  }

  override val plantEntity: PlantEntity = TODO()

  override fun getStocks() {
    TODO("Not yet implemented")
  }
//
//  fun orderPlant(type: PlantType): String {
//  }
}