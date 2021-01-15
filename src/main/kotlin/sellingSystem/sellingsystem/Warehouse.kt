package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plant.entity.PlantStock
import sellingSystem.plantData.DataSource
import sellingSystem.plantData.PlantDataProviderManager

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

  override fun getFromStocks(position: Int, quantity: Int): PlantEntity? {
    stock.forEach {
      if (it.id!! == position) {
        return if (it.quantity > 0) {
          val result = it.quantity - quantity
          it.quantity = result
          it.copy(quantity = quantity)
        } else {
          println("Quantity number is ${it.quantity}. Please reduce quantity")
          null
        }
      }
    }
    println("Choose other position")

    return null
  }
}