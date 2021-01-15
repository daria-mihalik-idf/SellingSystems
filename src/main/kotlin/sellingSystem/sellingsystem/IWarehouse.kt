package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface IWarehouse {
  fun getStocks(): MutableList<PlantEntity>
  fun isStockEmpty(): Boolean
  fun getFromStocks(position: Int, plantQuantity: Int): PlantEntity?
}