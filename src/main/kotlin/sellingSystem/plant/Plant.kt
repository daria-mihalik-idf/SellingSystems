package sellingSystem.plant

import sellingSystem.sellingsystem.PlantType

interface Plant {
  val name: String
  val type: PlantType
}

interface IPlant : Plant, Sellable

interface IFlower : IPlant

interface ITree : IPlant

interface Sellable {
  val dateReceived: String
  val dateSold: String
  val price: Int

  fun getPlantPrice(): Int {
    return price
  }
}