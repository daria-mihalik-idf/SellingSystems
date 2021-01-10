package sellingSystem.sellingsystem

import sellingSystem.plant.Sellable
import java.time.LocalDateTime

class PlantWrapper : Sellable {

  override fun getProfit(value: Int, profitPercent: Int): Int {
    var profit:Int = 0
    when (profitPercent) {
      in 1..99 -> {
        profit = value * profitPercent / 100
      }
      0 -> {
        println("Price without discount")
      }
      else -> {
        throw IllegalArgumentException("Incorrect profit value. Pls, verify it")
      }
    }
    return profit
  }

  override fun getSoldDate(): LocalDateTime {
    return LocalDateTime.now()
  }
}