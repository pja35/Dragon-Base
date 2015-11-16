package view.implementation;

import controller.DragAndDropManager;
import controller.MouseEventManager;
import controller.UnaryDragAndDropManager;
import controller.UnaryMouseEventManager;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Expression;
import view.implementation.BinaryGraphicExpression.Orientation;



/**
 * 
 * @author Thomas
 *
 */
public class UnaryGraphicExpression extends GraphicExpression{
	
	Expression model;
	Node decoOpen, decoClose;
	GraphicExpression expression;
	Orientation orientation;
	private DragAndDropManager dADmanagerOpen;
	private MouseEventManager mEmanagerOpen;
	private DragAndDropManager dADmanagerClose;
	private MouseEventManager mEmanagerClose;
	
	public UnaryGraphicExpression(Expression model,
									GraphicExpression expression, 
									Node decoOpen,
									Node decoClose,
									Orientation orientation) {
		this.model = model;
		this.expression = expression;
		this.decoOpen = decoOpen;
		this.decoClose = decoClose;
		this.orientation = orientation;
		
		dADmanagerOpen = new UnaryDragAndDropManager(this);
		mEmanagerOpen = new UnaryMouseEventManager(decoOpen,this);
		dADmanagerClose = new UnaryDragAndDropManager(this);
		mEmanagerClose = new UnaryMouseEventManager(decoClose,this);
		
		
    	//event
		mEmanagerOpen.onMouseEvent();
		dADmanagerOpen.onDragAndDropEvent();
		mEmanagerClose.onMouseEvent();
		dADmanagerClose.onDragAndDropEvent();
		
		constructionSousExpressionWithDeco();
	}
	
	public BorderPane constructionSousExpressionWithDeco(){
		BorderPane border = new BorderPane();

		if (Orientation.HORIZONTAL == this.orientation) {
			HBox hbox = new HBox();
			hbox.setAlignment(Pos.CENTER);
			hbox.setSpacing(5);
			hbox.getChildren().addAll(decoOpen, expression, decoClose);
			border.setCenter(hbox);
			this.getChildren().add(border);
		}
		if (Orientation.VERTICAL == this.orientation) {
			VBox vbox = new VBox();
			vbox.setAlignment(Pos.CENTER);
			vbox.setSpacing(5);
			vbox.getChildren().addAll(decoOpen, expression, decoClose);
			border.setCenter(vbox);
			this.getChildren().add(border);
		}
		return border;
	}
	
	/*		Getters		*/
	public Node getDecoOpen() {
		return decoOpen;
	}
	
	public Node getDecoClose() {
		return decoClose;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
	
	@Override
	public Expression getExpression() {
		return model;
	}
	
	/*		Setters		*/
	public void setDecoOpen(Node decoOpen) {
		this.decoOpen = decoOpen;
	}

	public void setDecoClose(Node decoClose) {
		this.decoClose = decoClose;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void setExpression(GraphicExpression expression) {
		this.expression = expression;
	}
	
}
