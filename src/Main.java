import logic.ILogic;
import logic.Logic;
import utilities.IUtilities;
import utilities.Utilities;
import view.IView;
import view.View;

public class Main {
    
    public static void main(String[] args) {
        createLogicViewAndGUI();
    }

    private static void createLogicViewAndGUI() {

        // Creating logic and view objects and Assigning utilities to view and logic
        IUtilities utilities = new Utilities();
        IView view = new View(utilities);
        ILogic logic = new Logic(utilities, view);
        
        // Assigning logic to view, vice-versa and logic and view to utilities
        view.retrieveLogic(logic);
        utilities.retrieveLogicView(logic, view);

        // Start the GUI
        view.createAndShowGUI();
    }

}
