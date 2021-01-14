package sellingSystem.sellingsystem

interface ISellingSystem {
  fun isWarehouseNotEmpty(): Boolean
  fun sayHello()
  fun sayBye()
  fun askForPositionToBuy(): Int
  fun askForQuantity(): Int
  fun askForBuying(): Boolean
  fun getFinalCalculation()
  fun addToCard(position: Int, quantity: Int)
  fun noSalesToday()
}