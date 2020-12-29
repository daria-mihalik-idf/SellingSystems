package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface SellingSystem {
  val plantEntity: PlantEntity

  fun getStocks()

//  fun orderPlant(type: PlantType): String
}