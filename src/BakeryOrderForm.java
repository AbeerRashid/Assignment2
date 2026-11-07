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

    // Customer information and cake type //
    private TextField nameField;
    private TextField phoneField;
    private ComboBox<String> cakeComboBox;

    private RadioButton smallSize;
    private RadioButton mediumSize;
    private RadioButton largeSize;
    private ToggleGroup sizeGroup;
    private CheckBox freeDeliveryCheckBox;

    @Override
    public void start(Stage stage) {

        // Customer name //
        Label nameLabel = new Label("Customer Name:");
        nameField = new TextField();
        nameField.setPromptText("Enter customer name");

        // Customer phone number
        Label phoneLabel = new Label("Phone Number:");
        phoneField = new TextField();
        phoneField.setPromptText("Enter phone number");

        // Cake type selected via combo box
        Label cakeLabel = new Label("Cake Type:");
        cakeComboBox = new ComboBox<>();

        cakeComboBox.getItems().addAll(
                "Apple",
                "Carrot",
                "Cheesecake",
                "Chocolate",
                "Coffee",
                "Opera",
                "Tiramisu");

        cakeComboBox.setPromptText("Select a cake");

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
                nameLabel, nameField,
                phoneLabel, phoneField,
                cakeLabel, cakeComboBox,
                sizeLabel,
                smallSize, mediumSize, largeSize,
                freeDeliveryCheckBox);

        Scene scene = new Scene(root, 400, 450);
        stage.setScene(scene);
        stage.show();

    }

    // Main method
    public static void main(String[] args) {
        launch(args);
    }
}
