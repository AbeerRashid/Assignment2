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

        // Buttons for saving the order and clearing the form
        Button saveButton = new Button("Save Order");
        Button clearButton = new Button("Clear Form");

        saveButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String cakeType = cakeComboBox.getValue();

            // Grab the selected radio button text for the size
            RadioButton selectedSize = (RadioButton) sizeGroup.getSelectedToggle();
            String size = selectedSize != null ? selectedSize.getText() : "None";

            String delivery = freeDeliveryCheckBox.isSelected() ? "Yes" : "No";

            // Validation for the form fields
            if (name.isEmpty() || phone.isEmpty() || cakeType == null || size.equals("None")) {
                // Show a popup error box to the user
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Validation Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all fields and select a cake size.");
                alert.showAndWait();
                return;
            }

            // Formatting the order details to save to a text file
            String orderDetails = String.format("Customer Name: %s%nPhone Number: %s%nCake Type: %s%nCake Size: %s%nFree Delivery: %s%n",
                    name, phone, cakeType, size, delivery);
            // Write the order details to a text file named "orders.txt" with append

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
                writer.write(orderDetails);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Order Saved");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Order saved successfully!");
            successAlert.showAndWait();

             // Clear the form fields after saving
            nameField.clear();
            phoneField.clear();
            cakeComboBox.getSelectionModel().clearSelection();
            sizeGroup.selectToggle(null);
            freeDeliveryCheckBox.setSelected(false);
            
            } catch (IOException ex) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("File Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("An error occurred while saving the order.");
            errorAlert.showAndWait();
            return;
        }   
    });
        clearButton.setOnAction(e -> {
            nameField.clear();
            phoneField.clear();
            cakeComboBox.getSelectionModel().clearSelection();
            sizeGroup.selectToggle(null);
            freeDeliveryCheckBox.setSelected(false);
        });


        // Layout for the form
        VBox root = new VBox(10);

        root.getChildren().addAll(
                nameLabel, nameField,
                phoneLabel, phoneField,
                cakeLabel, cakeComboBox,
                sizeLabel,
                smallSize, mediumSize, largeSize,
                freeDeliveryCheckBox,
                saveButton, clearButton);
        Scene scene = new Scene(root, 400, 450);
        stage.setScene(scene);
        stage.show();

    }

    // Main method
    public static void main(String[] args) {
        launch(args);
    }
}
