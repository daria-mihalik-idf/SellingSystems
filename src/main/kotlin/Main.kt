import sellingSystem.sellingsystem.Seller
import sellingSystem.sellingsystem.ISellingSystem

fun main() {
  val seller: ISellingSystem = Seller()

  seller.sayHello()
  if (seller.isWarehouseNotEmpty()) {
    while (seller.askForBuying()) {
      val position = seller.askForPositionToBuy()
      val quantity = seller.askForQuantity()
      seller.addToCard(position, quantity)
    }
    seller.getFinalCalculation()
  } else {
    seller.noSalesToday()
  }
  seller.sayBye()
}