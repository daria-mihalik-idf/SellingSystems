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

//  override fun getPositionById(id: Int, quantity: Int): MutableList<PlantEntity> {
//    val positionByIndexList = mutableListOf<PlantEntity>()
//    stock.forEach {
//      if (it.id!! == id) {
//        if (it.quantity > 0) {
//          val result = it.quantity - quantity
//          it.quantity = result
//          positionByIndexList.add(it)
//        } else {
//          println(
//              "Quantity number is ${it.quantity}. Please reduce " +
//                  "quantity or choose other position"
//          )
//        }
//      }
//    }
//    return positionByIndexList
//  }

  override fun isStockEmpty(): Boolean {
    return stock.any {
      it.quantity > 0
    }
  }

  override fun getFromStocks(position: Int, quantity: Int): List<PlantEntity> {
    /*
    1. из стока нужно по позиции , равна ид, получить штуки растений и сохранять их , чтобы вернуть дальше, где просили
    2. из стока нужно удалить те позиции или количество того, что мы сохранили в пункте 1
    3. когда  1 и  2 произошло, возвращаем то, что собрали в пункте 1
     */
    val positionByIndexList = mutableListOf<PlantEntity>()
    stock.forEach {
      if (it.id!! == position) {
        if (it.quantity > 0) {
          val result = it.quantity - quantity
          it.quantity = result
          positionByIndexList.add(it.copy(quantity = quantity))
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