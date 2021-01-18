package sellingSystem.sellingsystem

import sellingSystem.plantData.PlantName

interface ISellingSystem {
  fun isWarehouseNotEmpty(): Boolean
  fun sayHello()
  fun sayBye()
  fun askForPositionToBuy(): PlantName
  fun askForQuantity(): Int
  fun askForBuying(): Boolean
  fun getFinalCalculation()
  fun addToCard(name: PlantName, quantity: Int)
  fun printProfitInfo()
  fun noSalesToday()
}