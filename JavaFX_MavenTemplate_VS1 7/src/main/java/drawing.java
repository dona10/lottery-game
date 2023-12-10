import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

// This class contains the logic part of the program.
public class drawing {
    Set nums = new HashSet();
    int sum = 0, totalSum = 0;
    int count = 0;
    int c = 0;
    Label match;
    Map<Integer, Integer> spot10 = new HashMap<Integer, Integer>();
    Map<Integer, Integer> spot8 = new HashMap<Integer, Integer>();
    Map<Integer, Integer> spot4 = new HashMap<Integer, Integer>();
    Map<Integer, Integer> spot1 = new HashMap<Integer, Integer>();


    // This function returns a VBox which contains all the JavaFX components for the drawing screen
    // This function also calls the logic function.
    public VBox numbers(Set nums, int checkNum, int spot, String str) {
        this.nums = nums;
        Label number = new Label("Numbers: ");
        // Changing the font size of the label to 20
        number.setFont(new Font(30));
        Label num = new Label(str);
        num.setFont(new Font(30));
        match = new Label();
        match.setFont(new Font(30));
        logic(checkNum, spot);
        match.setText("Number of Matches: " + count);
        Label price = new Label("Money won: ");
        price.setFont(new Font(30));
        Label money = new Label("$" + sum);
        money.setFont(new Font(30));

        // HBox for the amount to be printed in the drawing screen
        HBox amount = new HBox();
        amount.getChildren().add(price);
        amount.getChildren().add(money);
        amount.setAlignment(Pos.CENTER);

        BorderPane box = new BorderPane();
        box.setCenter(number);
        box.setCenter(num);
        box.setCenter(match);

        VBox drawItems = new VBox();
        // adding the components to the VBox
        drawItems.getChildren().add(number);
        drawItems.getChildren().add(num);
        drawItems.getChildren().add(match);
        drawItems.getChildren().add(amount);
        // setting the position to the ceneter
        drawItems.setAlignment(Pos.CENTER);
        // to set the background color
        drawItems.setStyle("-fx-background-color: #fff5d7;");
        return drawItems;
    }


    // This function counts the number of matches and also calculates the sum.
    void logic(int checkNum, int spot) {
        c++;
        if (nums.contains(checkNum))
        {
            // increments the count variable if the number matches
            count++;
        }
        // to calculate the sum
        if (c == 20)
        {
            if (spot == 10 && spot10.get(count) != null) {
                sum = spot10.get(count);
            }
            if (spot == 8 && spot8.get(count) != null) {
                sum = spot8.get(count);
            }
            if (spot == 4 && spot4.get(count) != null) {
                sum = spot4.get(count);
            }
            if (spot == 1 && spot1.get(count) != null) {
                sum = spot1.get(count);
            }
            totalSum += sum;
        }
    }

    // this function fills the map with values
    void addingValues() {
        spot10.put(10, 100000);
        spot10.put(9, 4250);
        spot10.put(8, 450);
        spot10.put(7, 40);
        spot10.put(6, 15);
        spot10.put(5, 2);
        spot10.put(0, 5);

        spot8.put(8, 10000);
        spot8.put(7, 750);
        spot8.put(6, 50);
        spot8.put(5, 12);
        spot8.put(4, 2);

        spot4.put(4, 75);
        spot4.put(3, 5);
        spot4.put(2, 1);

        spot1.put(1, 2);
    }

    // getter function to get the sum
    int getSum() {
        return sum;
    }

    // resets the values for the next drawing
    void reset() {
        sum = 0;
        count = 0;
        c = 0;
    }

    // getter function to get the total sum the user has won
    int getTotalSum()
    {
        return totalSum;
    }
}
