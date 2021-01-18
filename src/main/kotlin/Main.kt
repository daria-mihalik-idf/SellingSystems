import sellingSystem.sellingsystem.Seller
import sellingSystem.sellingsystem.ISellingSystem

fun main() {
  val seller: ISellingSystem = Seller()

  seller.sayHello()
  if (seller.isWarehouseNotEmpty()) {
    while (seller.askForBuying()) {
      val name = seller.askForPositionToBuy()
      val quantity = seller.askForQuantity()
      seller.addToCard(name, quantity)
    }
    seller.getFinalCalculation()
  } else {
    seller.noSalesToday()
  }
  seller.sayBye()
  seller.printProfitInfo()
}