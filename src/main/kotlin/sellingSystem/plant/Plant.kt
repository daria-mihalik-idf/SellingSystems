package sellingSystem.plant

import sellingSystem.plant.entity.PlantData

interface Plant {
//  var id: Int?
  var plant: PlantData
}

interface IPlantForSale : Plant, Sellable {
  var price: Int
  var quantity: Int
  var dateReceived: String
  var dateSold: String
}

interface IFlowerForSale : IPlantForSale

interface ITreeForSale : IPlantForSale