package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plant.entity.PlantStock
import sellingSystem.plantData.DataSource
import sellingSystem.plantData.PlantDataProviderManager
import sellingSystem.plantData.PlantName
import sellingSystem.plantData.PlantName.*

class Warehouse : IWarehouse {
  private val plantStock: PlantStock = PlantDataProviderManager().getPlantData(DataSource.YAML)
  private val stock: MutableList<PlantEntity> = plantStock.entity

  override fun getStocks(): MutableList<PlantEntity> {
    return stock
  }

  override fun isStockEmpty(): Boolean {
    return stock.any {
      it.quantity > 0
    }
  }

  override fun getFromStocks(name: PlantName, plantQuantity: Int): PlantEntity? {
    var result: PlantEntity? = null
    if (stock.first().quantity >= plantQuantity) {
      when (name) {
        ROSE, GERBERA, LILIES, DWARFEUCALYPTUS -> {
          val requiredPlant: PlantEntity = stock.first { it.plant.name == name }
          val order: PlantEntity = requiredPlant.copy()
          order.quantity = plantQuantity
          val remainingQuantityOnStock = requiredPlant.quantity - plantQuantity
          requiredPlant.quantity = remainingQuantityOnStock
          result = order
        }
      }
    } else {
      println("Pls, enter correct value")
    }
    return result
  }
}