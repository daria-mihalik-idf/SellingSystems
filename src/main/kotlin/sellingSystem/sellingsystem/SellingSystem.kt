package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface SellingSystem {
  fun isWarehouseNotEmpty(): Boolean
  fun sayHello()
  fun sayBye()
  fun askForContinuation(): Boolean
  fun askForPositionToBuy(stock: MutableList<PlantEntity>): Int
  fun askForQuantity(): Int
  fun askForBuying(): Boolean
  fun getFinalCalculation()
}