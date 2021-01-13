package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plant.entity.PlantStock
import sellingSystem.plantData.DataSource
import sellingSystem.plantData.PlantDataProviderManager

object Warehouse : IWarehouse {
  private val plantStock: PlantStock = PlantDataProviderManager().getPlantData(DataSource.YAML)
  private val stock: MutableList<PlantEntity> = mutableListOf()

  override fun getStocks(): MutableList<PlantEntity> {
    for ((count, i) in (0..plantStock.entity.lastIndex).withIndex()) {
      stock.add(count, plantStock.entity[i])
    }
    return stock
  }

  override fun getPositionById(id: Int, quantity: Int): MutableList<PlantEntity> {
    val positionByIndexList = mutableListOf<PlantEntity>()
    stock.forEach {
      if (it.id!! == id) {
        if (it.quantity!! > 0) {
          val result = it.quantity!! - quantity
          it.quantity = result
          positionByIndexList.add(it)
        } else {
          println(
              "Quantity number is ${it.quantity}. Please reduce " +
                  "quantity or choose other position"
          )
        }
      }
    }
    return positionByIndexList
  }
}