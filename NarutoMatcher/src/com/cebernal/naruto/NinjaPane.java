package com.cebernal.naruto;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NinjaPane implements Initializable {

	@FXML
	ImageView imageNinja;
	@FXML
	Label nameNinja;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void updateNinja(String nameNinja, String imageNinja) {
		this.imageNinja.setImage(new Image(getClass().getResourceAsStream(imageNinja)));
		this.nameNinja.setText(nameNinja);
	}

}
