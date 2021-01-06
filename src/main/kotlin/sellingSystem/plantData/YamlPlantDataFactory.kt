package sellingSystem.plantData

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.introspector.BeanAccess
import sellingSystem.plant.entity.PlantStock
import java.io.BufferedInputStream
import java.io.InputStream

class YamlPlantDataFactory : PlantDataProvider {

  override val filePath: String = "plantList.yaml"

  override fun getPlantData(): PlantStock? {
    return parseYamlAsUsingFieldAccess(filePath, PlantStock::class.java)
  }

  private fun <T> parseYamlAsUsingFieldAccess(fileUrl: String, clazz: Class<T>): T? {
    var mapping: T? = null
    val inputStream = loadResourceAsStream(fileUrl) ?: return mapping
    BufferedInputStream(inputStream).use { bis ->
      val yaml = Yaml()
      yaml.setBeanAccess(BeanAccess.FIELD)
      mapping = yaml.loadAs(bis, clazz)
    }
    return mapping
  }

  private fun loadResourceAsStream(fileUrl: String): InputStream? {
    return object {}.javaClass.classLoader.getResourceAsStream(fileUrl)
  }
}