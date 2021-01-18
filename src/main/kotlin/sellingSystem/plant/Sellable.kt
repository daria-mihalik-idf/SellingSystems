package sellingSystem.plant

import java.time.LocalDateTime

interface Sellable {
  fun getSoldDate(): String {
    return LocalDateTime.now().toString()
  }
}