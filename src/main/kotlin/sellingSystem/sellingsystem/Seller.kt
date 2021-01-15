package sellingSystem.sellingsystem

import sellingSystem.plant.Sellable
import sellingSystem.plant.entity.PlantEntity

private const val DISCOUNT_10 = 10

class Seller : ISellingSystem, Sellable {
  private var warehouse: IWarehouse = Warehouse()
  private var cart: ICart = Cart()

  override fun isWarehouseNotEmpty(): Boolean {
    return warehouse.isStockEmpty()
  }

  override fun sayHello() {
    println("Hello! Today we offer you:")
  }

  override fun sayBye() {
    println("Bye")
  }

  private fun printStock() {
    println(warehouse.getStocks())
  }

  override fun askForPositionToBuy(): Int {
    println("Type position to buy: ")
    return readLine()?.toInt()!!
  }

  override fun askForQuantity(): Int {
    println("Type quantity: ")
    return readLine()?.toInt()!!
  }

  override fun askForBuying(): Boolean {
    printStock()
    println("Would you like smth to buy? (Y/N)")
    val action: String = readLine()!!
    return action.toUpperCase() == "Y"
  }

  override fun getFinalCalculation() {
    if (cart.isCardEmpty()) {
      println("We have no order")
    } else {
      val discount = DISCOUNT_10
      val countWithDiscount = cart.countWithDiscount(discount)
      printOrder(countWithDiscount, discount)
    }
  }

  override fun addToCard(position: Int, quantity: Int) {
    val plantFromWarehouse: PlantEntity? = warehouse.getFromStocks(position, quantity)
    plantFromWarehouse?.let {
      cart.addPositionToCard(it)
    }
  }

  private fun printOrder(finalPrice: Int, discount: Int = 0) {
    println("==============================")
    println("=============Total============")
    println("Total price ($discount %): $finalPrice")

    println("==============================")
    println("Full list of sold plants: ")
    cart.printCart()
    println("==============================")
  }

  override fun noSalesToday() {
    println("Sorry. No sales today.")
  }
}