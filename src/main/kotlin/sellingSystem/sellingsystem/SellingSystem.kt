package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plant.entity.PlantStock

interface SellingSystem {

  fun getStocks(): PlantStock?

  fun getPositionById(id: Int, quantity: Int): MutableList<PlantEntity>

  fun countWithDiscount(discount: Int, cart: MutableList<PlantEntity>, count: Int): Int

  fun rewriteYaml(list: MutableList<PlantEntity>)
}