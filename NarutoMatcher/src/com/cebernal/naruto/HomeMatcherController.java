package com.cebernal.naruto;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.TreeSet;

import com.cebernal.naruto.helper.NinjaHelper;
import com.cebernal.naruto.helper.SimulatorHelper;
import com.cebernal.naruto.model.Ninja;
import com.cebernal.naruto.model.Skill;
import com.cebernal.naruto.model.Solution;
import com.cebernal.naruto.model.TargetCombo;
import com.cebernal.naruto.parser.DatabaseParser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class HomeMatcherController implements Initializable {

	@FXML
	ScrollPane scrollNinja;
	@FXML
	ComboBox<Ninja> mainCharacterCB;
	@FXML
	ComboBox<Skill> summonCB;
	@FXML
	ComboBox<TargetCombo> minimumComboCB;
	@FXML
	TextArea outputArea;

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
			if (!DatabaseParser.getInstance().getMains().contains(ninja.getIdNinja())) {
				StackPane base = new StackPane();
				VBox imagePanel = new VBox();
				imagePanel.setAlignment(Pos.CENTER);
				HBox checkboxPanel = new HBox();

				VBox labelPanel = new VBox();
				checkboxPanel.setAlignment(Pos.TOP_LEFT);
				// gridPane.setMaxWidth(value);
				// gridPane.setAlignment(Pos.CENTER_LEFT);
				// for (int j = 0; j < 5; j++) {
				// RowConstraints row = new RowConstraints(12);
				// gridPane.getRowConstraints().add(row);
				// }
				// for (int j = 0; j < 9; j++) {
				// ColumnConstraints column = new ColumnConstraints(10);
				// gridPane.getColumnConstraints().add(column);
				// }
				ImageView imageView = new ImageView();
				Label label = new Label();
				Image image = new Image(
						getClass().getResourceAsStream("resources/images/" + ninja.getIdNinja() + ".png"));
				imageView.setImage(image);
				// imageView.setPreserveRatio(true);
				// imageView.setFitWidth(100);
				label.setText(ninja.getName());
				label.setTextOverrun(OverrunStyle.CLIP);
				label.setMaxWidth(100);
				label.setTranslateY(52);
				label.setStyle(
						"-fx-background-color: rgba(0, 0, 0, 0.4); -fx-background-radius: 3; -fx-text-fill: rgba(255, 255, 255, 1);");

				final CheckBox active = new CheckBox();
				active.setAlignment(Pos.CENTER_LEFT);
				CheckBox lock = new CheckBox();
				String css = getClass().getResource("lock.css").toExternalForm();
				lock.getStylesheets().clear();
				lock.getStylesheets().add(css);
				lock.setAlignment(Pos.CENTER_RIGHT);
				lock.setTranslateX(55);
				ChangeListener<Boolean> lockListener = new ChangeListener<Boolean>() {
					@Override
					public void changed(ObservableValue<? extends Boolean> ov, Boolean oldVal, Boolean newVal) {
						if (newVal) {
							active.setSelected(true);
						}
					}
				};
				
				lock.selectedProperty().addListener(lockListener);
				
				imagePanel.getChildren().add(imageView);
				checkboxPanel.getChildren().add(active);
				checkboxPanel.getChildren().add(lock);
				labelPanel.getChildren().add(label);
				checkboxPanel.prefWidth(imagePanel.getWidth());

				base.getChildren().add(imagePanel);
				base.getChildren().add(labelPanel);
				base.getChildren().add(checkboxPanel);
				base.setId(ninja.getIdNinja());
				list.getChildren().add(base);
			}
		}

		// Initialize combobox ninjas
		populateNinjas();
		// Initialize combobox summons
		populateSummons();
		// Initialize combobox summons
		populateMinimumCombo();

		scrollNinja.setContent(list);
	}

	/**
	 * 
	 */
	private void populateSummons() {
//		Skill defaultSkill = new Skill();
//		defaultSkill.setNameCharacter("---- Use all ----");
//		summonCB.getItems().add(defaultSkill);
		for (Entry<String, Skill> summon : DatabaseParser.getInstance().getSummons().entrySet()) {
			if (summon.getValue().getRepetitions() > 1) {
				summonCB.getItems().add(summon.getValue());
			}
		}
		summonCB.getSelectionModel().selectFirst();
		summonCB.setCellFactory(new Callback<ListView<Skill>, ListCell<Skill>>() {

			@Override
			public ListCell<Skill> call(ListView<Skill> p) {

				final ListCell<Skill> cell = new ListCell<Skill>() {

					@Override
					protected void updateItem(Skill summon, boolean bln) {
						super.updateItem(summon, bln);

						if (summon != null) {
							setText(summon.toString());
							// } else {
							// setText("---- Use all ----");
						}
					}

				};

				return cell;
			}
		});
	}

	/**
	 * 
	 */
	private void populateNinjas() {
		for (String id : DatabaseParser.getInstance().getMains()) {
			mainCharacterCB.getItems().add(DatabaseParser.getInstance().getNinjas().get(id));
		}
		mainCharacterCB.getSelectionModel().selectFirst();
		mainCharacterCB.setCellFactory(new Callback<ListView<Ninja>, ListCell<Ninja>>() {

			@Override
			public ListCell<Ninja> call(ListView<Ninja> p) {

				final ListCell<Ninja> cell = new ListCell<Ninja>() {

					@Override
					protected void updateItem(Ninja ninja, boolean bln) {
						super.updateItem(ninja, bln);

						if (ninja != null) {
							setText(ninja.toString());
						} else {
							setText(null);
						}
					}

				};

				return cell;
			}
		});

	}

	private void populateMinimumCombo() {
		for (int i = 5; i < 20; i++) {
			minimumComboCB.getItems().add(new TargetCombo(i + ""));
		}
		minimumComboCB.getSelectionModel().selectLast();
		minimumComboCB.setCellFactory(new Callback<ListView<TargetCombo>, ListCell<TargetCombo>>() {

			@Override
			public ListCell<TargetCombo> call(ListView<TargetCombo> p) {

				final ListCell<TargetCombo> cell = new ListCell<TargetCombo>() {

					@Override
					protected void updateItem(TargetCombo ninja, boolean bln) {
						super.updateItem(ninja, bln);

						if (ninja != null) {
							setText(ninja.toString());
						} else {
							setText(null);
						}
					}

				};

				return cell;
			}
		});

	}

	@FXML
	protected void generateTeams(ActionEvent event) {
		outputArea.clear();
		TilePane lookup = (TilePane) scrollNinja.lookup("#gui_list_ninjas");
		Ninja main = mainCharacterCB.getSelectionModel().getSelectedItem();
		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// String prettyJson = gson.toJson(main);
		// System.out.println(prettyJson);
		Skill summon = summonCB.getSelectionModel().getSelectedItem();
		int targetCombo = Integer.parseInt(minimumComboCB.getSelectionModel().getSelectedItem().getCombo());
		outputArea.appendText("Character " + main.getName() + " was selected\n");
		outputArea.appendText("Summon " + summon.getNameCharacter() + " was selected\n");
		List<String> lockedNinjas = new ArrayList<String>();
		List<String> activeNinjas = new ArrayList<String>();
		for (Node node : lookup.getChildren()) {
			// Get ninjas' info from GUI
			StackPane stackPane = (StackPane) node;
			HBox hBox = (HBox) stackPane.getChildren().get(2);
			CheckBox active = (CheckBox) hBox.getChildren().get(0);
			CheckBox lock = (CheckBox) hBox.getChildren().get(1);
			Ninja ninja = DatabaseParser.getInstance().getNinjas().get(stackPane.getId());
			int count = 0;
			// If ninja is blocked it is not added to active
			if (lock.isSelected()) {
				outputArea.appendText(ninja.getName() + " locked\n");
				lockedNinjas.add(ninja.getIdNinja());
			} else if (active.isSelected()) {
				outputArea.appendText(ninja.getName() + " selected\n");
				activeNinjas.add(ninja.getIdNinja());
				// outputArea.appendText(gson.toJson(ninja) + "\n\n");
			}
		}
		if (activeNinjas.size() + lockedNinjas.size() > 3) {
			List<Solution> solutions = SimulatorHelper.generateTeams(main, summon, lockedNinjas, activeNinjas,
					5);
			int max = 0;
			for (Solution solution : solutions) {
				if (solution.getMaxCombo() > max) {
					max = solution.getMaxCombo();
				}
			}
			outputArea.appendText("Max. Combo:" + max + "\n");
			outputArea.appendText("\n-----------------------\n");
			for (Solution solution : solutions) {
				if (solution.getMaxCombo() == targetCombo) {
					Ninja ninja1 = NinjaHelper.getNinjas(solution.getNinja1()).get(0);
					Ninja ninja2 = NinjaHelper.getNinjas(solution.getNinja2()).get(0);
					Ninja ninja3 = NinjaHelper.getNinjas(solution.getNinja3()).get(0);
					Ninja ninja4 = NinjaHelper.getNinjas(solution.getNinja4()).get(0);
					outputArea.appendText("Ninja1:" + ninja1.getName() + "\n");
					outputArea.appendText("Ninja2:" + ninja2.getName() + "\n");
					outputArea.appendText("Ninja3:" + ninja3.getName() + "\n");
					outputArea.appendText("Ninja4:" + ninja4.getName() + "\n");
					Skill chase = NinjaHelper.getMainSkill(solution.getChase());
					Skill summonResult = NinjaHelper.getSummonSkill(solution.getSummon());
					outputArea.appendText("Chase:" + chase.getTitleSkill() + "\n");
					outputArea.appendText("Summon:" + summonResult.getTitleSkill() + "\n");
					outputArea.appendText("Combo:\n" + solution.getComboString() + "\n");
					outputArea.appendText("Total Combo:" + solution.getMaxCombo() + "\n");
					outputArea.appendText("\n----\n");
				}
			}
		} else {
			outputArea.appendText("Please select more than 3 ninjas\n");
		}
	}

}
