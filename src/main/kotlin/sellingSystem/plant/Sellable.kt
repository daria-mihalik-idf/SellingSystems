package sellingSystem.plant

import java.time.LocalDateTime

interface Sellable {
  fun getSoldDate(): LocalDateTime {
    return LocalDateTime.now()
  }
}