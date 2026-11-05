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

    private RadioButton smallSize;
    private RadioButton mediumSize;
    private RadioButton largeSize;
    private ToggleGroup sizeGroup;
    private CheckBox freeDeliveryCheckBox;

    @Override
    public void start(Stage stage) {

        // The size of the cake selected via radio buttons (small, medium, large)
        Label sizeLabel = new Label("Cake Size:");
        smallSize = new RadioButton("Small");
        mediumSize = new RadioButton("Medium");
        largeSize = new RadioButton("Large");

        sizeGroup = new ToggleGroup();

        smallSize.setToggleGroup(sizeGroup);
        mediumSize.setToggleGroup(sizeGroup);
        largeSize.setToggleGroup(sizeGroup);

        // Indicator if the customer lives within the free delivery area
        freeDeliveryCheckBox = new CheckBox("Within Free Delivery Area");


        // Layout for the form 
        VBox root = new VBox(10);

        root.getChildren().addAll(
            sizeLabel,
            smallSize, mediumSize, largeSize,
            freeDeliveryCheckBox
        );

        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.show();

    }

    // Main method
    public static void main(String[] args) {
        // launch(args);

    }
}
