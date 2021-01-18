package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity
import sellingSystem.plantData.PlantName

interface IWarehouse {
  fun getStocks(): MutableList<PlantEntity>
  fun isStockEmpty(): Boolean
  fun getFromStocks(name: PlantName, plantQuantity: Int): PlantEntity?
}