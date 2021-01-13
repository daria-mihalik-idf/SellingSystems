import sellingSystem.plant.entity.PlantEntity
import sellingSystem.sellingsystem.Cart
import sellingSystem.sellingsystem.Seller
import sellingSystem.sellingsystem.Warehouse

const val DISCOUNT_10 = 10
const val PROFIT_PERCENT = 30

fun main() {
  val seller: Seller = Seller()
  val cart: MutableList<PlantEntity> = mutableListOf()
  var count: Int = 0

  seller.sayHello()
  if (seller.isWarehouseNotEmpty()) {
    while (seller.askForBuying()) {
      val position = seller.askForPositionToBuy()
      val quantity = seller.askForQuantity()
      Cart.fillCart(count++, Warehouse.getPositionById(position, quantity), cart, quantity)
    }
    seller.getFinalCalculation(cart)
  } else {
    seller.noSalesToday()
  }
  seller.sayBye()
}