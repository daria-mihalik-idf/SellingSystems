package sellingSystem.sellingsystem

import sellingSystem.plant.entity.PlantEntity

interface IWarehouse {
  fun getStocks(): MutableList<PlantEntity>
  fun getPositionById(id: Int, quantity: Int): MutableList<PlantEntity>
}