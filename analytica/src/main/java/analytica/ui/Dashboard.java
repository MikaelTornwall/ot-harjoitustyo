package analytica.ui;

import java.util.List;
import java.util.ArrayList;
import analytica.service.AnalyticsService;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;

/**
 * Dashboard is responsible for generating and managing the dashboard component
 * 
 * @author Mikael Törnwall
 */

public class Dashboard {     
    private Parent dashboard;
    private final AnalyticsService analyticsService;
    private final List<Text> textList;
    private final Button predictRevenueByParticipantsButton;
    private final Button predictRevenueByPriceButton;
    private final Button predictPriceByParticipantsButton;
    private final Button predictParticipantsByPriceButton;
    private final TextField predictRevenueByParticipantsField;
    private final TextField predictRevenueByPriceField;
    private final TextField predictPriceByParticipantsField;
    private final TextField predictParticipantsByPriceField;
    private final Text predictRevenueByParticipantsText;
    private final Text predictRevenueByPriceText;
    private final Text predictPriceByParticipantsText;
    private final Text predictParticipantsByPriceText;    
    
    public Dashboard(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;          
        this.textList = new ArrayList<>();
        this.predictRevenueByParticipantsButton = new Button("Predict");
        this.predictRevenueByPriceButton = new Button("Predict");
        this.predictPriceByParticipantsButton = new Button("Predict");
        this.predictParticipantsByPriceButton = new Button("Predict");
        this.predictRevenueByParticipantsField = new TextField();
        this.predictRevenueByPriceField = new TextField();
        this.predictPriceByParticipantsField = new TextField();
        this.predictParticipantsByPriceField = new TextField();
        this.predictRevenueByParticipantsText = new Text("-");
        this.predictRevenueByPriceText = new Text("-");
        this.predictPriceByParticipantsText = new Text("-");
        this.predictParticipantsByPriceText = new Text("-");
        this.dashboard = this.createDashboard();  
        this.initTextList();
    }                
    
    private final void initTextList() {
        this.textList.add(predictRevenueByParticipantsText);
        this.textList.add(predictRevenueByPriceText);
        this.textList.add(predictPriceByParticipantsText);
        this.textList.add(predictParticipantsByPriceText);
    }
    
    public Parent getDashboard() {
        return this.dashboard;
    }                
   
    public Button getPredictPriceButton() {
        return this.predictPriceByParticipantsButton;
    }
    
    public Button getPredictParticipantsButton() {
        return this.predictParticipantsByPriceButton;
    }
    
    public Button getPredictRevenueParticipantsButton() {
        return this.predictRevenueByParticipantsButton;
    }
    
    public Button getPredictRevenuePriceButton() {
        return this.predictRevenueByPriceButton;
    }
    
    /**
     * Method creates a new dashboard and assigns it to dashboard variable
     * 
     */
    
    public void updateDashboard() {
        this.dashboard = this.createDashboard();
    }      
    
    /**
     * Method sets all Text objects text into "-"
     *           
     */
    
    public void defaultTextList() {
        for (Text text : this.textList) {
            text.setText("-");
        }
    }
    
    /**
     * Method checks if the given string contains an integer or a decimal value
     *           
     * @param value as a String
     * @return true is parameter string matches the condition, othwerwise false
     */
    
    private boolean checkIfNumber(String value) {
        if (value.matches("[0-9]+|[0-9]+.[0-9]+")) {
            return true;
        }
        return false;
    }
    
    /**
     * Method gets price prediction for a given input field value 
     *                
     */
    
    public void predictPriceByParticipants() {
        if (!this.checkIfNumber(this.predictPriceByParticipantsField.getText())) {
            this.predictPriceByParticipantsText.setText("Please input numeric value!");
        } else if (Double.valueOf(this.predictPriceByParticipantsField.getText()) > 10000) {
            this.predictPriceByParticipantsText.setText("Please input smaller value!");
        } else {
            Double prediction = analyticsService.predictPriceByParticipants(Double.valueOf(this.predictPriceByParticipantsField.getText()));
            this.predictPriceByParticipantsText.setText(Double.toString(prediction) + " €");            
        } 
    }
    
    /**
     * Method gets participants prediction for a given input field value 
     *                
     */
    
    public void predictParticipantsByPrice() {
        if (!this.checkIfNumber(this.predictParticipantsByPriceField.getText())) {
            this.predictParticipantsByPriceText.setText("Please input numeric value!");
        } else if (Double.valueOf(this.predictParticipantsByPriceField.getText()) > 500) {
            this.predictParticipantsByPriceText.setText("Please input smaller value!");
        } else {
            Double prediction = analyticsService.predictParticipantsByPrice(Double.valueOf(this.predictParticipantsByPriceField.getText()));
            this.predictParticipantsByPriceText.setText(Double.toString(prediction) + " participants");            
        }        
    }
    
    /**
     * Method gets revenue prediction for a given input field value 
     *                
     */
    
    public void predictRevenueByParticipants() {
        if (!this.checkIfNumber(this.predictRevenueByParticipantsField.getText())) {
            this.predictRevenueByParticipantsText.setText("Please input numeric value!");
        } else if (Double.valueOf(this.predictRevenueByParticipantsField.getText()) > 10000) {
            this.predictRevenueByParticipantsText.setText("Please input smaller value!");
        } else {
            Double prediction = analyticsService.predictRevenueByParticipants(Double.valueOf(this.predictRevenueByParticipantsField.getText()));
            this.predictRevenueByParticipantsText.setText(Double.toString(prediction) + " €");
        }        
    }
    
    /**
     * Method gets revenue prediction for a given input field value 
     *                
     */
    
    public void predictRevenueByPrice() {
        if (!this.checkIfNumber(this.predictRevenueByPriceField.getText())) {
            this.predictRevenueByPriceText.setText("Please input numeric value!");
        } else if (Double.valueOf(this.predictRevenueByPriceField.getText()) > 500) {
            this.predictRevenueByPriceText.setText("Please input smaller value!");
        } else {
            Double prediction = analyticsService.predictRevenueByPrice(Double.valueOf(this.predictRevenueByPriceField.getText()));
            this.predictRevenueByPriceText.setText(Double.toString(prediction) + " €");            
        }        
    }
    
    /**
     * Method creates the dashboard
     *                
     * @return Parent object
     */
    
    private Parent createDashboard() {        
        Text title = new Text("Dashboard");             
        title.setFont(Font.font(20));
        
        BorderPane layout = new BorderPane();
        layout.setTop(title);
        layout.setMargin(title, new Insets(0, 0, 10, 0));
        
        Text generalText = new Text("General");
        Text ratesText = new Text("Rates");
        Text revenueText = new Text("Revenue KPIs");
        Text correlationText = new Text("Correlation between participants and opened accounts");        
        Text predictOneText = new Text("Below you can predict price by no. of participants and no. of participants by price");
        Text predictTwoText = new Text("Below you can predict future revenues by no. of participants or by price");
        
        generalText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        ratesText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        revenueText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        correlationText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        predictOneText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        predictTwoText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        GridPane pane = new GridPane();
        pane.setVgap(20);
        pane.setHgap(50);
        GridPane generalPane = new GridPane();
        generalPane.setVgap(5);
        generalPane.setHgap(5);
        GridPane ratesPane = new GridPane();
        ratesPane.setVgap(5);
        ratesPane.setHgap(5);
        GridPane revenuePane = new GridPane();
        revenuePane.setVgap(5);
        revenuePane.setHgap(5);
        GridPane correlationPane = new GridPane();
        correlationPane.setVgap(5);
        correlationPane.setHgap(5);
        GridPane predictPaneOne = new GridPane();
        GridPane predictPaneTwo = new GridPane();
        predictPaneOne.setVgap(5);
        predictPaneTwo.setVgap(5);
        predictPaneOne.setHgap(10);
        predictPaneTwo.setHgap(10);
                
        // General pane
        Text generalEvents = new Text("Number of events: ");
        Text generalRevenue = new Text("Total revenue (€): ");
        Text generalParticipants = new Text("Total no. of participants: ");
        Text generalOpened = new Text("Total no. of opened accounts: ");
        Text generalAverageParticipants = new Text("Average no. of participants: ");
        Text generalPrice = new Text("Average price per event (€): ");
        
        Text events = new Text(Integer.toString(analyticsService.getNumberOfEvents()));
        Text revenue = new Text(Double.toString(analyticsService.getTotalRevenue()));
        Text participants = new Text(Integer.toString(analyticsService.getTotalParticipants()));
        Text opened = new Text(Integer.toString(analyticsService.getTotalOpened()));
        Text averageParticipants = new Text(Double.toString(analyticsService.getAverageParticipants()));
        Text averagePrice = new Text(Double.toString(analyticsService.getAveragePrice()));
        
        generalPane.add(generalText, 0, 0, 2, 1);          
        generalPane.add(generalEvents, 0, 1);        
        generalPane.add(events, 1, 1);
        generalPane.add(generalRevenue, 0, 2);
        generalPane.add(revenue, 1, 2);
        generalPane.add(generalParticipants, 0, 3);
        generalPane.add(participants, 1, 3);
        generalPane.add(generalOpened, 0, 4);
        generalPane.add(opened, 1, 4);
        generalPane.add(generalAverageParticipants, 0, 5);
        generalPane.add(averageParticipants, 1, 5);
        generalPane.add(generalPrice, 0, 6);
        generalPane.add(averagePrice, 1, 6);
        
        // Rates pane
        Text ratesOpened = new Text("Opened account (%): ");
        Text ratesNotOpened = new Text("Didn't open account (%): ");
        Text ratesMales = new Text("Male participants (%): ");
        Text ratesFemales = new Text("Female participants (%): ");
        
        Text openedRate = new Text(Double.toString(analyticsService.getOpenedRate()));
        Text notOpenedRate = new Text(Double.toString(analyticsService.getNotOpenedRate()));
        Text malesRate = new Text(Double.toString(analyticsService.getMalesRate()));
        Text femalesRate = new Text(Double.toString(analyticsService.getFemalesRate()));
        
        ratesPane.add(ratesText, 0, 0, 2, 1);        
        ratesPane.add(ratesOpened, 0, 1);
        ratesPane.add(openedRate, 1, 1);
        ratesPane.add(ratesNotOpened, 0, 2);
        ratesPane.add(notOpenedRate, 1, 2);
        ratesPane.add(ratesMales, 0, 3);
        ratesPane.add(malesRate, 1, 3);
        ratesPane.add(ratesFemales, 0, 4);
        ratesPane.add(femalesRate, 1, 4);
        
        // Revenue pane                        
        Text revenueAverage = new Text("Average revenue per event (€): ");
        Text revenueMedian = new Text("Median revenue per event (€): ");        
        
        Text averageRevenue = new Text(Double.toString(analyticsService.getAverageRevenue()));
        Text medianRevenue = new Text(Double.toString(analyticsService.getMedianRevenue()));
        
        revenuePane.add(revenueText, 0, 0, 2, 1);
        revenuePane.add(revenueAverage, 0, 1);
        revenuePane.add(averageRevenue, 1, 1);
        revenuePane.add(revenueMedian, 0, 2);
        revenuePane.add(medianRevenue, 1, 2);
        
        // Correlation pane
        Text correlation = new Text(Double.toString(analyticsService.getCorrelationBetweenParticipantsAndOpenedAccounts()));
        correlationPane.add(correlationText, 0, 0, 3, 1);        
        correlationPane.add(correlation, 0, 1);
        
        // PredictPane                
        Label predictPriceByParticipantsLabel = new Label("Price by participants: "); 
        Label predictParticipantsByPriceLabel = new Label("Participants by price : "); 
        Label predictRevenueByParticipantsLabel = new Label("Revenue by participants: ");         
        Label predictRevenueByPriceLabel = new Label("Revenue by price: ");
        
        predictPaneOne.add(predictOneText, 0, 0, 2, 1);    
        
        predictPaneOne.add(predictPriceByParticipantsLabel, 0, 1);
        predictPaneOne.add(predictPriceByParticipantsField, 1, 1);
        predictPaneOne.add(predictPriceByParticipantsButton, 2, 1);
        predictPaneOne.add(predictPriceByParticipantsText, 0, 2);        
        
        predictPaneOne.add(predictParticipantsByPriceLabel, 0, 3);
        predictPaneOne.add(predictParticipantsByPriceField, 1, 3);
        predictPaneOne.add(predictParticipantsByPriceButton, 2, 3);        
        predictPaneOne.add(predictParticipantsByPriceText, 0, 4);
        
        predictPaneTwo.add(predictTwoText, 0, 0, 2, 1);
        
        predictPaneTwo.add(predictRevenueByParticipantsLabel, 0, 1);
        predictPaneTwo.add(predictRevenueByParticipantsField, 1, 1);
        predictPaneTwo.add(predictRevenueByParticipantsButton, 2, 1);        
        predictPaneTwo.add(predictRevenueByParticipantsText, 0, 2);
        
        predictPaneTwo.add(predictRevenueByPriceLabel, 0, 3);
        predictPaneTwo.add(predictRevenueByPriceField, 1, 3);
        predictPaneTwo.add(predictRevenueByPriceButton, 2, 3);        
        predictPaneTwo.add(predictRevenueByPriceText, 0, 4);
        
        pane.add(generalPane, 0, 0);
        pane.add(ratesPane, 0, 1);
        pane.add(revenuePane, 0, 2);
        pane.add(correlationPane, 0, 3);
        pane.add(predictPaneOne, 1, 0);
        pane.add(predictPaneTwo, 1, 1);
        
        layout.setCenter(pane);        
        
        return layout;
    }    
}
