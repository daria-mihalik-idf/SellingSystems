package sellingSystem.sellingsystem

import sellingSystem.plant.Sellable
import sellingSystem.plant.entity.PlantEntity

class Cart : ICart, Sellable {
  private var cartStorage: MutableList<PlantEntity> = mutableListOf()

  override fun printCart() {
    cartStorage.forEach {
      println("Position : ${it.plant.name}; quantity: ${it.quantity}; date of sold : ${it.dateSold}")
    }
  }

  override fun addPositionToCard(plantEntityToCard: PlantEntity) {
    plantEntityToCard.dateSold = getSoldDate().toString()
    cartStorage.add(plantEntityToCard)
  }

  override fun isCardEmpty(): Boolean {
    return cartStorage.isEmpty()
  }

  override fun getCartCalculation(): Int {
    var total: Int = 0

    cartStorage.forEach {
      total += it.price * it.quantity
    }
    return total
  }

  override fun countWithDiscount(discount: Int): Int {
    val totalPrice = getCartCalculation()
    var totalPriceWithDiscount = 0
    when (discount) {
      in 1..99 -> {
        totalPriceWithDiscount = (totalPrice * (100 - discount) / 100)
      }
      0 -> {
        totalPriceWithDiscount = totalPrice
        println("Price without discount")
      }
      else -> {
        throw IllegalArgumentException("Discount percent  $discount is invalid. Pls, verify it")
      }
    }
    return totalPriceWithDiscount
  }
}