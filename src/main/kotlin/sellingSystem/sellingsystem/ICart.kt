package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface ICart {
  fun countWithDiscount(discount: Int): Int
  fun isCardEmpty(): Boolean
  fun getCartCalculation(): Int
  fun printCart()
  fun addPositionToCard(plantEntityToCard: PlantEntity)
}