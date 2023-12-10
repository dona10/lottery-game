import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

// This class is to create the betcard
public class betCard {
    int spot;
    int count = 0;
    int drawing;
    Button exit, quickPick;
    GridPane grid;
    Set<Integer> vc = new HashSet<>(spot);
    ComboBox Spot;

    private EventHandler<ActionEvent> myHandler;
    // This function creates the combo box for spot, drawing and a gridpane and returns a VBox
    public VBox betNumbers(Button draw, ComboBox Drawing) {
        // Event Handler for the buttons in the gridpane
        myHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Button b1 = (Button)e.getSource();
                b1.setDisable(true);
                vc.add(Integer.parseInt(((Button) e.getSource()).getText()));
                if (vc.size() == spot)
                {
                    grid.setDisable(true);
                }
            }
        };

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        addGrid(grid);
        grid.setDisable(true);
        grid.setVgap(5);
        grid.setHgap(5);

        // ComboBox for spot
        Spot = new ComboBox();
        Spot.getItems().add("1");
        Spot.getItems().add("4");
        Spot.getItems().add("8");
        Spot.getItems().add("10");
        Spot.setOnAction((event) -> {
            grid.setDisable(false);
            spot = Integer.parseInt(Spot.getValue().toString());
        });

        // ComboBox for drawing
        Drawing = new ComboBox();
        Drawing.getItems().add("1");
        Drawing.getItems().add("2");
        Drawing.getItems().add("3");
        Drawing.getItems().add("4");
        ComboBox finalDrawing = Drawing;
        Drawing.setOnAction((event) -> {
            drawing = Integer.parseInt(finalDrawing.getValue().toString());
//            System.out.println("Drawing inside the function: " + drawing);
        });

        quickPick = new Button("Quick Pick");

        // this event handler runs whens the user selects quick pick
        quickPick.setOnAction((e) -> {
            String st = "";
            grid.setDisable(true);
            Random rand = new Random();
            while (vc.size() < spot)
            {
                vc.add(rand.nextInt(81) + 1);
            }
            Iterator itr = vc.iterator();
            while (itr.hasNext()) {
                st = st + itr.next() + " ";
            }

            Label prompt  = new Label("Your numbers: ");
            prompt.setFont(Font.font(20));
            Label v = new Label(st);
            v.setFont(Font.font(20));
            Button close = new Button("Close");
            VBox pick = new VBox(prompt, v, close);
            pick.setAlignment(Pos.CENTER);
            pick.setStyle("-fx-background-color: fff5d7;");
            Stage stage = new Stage();
            stage.setScene(new Scene(pick, 500, 200));
            stage.show();
            close.setOnAction(eventH -> stage.close());
        });

        return new VBox(new HBox(new Label("Spot: "), Spot), new HBox(new Label("Drawing: "), Drawing), quickPick, grid);
    }

    // This function adds 1 - 80 buttons to the gridpane
    public void addGrid(GridPane grid) {

        int num = 1;
        for(int x = 0; x<8; x++) {
            for(int i = 0; i<10; i++) {
                Button b1 = new Button(Integer.toString(num));
                b1.setStyle("-fx-background-color: #e4decd;");
                b1.setMaxSize(100, 100);
                num++;
                b1.setOnAction(myHandler);
                grid.add(b1, x, i);

            }
        }
    }

    // getter function to get the numbers chosen by the user
    public Set getNumbers() {
        return vc;
    }

    // getter function to get the number of spots
    public Integer getSpot() {
        return spot;
    }

    // getter function to get the number of drawing selected by the user
    public Integer getDrawing() {
        return drawing;
    }
}
