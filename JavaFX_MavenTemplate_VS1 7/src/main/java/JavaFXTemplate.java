import javafx.animation.*;
import javafx.geometry.Pos;
import java.util.Iterator;
import javafx.scene.text.FontWeight;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.scene.text.FontPosture;


public class JavaFXTemplate extends Application {
	// global variables are initialized
	private Button start, back;
	private MenuBar menu, menu1;

	ComboBox Drawing;
	private EventHandler<ActionEvent> myHandler;
	private Scene scene1, scene2, scene3, scene4, scene, finalScene;
	Set<Integer> nums = new HashSet<>();
	Set<Integer> checkNums = new HashSet<Integer>(20);
	int spot, drawing, count = 0, totalSum = 0;
	String str = "";

	VBox betCard, menuodd, rule, finalBox, finalVB, odd, check;

	Label l, l1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Keno Lottery Game");

		menu = new MenuBar();
		Menu mOne = new Menu("Menu");

		MenuItem one = new MenuItem("Display rules");
		MenuItem two = new MenuItem("Display odds");
		MenuItem three = new MenuItem("Quit");
		// menu bar contains different options to display rules, display odds and quit

		start = new Button("Start Game");
		start.setMaxSize(200, 48);


		BorderPane borderpane = new BorderPane();
		borderpane.setCenter(start); // creating borderpane for start screen

		Button back1 = new Button("Back to Menu");
		BorderPane bk = new BorderPane();
		bk.setCenter(back1);
		//back to welcome screen on clicking back to menu button
		back1.setOnAction(e -> primaryStage.setScene(scene1));

		// on clicking display Rules option, a scene with rules appears
		one.setOnAction(e -> primaryStage.setScene(scene2));
		menuodd = new VBox(displayOdds(), bk); //vbox storing display odds containers and back to menu button
		menuodd.setAlignment(Pos.CENTER); // position to the centre of the tab
		menuodd.setStyle("-fx-background-color:  #e4decd;");
		Scene s = new Scene(menuodd, 500, 500);
		// opens the odds of winning tab on clicking display odds option
		two.setOnAction(e -> primaryStage.setScene(s));
		three.setOnAction(e -> Platform.exit());
		mOne.getItems().add(one);
		mOne.getItems().add(two);
		mOne.getItems().add(three);
		menu.getMenus().addAll(mOne);
		borderpane.setLeft(menu);
		scene1 = new Scene(borderpane, 500,500);
		borderpane.setStyle("-fx-background-color:#acb7ae;");

		l = new Label("Carolina Keno is a fast-paced lottery draw-style game that's easy to play, with a chance to win great cash prizes every 4 minutes. For each Keno drawing, 20 numbers out of 80 will be selected as winning numbers. You can decide how many of these numbers (called Spots) and exactly which numbers you will try to match. There are more than 300 drawings daily so you will never need to wait long until the next Keno drawing." +
				"For example, if a 4-Spot game is selected, a total of 4 numbers from 1 to 80 would be selected. If you played that 4-Spot game for $1 and matched your 4 numbers to 4 of the winning numbers for that draw, you would win $75.\n" +
				"1. Decide how much to play per draw. Each play costs $1. Play for $2 to double your prize; play for $3 to triple your prize and so on up to $10 per play.\n" +
				"2. Select how many consecutive draws to play. Pick up to 20. Drawings happen every 4 minutes.\n" +
				"3. Select how many numbers to match from 1 to 10. In Keno, these are called Spots. The number of Spots you choose and the amount you play per draw will determine the amount you could win. See the prize chart to determine the amount you could win with a $1 play.\n" +
				"4. Pick as many numbers as you did Spots. You can select numbers from 1 to 80 or choose Quick Pick and let the computer terminal randomly pick some or all of these numbers for you.\n" +
				"5. Add Multiplier to increase all prizes up to 10X. Multiplier doubles base ticket cost.");
		l.setWrapText(true);

		l1 = new Label("Carolina Keno is a fast-paced lottery draw-style game that's easy to play, with a chance to win great cash prizes every 4 minutes. For each Keno drawing, 20 numbers out of 80 will be selected as winning numbers. You can decide how many of these numbers (called Spots) and exactly which numbers you will try to match. There are more than 300 drawings daily so you will never need to wait long until the next Keno drawing." +
				"For example, if a 4-Spot game is selected, a total of 4 numbers from 1 to 80 would be selected. If you played that 4-Spot game for $1 and matched your 4 numbers to 4 of the winning numbers for that draw, you would win $75.\n" +
				"1. Decide how much to play per draw. Each play costs $1. Play for $2 to double your prize; play for $3 to triple your prize and so on up to $10 per play.\n" +
				"2. Select how many consecutive draws to play. Pick up to 20. Drawings happen every 4 minutes.\n" +
				"3. Select how many numbers to match from 1 to 10. In Keno, these are called Spots. The number of Spots you choose and the amount you play per draw will determine the amount you could win. See the prize chart to determine the amount you could win with a $1 play.\n" +
				"4. Pick as many numbers as you did Spots. You can select numbers from 1 to 80 or choose Quick Pick and let the computer terminal randomly pick some or all of these numbers for you.\n" +
				"5. Add Multiplier to increase all prizes up to 10X. Multiplier doubles base ticket cost.");
		l1.setWrapText(true);

		back = new Button("Back to Menu");
		back.setOnAction(e -> primaryStage.setScene(scene1));

		VBox rules = new VBox(l,back); // vbox to store containers for display rules option
		rules.setAlignment(Pos.CENTER);
		rules.setStyle("-fx-background-color:  #e4decd;");
		scene2 = new Scene(rules, 500, 500);

		menu1 = new MenuBar();
		Menu mTwo = new Menu("Menu");

		MenuItem one1 = new MenuItem("Display rules");
		MenuItem two1 = new MenuItem("Display odds");
		MenuItem four = new MenuItem("New Look");
		MenuItem three1 = new MenuItem("Quit");


		Button startscene1 = new Button ("Go Back");
		startscene1.setOnAction(e -> primaryStage.setScene(scene4));
		rule = new VBox(l1, startscene1);
		rule.setAlignment(Pos.CENTER);
		rule.setStyle("-fx-background-color:  #e4decd;");
		Scene displayRules = new Scene(rule, 500, 500);

		Button startscene2 = new Button ("Go Back");
		startscene2.setOnAction(e -> primaryStage.setScene(scene4));
		odd = new VBox(displayOdds(), startscene2);
		odd.setAlignment(Pos.CENTER);
		odd.setStyle("-fx-background-color:  #e4decd;");
		scene3 = new Scene(odd, 500, 500);

		one1.setOnAction(e -> primaryStage.setScene(displayRules));
		two1.setOnAction(e -> primaryStage.setScene(scene3));
		three1.setOnAction(e -> Platform.exit());
		four.setOnAction(e -> newLook());
		mTwo.getItems().add(one1);
		mTwo.getItems().add(two1);
		mTwo.getItems().add(four);
		mTwo.getItems().add(three1);
		menu1.getMenus().addAll(mTwo);

		start.setOnAction(e -> primaryStage.setScene(scene4));

		betCard bet = new betCard();
		Button draw = new Button("Continue to Drawing");
		Button exit = new Button("Exit Game");
		exit.setOnAction(e -> Platform.exit()); // button click to exit game

		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(draw, exit);
		betCard = new VBox(menu1, bet.betNumbers(draw, Drawing), box);
		betCard.setStyle("-fx-background-color: #82716e;");
		scene4 = new Scene(betCard, 500, 500);
		drawing drawingScene = new drawing();

		draw.setOnAction((e) -> {
			drawing = bet.getDrawing();
//			System.out.println("Drawing: " + drawing);
			drawingScene.addingValues();
			spot = bet.getSpot();
			nums = bet.getNumbers();
//			System.out.println("Size: " + nums.size());
			checkNums = TwentyNumbers();
			Iterator itr = nums.iterator();
			while (itr.hasNext()) { // iterating through the number chosen by the user
				System.out.println(itr.next());
			}

			Iterator it = checkNums.iterator();

			str = "";
			EventHandler<ActionEvent> eventHandler = ( ev -> {
				int num = 0;

				if (it.hasNext()) {
					num = (int) it.next();
					str += String.valueOf(num) + " ";
//					System.out.println("Random: " + num);
					check = new VBox(drawingScene.numbers(nums, num, spot, str));
					check.setStyle("-fx-background-color: #fff5d7;");
					check.setAlignment(Pos.CENTER);
					scene = new Scene(check, 1000, 200);
					primaryStage.setScene(scene);
				}
				else {
					// calculating money won in the drawing
					Label indSum = new Label("Money won on this drawing: $" + drawingScene.getSum());
					indSum.setFont(Font.font(20));
					totalSum += drawingScene.getSum();
					drawingScene.reset();
					Label tSum = new Label("Total money won: $" + totalSum);
					tSum.setFont(Font.font(20));
					finalBox = new VBox(indSum, tSum);
					if (count < drawing - 1) {
						draw.setText("Continue to next drawing");
						finalBox.getChildren().add(draw);
						count++;
					}
					else {
						//play again screen which appears at the end
						Button contGame = new Button("Play again");
						contGame.setOnAction(event -> primaryStage.setScene(scene1));
						Button close = new Button("Exit the Game");
						close.setOnAction(event -> Platform.exit());
						finalBox.getChildren().add(contGame);
						finalBox.getChildren().add(close);
					}
					finalBox.setAlignment(Pos.CENTER);
					finalBox.setStyle("-fx-background-color: #82716e;");
					finalScene = new Scene(finalBox, 500, 500);
					primaryStage.setScene(finalScene);
				}
			});

			Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), eventHandler), new KeyFrame (Duration.millis(1000)));
			animation.setCycleCount(22);
			animation.play();
		});

		primaryStage.setScene(scene1); //set the scene in the stage
		primaryStage.show();
	}

	// To generate the 20 numbers for the drawings
	Set TwentyNumbers() {
		Set Nums = new HashSet<>();
		Random rand = new Random();
		while (Nums.size() < 20)
		{
			Nums.add(rand.nextInt(81) + 1);
		}
		return Nums;
	}

	// information for odds of winning
	VBox displayOdds() {

		Label title = new Label("10 Spot Game                                                         4 Spot Game");
		Label label_top = new Label("Match            Prize                                                 Match            Prize");

		Label label_right = new Label("10               $100,000                                              4                 $75");
		Label label_right2 = new Label("9                 $4,250                                                   3                  $5");
		Label label_right3 = new Label("8                 $450                                                       2                  $1");
		Label label_right4 = new Label("7                 $40                                                                                    ");
		Label label_right5 = new Label("6                 $15                                                                                      ");
		Label label_right6 = new Label("5                 $2                                                                                        ");
		Label label_right7 = new Label("0                 $5                                                                                       ");

		Label label_right8 = new Label("8 Spot Game                                                            1-Spot Game");
		Label label_right9 = new Label("8                          $10,000                                        1                    $2.50");

		Label label_center2 = new Label("7                           $500                                                                                 ");
		Label label_center3 = new Label("6                           $75                                                                                   ");
		Label label_center4 = new Label("5                           $10                                                                                    ");
		Label label_center5 = new Label("4                           $2                                                                                      ");
//		Label label_center6 = new Label("Overall odds 8 in 9.8                                                               ");

		VBox vbox5 = new VBox(title);
		VBox vbox1 = new VBox(label_top, label_right, label_right2, label_right3, label_right4, label_right5, label_right6, label_right7);
		VBox vbox2 = new VBox(label_right8, label_top, label_right9, label_center2, label_center3, label_center4, label_center5);

		vbox1.setAlignment(Pos.CENTER);
		vbox2.setAlignment(Pos.CENTER);
		vbox5.setAlignment(Pos.TOP_CENTER);

		finalVB = new VBox(vbox5, vbox1, vbox2);
		finalVB.setAlignment(Pos.CENTER);
		finalVB.setStyle("-fx-background-color: #82716e;");
		return finalVB;
	}

	// change background color and font when the new look option in the menu is clicked
	void newLook() {
		finalVB.setStyle("-fx-background-color: #2d545e;");
		odd.setStyle("-fx-background-color: #2d545e;");
		rule.setStyle("-fx-background-color: #2d545e;");
		betCard.setStyle("-fx-background-color: #2d545e;");
		l1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 13));
		menuodd.setStyle("-fx-background-color: #2d545e;");
//		finalBox.setStyle("-fx-background-color: #2d545e;");
//		check.setStyle("-fx-background-color: #2d545e;");
	}
}