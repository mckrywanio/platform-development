import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.IOException

fun main(args: Array<String>) {
    println("Photo Gallery Application")
    
    // Path to the folder where images are stored
    val directoryPath = "./images"  // You can replace this with an actual path containing images.
    val imageFiles = fetchImages(directoryPath)
    
    if (imageFiles.isNotEmpty()) {
        println("Found ${imageFiles.size} images. Displaying gallery...")
        imageFiles.forEachIndexed { index, image ->
            println("Image ${index + 1}: ${image.name}")
            // Simulate rendering images
            loadImage(image)
        }
    } else {
        println("No images found in the specified directory.")
    }
}

fun fetchImages(directoryPath: String): List<File> {
    val directory = File(directoryPath)
    if (!directory.exists() || !directory.isDirectory) {
        println("Directory does not exist or is not valid.")
        return emptyList()
    }
    
    return directory.listFiles { file -> file.extension == "jpg" || file.extension == "png" }?.toList() ?: emptyList()
}

fun loadImage(file: File) {
    try {
        val img: BufferedImage = ImageIO.read(file)
        println("Successfully loaded image: ${file.name} (${img.width}x${img.height})")
    } catch (e: IOException) {
        println("Error loading image: ${file.name}")
    }
}