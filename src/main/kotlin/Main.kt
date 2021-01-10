import sellingSystem.sellingsystem.Seller

const val DISCOUNT_10 = 10
const val PROFIT_PERCENT = 30

fun main() {
  val seller:Seller = Seller()
  var count:Int = 0

  seller.sayHello()
  if (seller.isWarehouseNotEmpty()) {
    var isReadyToBuy = seller.askForBuying()
    while (isReadyToBuy) {

      seller.fillCart(count++)

      isReadyToBuy = seller.askForContinuation()
    }
    seller.getFinalCalculation()
  } else {
    seller.noSalesToday()
  }
  seller.sayBye()
}