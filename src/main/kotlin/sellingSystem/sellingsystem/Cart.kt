package sellingSystem.sellingsystem

import sellingSystem.plant.Sellable
import sellingSystem.plant.entity.PlantEntity

object Cart : ICart, Sellable {

  override fun countWithDiscount(discount: Int, cart: MutableList<PlantEntity>): Int {
    var total: Int = 0
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

  override fun fillCart(count: Int, position: MutableList<PlantEntity>, cart: MutableList<PlantEntity>, quant: Int) {
    if (position.isNotEmpty()) {
      position[0].dateSold = getSoldDate().toString()
      cart.add(count, position[0].copy())
      cart[cart.lastIndex].quantity = quant
    }
  }
}