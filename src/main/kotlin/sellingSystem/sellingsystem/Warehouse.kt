package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plant.entity.PlantStock
import sellingSystem.plantData.DataSource
import sellingSystem.plantData.PlantDataProviderManager
import java.util.stream.Collectors

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

  override fun getFromStocks(position: Int, plantQuantity: Int): PlantEntity {
    val value = stock.filter { it.id == position && it.quantity > 0 }
    val result = value[0].quantity - plantQuantity
    value[0].quantity = result
    return value[0].copy(quantity = plantQuantity)
  }
}