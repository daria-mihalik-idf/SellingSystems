import sellingSystem.plant.entity.PlantEntity
import sellingSystem.sellingsystem.PlantWrapper

const val DISCOUNT_10 = 10
const val PROFIT_PERCENT = 30


class Main {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      println("Hello! Today we offer you:")
      val stock = PlantWrapper()
      stock.getStocks()

      val cart = mutableListOf<PlantEntity>()
      println("Would you like smth to buy? (Y/N)")
      var action = readLine()

      var count = 0
      val map = emptyMap<String?, Int?>().toMutableMap()

      while (action?.toUpperCase().equals("Y") && !action.isNullOrBlank() && action.isNotEmpty()) {
        println("Type position to buy: ")
        val inputText = readLine()

        println("Type quantity: ")
        val quantityPlant = readLine()?.toInt()
        val position = stock.getPositionById(inputText?.toInt()!!, quantityPlant!!)

        if (position.isNotEmpty()) {
          println("Position was added to cart -> ${position[position.lastIndex].name} : $quantityPlant")
          map[position[position.lastIndex].name] = quantityPlant
          cart.add(count++, position[0])
        }

        println("Would you like to continue? (Y/N)")
        action = readLine()

        val discount = stock.countWithDiscount(DISCOUNT_10, cart, quantityPlant)
        if (cart.isNotEmpty()) {
          println("Total price with discount($DISCOUNT_10 %): $discount")

          println("Full list of sold plants: ")
          map.forEach {
            println("${it.key} : ${it.value}")
          }
          println("Total profit ${stock.getProfit(discount, PROFIT_PERCENT)}")
          println("Sold date ${stock.getSoldDate()}")
        }
      }
      if (action?.toUpperCase().equals("N")) {
        println("bye")
      }
    }
  }
}