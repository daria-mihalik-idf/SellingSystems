import sellingSystem.plant.entity.PlantEntity
import sellingSystem.sellingsystem.Seller

const val DISCOUNT_10 = 10
const val PROFIT_PERCENT = 30

fun main() {

  val cart: MutableList<PlantEntity> = mutableListOf()
  val stock : MutableList<PlantEntity>
  var count = 0

  var quantityPlant: Int? = 0

  val seller: Seller = Seller()
  seller.sayHello()

  stock = seller.getStocks()
  var action = seller.askForBuying()
  if (seller.isWarehouseNotEmpty()) {
    while (action) {
      val id: Int = seller.askForPositionToBuy(stock)

      quantityPlant = seller.askForQuantity()

      val position: MutableList<PlantEntity> = seller.getPositionById(id, quantityPlant, stock)

      seller.fillCart(position, cart, quantityPlant, count++)

      action = seller.askForContinuation()
    }
    seller.getOrder(cart)
  } else {
    seller.sayBye()
  }
}