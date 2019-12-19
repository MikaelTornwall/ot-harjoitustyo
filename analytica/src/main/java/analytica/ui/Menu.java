package analytica.ui;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

/**
 * Menu class is responsible for creating a menu UI component
 * 
 * @author Mikael Törnwall
 */

public class Menu {
    private Button dashboardButton;
    private Button addDataButton;
    private Button eventsButton;
    private Button logoutButton;
    private Parent menu;
    
    public Menu() {
        this.dashboardButton = new Button("Dashboard");
        this.eventsButton = new Button("Events");
        this.addDataButton = new Button("Add data");
        this.logoutButton = new Button("Logout");
        this.menu = this.createMenu();
    }
    
    /**
     * Method returns add data button so that event handling can be performed
     * 
     * @return JavaFX Button component
     */
    
    public Button getAddDataButton() {
        return this.addDataButton;
    }
    
    /**
     * Method returns events button so that event handling can be performed
     * 
     * @return JavaFX Button component
     */
    
    public Button getEventsButton() {
        return this.eventsButton;
    }
    
    /**
     * Method returns dashboard button so that event handling can be performed
     * 
     * @return JavaFX Button component
     */
    
    public Button getDashboardButton() {
        return this.dashboardButton;
    }
    
    /**
     * Method returns logout button so that event handling can be performed
     * 
     * @return JavaFX Button component
     */
    
    public Button getLogoutButton() {
        return this.logoutButton;
    }
    
    /**
     * Method returns the menu component 
     * 
     * @return menu component as a JavaFX Parent object
     */
    
    public Parent getMenu() {
        return this.menu;
    }
    
    /**
     * Method creates the menu component 
     * 
     * @return menu component as a JavaFX Parent object
     */
    
    private Parent createMenu() {
        HBox menuPane = new HBox();
        menuPane.getChildren().addAll(dashboardButton, eventsButton, addDataButton, logoutButton);
        
        return menuPane;
    }
}
