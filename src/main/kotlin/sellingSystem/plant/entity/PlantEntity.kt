package sellingSystem.plant.entity

data class PlantEntity(
    var flower: MutableList<FlowerPlant>,
    var tree: MutableList<TreePlant>
)