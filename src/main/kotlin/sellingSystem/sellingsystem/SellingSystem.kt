package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface SellingSystem {
  fun isWarehouseNotEmpty(): Boolean
  fun sayHello()
  fun sayBye()
  fun askForPositionToBuy(): Int
  fun askForQuantity(): Int
  fun askForBuying(): Boolean
  fun getFinalCalculation(cart:MutableList<PlantEntity>)
}