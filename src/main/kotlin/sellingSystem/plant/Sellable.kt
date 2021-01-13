package sellingSystem.plant

import java.time.LocalDateTime

interface Sellable {
  fun getProfit(value: Int, profitPercent: Int): Int {
    var profit: Int = 0
    when (profitPercent) {
      in 1..99 -> {
        profit = value * profitPercent / 100
      }
      0 -> {
        println("You sold without profit")
      }
      else -> {
        throw IllegalArgumentException("Incorrect profit value. Pls, verify it")
      }
    }
    return profit
  }

  fun getSoldDate(): LocalDateTime {
    return LocalDateTime.now()
  }
}