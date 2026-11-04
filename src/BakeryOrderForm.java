import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BakeryOrderForm extends Application {
    @Override
    public void start(Stage stage) {

        // The size of the cake selected via radio buttons (small, medium, large)
        Label sizeLabel = new Label("Cake Size:");
        RadioButton smallSize = new RadioButton("Small");
        RadioButton mediumSize = new RadioButton("Medium");
        RadioButton largeSize = new RadioButton("Large");

        ToggleGroup sizeGroup = new ToggleGroup();

        smallSize.setToggleGroup(sizeGroup);
        mediumSize.setToggleGroup(sizeGroup);
        largeSize.setToggleGroup(sizeGroup);

        // Indicator if the customer lives within the free delivery area
        CheckBox freeDeliveryCheckBox = new CheckBox("Within Free Delivery Area");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
