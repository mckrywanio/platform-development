import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.control.ScrollPane
import javafx.stage.Stage
import java.net.URL
import java.io.InputStream


class PhotoGalleryApp : Application() {

    override fun start(primaryStage: Stage) {
		println("Current working directory: ${System.getProperty("user.dir")}")
        val gridPane = GridPane()
        val scrollPane = ScrollPane()
        scrollPane.content = gridPane

        val imageUrls = fetchImageUrls()

        var row = 0
        var col = 0
        val maxCols = 3 // Number of columns in the grid

        for (url in imageUrls) {
            val imageView = ImageView()
            val image = Image(url)
            imageView.image = image
            imageView.fitWidth = 200.0
            imageView.fitHeight = 200.0
            imageView.isPreserveRatio = true

            gridPane.add(imageView, col, row)

            col++
            if (col == maxCols) {
                col = 0
                row++
            }
        }

        val scene = Scene(scrollPane, 640.0, 480.0)
        primaryStage.title = "Photo Gallery"
        primaryStage.scene = scene
        primaryStage.show()
    }

    private fun fetchImageUrls(): List<String> {
		// List the filenames of local images
		return listOf(
			"file:image1.jpg",
			"file:image2.jpg",
			"file:image3.jpg",
			"file:image4.jpg",
			"file:image5.jpg",
			"file:image6.jpg",
			"file:image7.jpg",
			"file:image8.jpg",
			"file:image9.jpg",
			// Add more image filenames as needed
		)
	}
}

fun main() {
    Application.launch(PhotoGalleryApp::class.java)
}
