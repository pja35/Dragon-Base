package view;


import view.BinaryGraphicExpression.Orientation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class Main extends Application {
    
	@Override
    public void start(Stage primaryStage) {
    	// test
        StackPane center = new StackPane();
    	BorderPane root = new BorderPane();
    	PrimaryGraphicExpression lit = new PrimaryGraphicExpression();
    	PrimaryGraphicExpression lit2 = new PrimaryGraphicExpression();
    	PrimaryGraphicExpression lit3 = new PrimaryGraphicExpression();
    	
    	Shape operator = new Text("+");
    	Shape div = new Text("-");
    	((Text) operator).setFont(Font.font("Verdana", 40));
    	
    	Orientation orientation = Orientation.HORIZONTAL;
    	((Text) div).setFont(Font.font("Verdana", 50));
    	Orientation orientation1 = Orientation.VERTICAL;
    	
    	lit.setExpression("a");
    	lit2.setExpression("b");
    	lit3.setExpression("c");
    	
    	BinaryGraphicExpression bin1 = new BinaryGraphicExpression(lit, lit2, operator, orientation);
    	BinaryGraphicExpression bin2 = new BinaryGraphicExpression(bin1, lit3, div, orientation1);
    	
    	
    	// ajout des noeuds dans l'arbre du group
    	center.getChildren().add(bin2);
    	root.setCenter(center);
    	
    	Scene scene = new Scene(root, 750, 500, Color.LIGHTGRAY);
    	
        //definition de la fenetre d'affichage
        primaryStage.setTitle("New DragonBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    // sert juste a lancer l'application
    public static void main(String[] args) {
        launch(args);
    }
}