package sellingSystem.plant.entity

import sellingSystem.plant.Plant

data class PlantStock(var entity: List<PlantEntity>? = emptyList())

data class PlantData(var type: String = "",
    var name: String = "")

data class PlantEntity(
    override var id: Int? = 0,
    override var plant: List<PlantData>? = emptyList(),
    override var price: Int = 0,
    override var quantity: Int? = 0,
    override var dateReceived: String = "",
    override var dateSold: String = "") : Plant