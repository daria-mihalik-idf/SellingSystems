package sellingSystem.sellingsystem

import DISCOUNT_10
import PROFIT_PERCENT
import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plant.entity.PlantStock
import sellingSystem.plantData.DataSource
import sellingSystem.plantData.PlantDataProviderManager

class Seller : SellingSystem, Warehouse, Cart {

  private val plantStock: PlantStock = PlantDataProviderManager().getPlantData(DataSource.YAML)
  private val cart: MutableList<PlantEntity> = mutableListOf()
  private val stock: MutableList<PlantEntity> = mutableListOf()
  var quant: Int = 0

  override fun isWarehouseNotEmpty(): Boolean {
    var quantity:Int = 0
    var result: Boolean = false
    stock.filter {
      quantity += it.quantity!!
      result = quantity > 0
      return result
    }
    return result
  }

  override fun getStocks(): MutableList<PlantEntity> {
    for ((count, i) in (0..plantStock.entity.lastIndex).withIndex()) {
      stock.add(count, plantStock.entity[i])
    }
    stock.forEach { println(it.toString()) }
    return stock
  }

  override fun getPositionById(): MutableList<PlantEntity> {
    val positionByIndexList = mutableListOf<PlantEntity>()
    val ids = askForPositionToBuy(stock)
    quant = askForQuantity()
    stock.forEach {
      if (it.id!! == ids) {
        if (it.quantity!! > 0) {
          val result = it.quantity!! - quant
          it.quantity = result
          positionByIndexList.add(it)
        } else {
          println(
              "Quantity number is ${it.quantity}. Please reduce " +
                  "quantity or choose other position"
          )
        }
      }
    }
    return positionByIndexList
  }

  override fun countWithDiscount(discount: Int, cart: MutableList<PlantEntity>): Int {
    var total:Int = 0
    cart.forEach {
      total += it.price * it.quantity!!
    }

    when (discount) {
      in 1..99 -> {
        total -= (total * discount / 100)
      }
      0 -> {
        println("Price without discount")
      }
      else -> {
        throw IllegalArgumentException("Can't be sold with 100% discount. Pls, verify it")
      }
    }
    return total
  }

  override fun sayHello() {
    println("Hello! Today we offer you:")
    getStocks()
  }

  override fun sayBye() {
    println("Bye")
  }

  override fun askForContinuation(): Boolean {
    println("Would you like to continue? (Y/N)")
    return readLine()!!.toUpperCase() == "Y"
  }

  override fun askForPositionToBuy(stock: MutableList<PlantEntity>): Int {
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

  override fun getFinalCalculation() {
    if (!cart.isNullOrEmpty()) {
      val discount: Int = countWithDiscount(DISCOUNT_10, cart)
      if (cart.isNotEmpty()) {
        println("==============================")
        println("=============Total============")
        println("Total price with discount($DISCOUNT_10 %): $discount")

        println("==============================")
        println("Full list of sold plants: ")
        cart.forEach {
          println("Position : ${it.plant?.get(0)?.name}; quantity: ${it.quantity}; date of sold : ${it.dateSold}")
        }
        println("==============================")

        val wrapper: PlantWrapper = PlantWrapper()
        println("Total profit: ${wrapper.getProfit(discount, PROFIT_PERCENT)}")
      }
    }
  }

  override fun fillCart(count: Int) {
    val position: MutableList<PlantEntity> = getPositionById()
    if (position.isNotEmpty()) {
      position[0].dateSold = PlantWrapper().getSoldDate().toString()
      cart.add(count, position[0].copy())
      cart[cart.lastIndex].quantity = quant
    }
  }

  fun noSalesToday() {
    println("")
  }
}