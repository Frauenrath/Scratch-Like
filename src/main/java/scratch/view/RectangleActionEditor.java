package scratch.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import scratch.model.Constants;
import scratch.model.RectangleAction;

public class RectangleActionEditor extends ActionEditor {
    private final RectangleAction rectangleAction;
    private final ValueField longueurField = new ValueField();
    private final ValueField largeurField = new ValueField();
    private final Label errorLabel = new Label("Entrez une Longueur ou une largueur valide (entre 1 et 100).");

    public RectangleActionEditor(RectangleAction action) {
        rectangleAction = action;


        setupEditor();

        setupBindings();
        setupListeners();
    }


    @Override
    public void setupEditor() {
        longueurField.setPrefWidth(100);
        longueurField.setAlignment(Pos.CENTER);

        longueurField.setText(rectangleAction.getLongueur());
        largeurField.setText(rectangleAction.getLargeur());

        hBox.getChildren().addAll(new Label("Rectangle de longueur = "),
                longueurField, new Label(" et de largeur = "), largeurField);

        errorLabel.setTextFill(Color.RED);
        getChildren().add(errorLabel);
    }

    private void setupBindings() {
        errorLabel.visibleProperty().bind(rectangleAction.isValidProperty().not());
        errorLabel.managedProperty().bind(errorLabel.visibleProperty());
    }

    private void setupListeners() {
        longueurField.textProperty().addListener((_, _, newText ) ->
                rectangleAction.setLongueur(newText));

        largeurField.textProperty().addListener((_, _, newText ) ->
                rectangleAction.setLargeur(newText));
    }
}
