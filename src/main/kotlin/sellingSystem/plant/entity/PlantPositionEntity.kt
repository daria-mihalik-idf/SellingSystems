package sellingSystem.plant.entity

import sellingSystem.plant.Plant

data class PlantStock(var entity: List<PlantEntity>? = null)

data class PlantEntity(
    override var id: Int? = 0,
    override var type: String? = null,
    override var name: String? = null,
    override var price: Int? = 0,
    override var quantity: Int? = 0,
    override var dateReceived: String? = null) : Plant