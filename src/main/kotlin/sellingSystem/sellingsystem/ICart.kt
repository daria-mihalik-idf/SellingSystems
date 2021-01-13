package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface ICart {
  fun countWithDiscount(discount: Int, cart: MutableList<PlantEntity>): Int
  fun fillCart(count: Int, position: MutableList<PlantEntity>, cart: MutableList<PlantEntity>, quant: Int)
}