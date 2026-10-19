package scratch.model;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RectangleAction extends CompositeAction {
    private final StringProperty longueur = new SimpleStringProperty("");
    private final StringProperty largeur = new SimpleStringProperty("");

    public RectangleAction() {
        this("50", "20");
    }

    public RectangleAction(String longueur, String largeur) {
        super(ActionType.RECTANGLE);
        this.longueur.set(longueur);
        this.largeur.set(largeur);
        setChildren();

        setupBindings();

    }

    public void setLongueur(String longueur) {
        this.longueur.set(longueur);
    }

    public void setLargeur(String largeur) {
        this.largeur.set(largeur);
    }

    public String getLongueur() {
        return longueur.get();
    }

    public String getLargeur() {
        return largeur.get();
    }

    private void setupBindings() {
        isValidProperty().bind(Bindings.createBooleanBinding(() -> {
            try {
                int longueurValue = Integer.parseInt(longueur.get());
                int largeurValue = Integer.parseInt(largeur.get());
                return (longueurValue >= 1 && longueurValue <= 100) && (largeurValue >= 1 && largeurValue <= 100);
            } catch (NumberFormatException e) {
                return largeur.get().matches(Constants.VARIABLE_NAME_REGEX) || longueur.get().matches(Constants.VARIABLE_NAME_REGEX);
            }
        }, longueur, largeur));

        displayTextProperty().bind(Bindings.concat(toString(), "Long: ",
                longueur, " et Larg", largeur));
    }

    @Override
    public String save() {
        return super.save() + longueur.get() + ";" + largeur.get();
    }

    @Override
    public void execute(ActionContext actionContext) {
        for (int i = 0; i < 2; i++) {
            for (Action action : getChildren()) {
                action.execute(actionContext);
            }
        }
    }

    @Override
    public Action copy() {
        return new RectangleAction(longueur.get(), largeur.get());
    }

    @Override
    public String toString() {
        return "Création d'un rectangle de";
    }

    private void setChildren() {
        children.add(new MoveAction(longueur.get()));
        children.add(new RotateAction(ActionType.TURN_LEFT, "90"));
        children.add(new MoveAction(largeur.get()));
        children.add(new RotateAction(ActionType.TURN_LEFT, "90"));

    }
}
