package sellingSystem.sellingsystem

import DISCOUNT_10
import PROFIT_PERCENT
import sellingSystem.plant.Sellable
import sellingSystem.plant.entity.PlantEntity

class Seller : SellingSystem, Sellable {
  private var stock: MutableList<PlantEntity> = mutableListOf()

  override fun isWarehouseNotEmpty(): Boolean {
    var result: Boolean = false
    stock = Warehouse.getStocks()
    stock.any { it ->
      result = it.quantity!! > 0
      if (result) {
        stock.forEach { println(it.toString()) }
      } else {
        println("Stocks are empty")
      }
      return result
    }
    return result
  }

  override fun sayHello() {
    println("Hello! Today we offer you:")
  }

  override fun sayBye() {
    println("Bye")
  }

  override fun askForPositionToBuy(): Int {
    println("Type position to buy: ")
    var position = readLine()?.toInt()!!
    val lastId = stock[stock.lastIndex].id!!
    while (lastId < position) {
      println("Position with this index is absent. Please type other one...")
      position = readLine()?.toInt()!!
    }
    return position
  }

  override fun askForQuantity(): Int {
    println("Type quantity: ")
    return readLine()?.toInt()!!
  }

  override fun askForBuying(): Boolean {
    println("Would you like smth to buy? (Y/N)")
    val action: String = readLine()!!
    return action.toUpperCase() == "Y"
  }

  override fun getFinalCalculation(cart: MutableList<PlantEntity>) {
    if (!cart.isNullOrEmpty()) {
      printOrder(Cart.countWithDiscount(DISCOUNT_10, cart), cart)
    }
  }

  private fun printOrder(priceWithDiscount: Int, cart: MutableList<PlantEntity>) {
    println("==============================")
    println("=============Total============")
    println("Total price with discount($DISCOUNT_10 %): $priceWithDiscount")

    println("==============================")
    println("Full list of sold plants: ")
    cart.forEach {
      println("Position : ${it.plant?.get(0)?.name}; quantity: ${it.quantity}; date of sold : ${it.dateSold}")
    }
    println("==============================")

    println("Total profit: ${getProfit(priceWithDiscount, PROFIT_PERCENT)}")
  }

  fun noSalesToday() {
    println("")
  }
}