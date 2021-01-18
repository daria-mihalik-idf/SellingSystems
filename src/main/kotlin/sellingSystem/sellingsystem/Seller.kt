package sellingSystem.sellingsystem

import sellingSystem.plant.Sellable
import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plantData.PlantName

private const val DISCOUNT_10 = 10
const val PROFIT_PERCENT = 30

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

  override fun askForPositionToBuy(): PlantName {
    println("Type name to buy: ")
    val plantName = readLine()?.toUpperCase()?:throw IllegalArgumentException("Incorrect plant name")
    return PlantName.valueOf(plantName)
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
      val finalPrice = cart.countWithDiscount(discount)
      printOrder(finalPrice, discount)
    }
  }

  override fun addToCard(name: PlantName, quantity: Int) {
    val plantFromWarehouse: PlantEntity? = warehouse.getFromStocks(name, quantity)
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

  override fun printProfitInfo() {
    val profitPercent = PROFIT_PERCENT
    val finalProfit = cart.countWithDiscount(profitPercent) * 0.3

    println("==============================")
    println("=============Total profit============")
    println("Total profit ($profitPercent %): $finalProfit")

    println("==============================")
    println("Full list of sold plants: ")
    cart.printCart()
    println("==============================")
  }

  override fun noSalesToday() {
    println("Sorry. No sales today.")
  }
}