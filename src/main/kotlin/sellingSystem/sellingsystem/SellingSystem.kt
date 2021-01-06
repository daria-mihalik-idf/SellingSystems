package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface SellingSystem {

  fun getStocks(): MutableList<PlantEntity>

  fun getPositionById(id: Int, quantityPlant: Int, stock: MutableList<PlantEntity>): MutableList<PlantEntity>

  fun countWithDiscount(discount: Int, cart: MutableList<PlantEntity>): Int

  fun sayHello()

  fun sayBye()

  fun askForContinuation(): Boolean

  fun askForPositionToBuy(stock: MutableList<PlantEntity>): Int

  fun askForQuantity(): Int

  fun askForBuying(): Boolean

  fun getOrder(cart: MutableList<PlantEntity>)

  fun fillCart(position: MutableList<PlantEntity>, cart: MutableList<PlantEntity>, quantityPlant: Int, count: Int)
}