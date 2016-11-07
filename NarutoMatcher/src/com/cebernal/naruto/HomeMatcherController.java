package com.cebernal.naruto;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;

import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.parser.DatabaseParser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class HomeMatcherController implements Initializable {

	@FXML
	ScrollPane scrollNinja;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TilePane list = new TilePane();
		list.setId("gui_list_ninjas");
		list.setPrefColumns(3);

		TreeSet<Ninja> ninjas = new TreeSet<Ninja>();
		ninjas.addAll(DatabaseParser.getInstance().getNinjas().values());

		for (Ninja ninja : ninjas) {

			StackPane base = new StackPane();
			VBox vBox = new VBox();
			vBox.setAlignment(Pos.CENTER);
			GridPane gridPane = new GridPane();
			// gridPane.setMaxWidth(value);
			gridPane.setAlignment(Pos.CENTER_LEFT);
			for (int j = 0; j < 5; j++) {
				RowConstraints row = new RowConstraints(12);
				gridPane.getRowConstraints().add(row);
			}
			ImageView imageView = new ImageView();
			Label label = new Label();
			Image image = new Image(getClass().getResourceAsStream("resources/images/" + ninja.getIdNinja() + ".png"));
			imageView.setImage(image);
			// imageView.setPreserveRatio(true);
			// imageView.setFitWidth(100);
			label.setText(ninja.getName());
			label.setTextOverrun(OverrunStyle.CLIP);
			label.setMaxWidth(100);
			label.setStyle(
					"-fx-background-color: rgba(0, 0, 0, 0.4); -fx-background-radius: 3; -fx-text-fill: rgba(255, 255, 255, 1);");

			CheckBox checkBox = new CheckBox();
			// checkBox.setText("Active");

			// vBox.getChildren().add(checkBox);
			vBox.getChildren().add(imageView);
			gridPane.add(checkBox, 0, 0);
			gridPane.add(label, 0, 4);

			base.getChildren().add(vBox);
			base.getChildren().add(gridPane);
			base.setId(ninja.getIdNinja());
			list.getChildren().add(base);
		}

		scrollNinja.setContent(list);
	}

}
