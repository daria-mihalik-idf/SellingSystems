package sellingSystem.sellingsystem

import DISCOUNT_10
import PROFIT_PERCENT
import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plantData.DataSource
import sellingSystem.plantData.PlantDataProviderManager

class Seller : SellingSystem {

  private val value = PlantDataProviderManager().getPlantData(DataSource.YAML)

  var isWarehouseNotEmpty = {
    var result = 0
    for (i in 0..value?.entity?.lastIndex!!) {
      result += value.entity!![i].quantity!!
    }
    result > 0
  }

  override fun getStocks(): MutableList<PlantEntity> {
    val stock: MutableList<PlantEntity> = mutableListOf()
    for ((count, i) in (0..value?.entity?.lastIndex!!).withIndex()) {
      stock.add(count, value.entity!![i])
      println("id = ${value.entity!![i].id} " +
          "name = ${value.entity!![i].plant?.get(0)?.name} " +
          "type = ${value.entity!![i].plant?.get(0)?.type} " +
          "price = ${value.entity!![i].price} " +
          "quantity = ${value.entity!![i].quantity} " +
          "date received = ${value.entity!![i].dateReceived} ")
    }
    return stock
  }

  override fun getPositionById(id: Int, quantityPlant: Int, stock: MutableList<PlantEntity>): MutableList<PlantEntity> {
    val positionByIndexList = mutableListOf<PlantEntity>()
    stock.forEach {
      if (it.id!! == id) {
        if (it.quantity!! > 0) {
          val result = it.quantity!! - quantityPlant
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
    var total = 0
    cart.forEach {
      total += it.price * it.quantity!!
    }
    total -= (total * discount / 100)
    return total
  }

  override fun sayHello() {
    println("Hello! Today we offer you:")
  }

  override fun sayBye() {
    println("Bye")
  }

  override fun askForContinuation(): Boolean {
    println("Would you like to continue? (Y/N)")
    return readLine()!!.toUpperCase().equals("Y")
  }

  override fun askForPositionToBuy(stock: MutableList<PlantEntity>): Int {
    println("Type position to buy: ")
    val lastId = stock[stock.lastIndex].id!!
    var position = readLine()?.toInt()!!
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
    return action.toUpperCase().equals("Y")
  }

  override fun getOrder(cart: MutableList<PlantEntity>) {
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

  override fun fillCart(position: MutableList<PlantEntity>, cart: MutableList<PlantEntity>, quantityPlant: Int,
      count: Int) {
    if (position.isNotEmpty()) {
      position[0].dateSold = PlantWrapper().getSoldDate().toString()
      cart.add(count, position[0].copy())
      cart[cart.lastIndex].quantity = quantityPlant
    }
  }
}