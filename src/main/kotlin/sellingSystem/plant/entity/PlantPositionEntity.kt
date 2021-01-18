package sellingSystem.plant.entity

import sellingSystem.plant.IPlantForSale
import sellingSystem.plant.Plant
import sellingSystem.plantData.PlantName

data class PlantStock(var entity: MutableList<PlantEntity> = mutableListOf())

data class PlantData(var type: String = "",
    var name: PlantName)

data class PlantEntity(
//    override var id: Int? = 0,
    override var plant: PlantData,
    override var price: Int = 0,
    override var quantity: Int = 0,
    override var dateReceived: String = "",
    override var dateSold: String = "") : IPlantForSale