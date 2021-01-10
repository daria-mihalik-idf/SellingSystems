package sellingSystem.plant

import java.time.LocalDateTime

interface Sellable {
  fun getProfit(value: Int, profitPercent: Int): Int
  fun getSoldDate(): LocalDateTime
}