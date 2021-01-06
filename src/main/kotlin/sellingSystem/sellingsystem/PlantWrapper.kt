package sellingSystem.sellingsystem

import sellingSystem.plant.Sellable
import java.time.LocalDateTime

class PlantWrapper : Sellable {

  override fun getProfit(value: Int, profitPercent: Int): Int {
    return value * profitPercent / 100
  }

  override fun getSoldDate(): LocalDateTime {
    return LocalDateTime.now()
  }
}