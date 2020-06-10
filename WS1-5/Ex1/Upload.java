import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;

/**
 * The class Upload produces a JavaFX scene which contains an upload icon. This
 * icon is built using 2 polygons.
 * 
 * @author Ignas Stakaitis
 * @version 20/11/2019
 */
public class Upload extends Application {
	/**
	 * X_SIZE is the width of the panel in pixels. It is set to 300.
	 */
	public static final int X_SIZE = 300;
	/**
	 * Y_SIZE is the height of the panel in pixels. It is set to 300.
	 */
	public static final int Y_SIZE = 300;

	/**
	 * The start method. Two polygons are drawn, one for the top part of the upload
	 * icon and one for the bottom part. The polygons are then and added to the
	 * group. The group is subsequently added to the scene.
	 * 
	 * @param stage The window to be displayed.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Polygon polygonUpper = new Polygon(150, 50, 110, 75, 135, 75, 135, 175, 165, 175, 165, 75, 190, 75);
		Polygon polygonLower = new Polygon(50, 100, 75, 100, 75, 200, 225, 200, 225, 100, 250, 100, 250, 225, 50, 225);

		Group root = new Group(polygonUpper, polygonLower);
		Scene scene = new Scene(root, X_SIZE, Y_SIZE);

		stage.setTitle("Upload Icon");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Main method which launches the stage so it is visible to the user. The user
	 * should see an upload icon.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
