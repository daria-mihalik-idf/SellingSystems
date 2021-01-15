package sellingSystem.plant

import sellingSystem.plant.entity.PlantData

interface Plant {
  var id: Int?
  var plant: PlantData
  var price: Int
  var quantity: Int
  var dateReceived: String
  var dateSold: String
}

interface IPlantForSale : Plant, Sellable

interface IFlowerForSale : IPlantForSale

interface ITreeForSale : IPlantForSale