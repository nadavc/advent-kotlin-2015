import day1.FloorFinderSpec
import java.io.File

fun loadResource(s: String): String {
    val fileUrl = FloorFinderSpec::class.java.classLoader.getResource(s)
    return File(fileUrl.toURI()).readText()
}