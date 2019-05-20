package controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.Main;
import main.MyPatternValidator;
import main.Pattern;
import main.Test;
import main.Validator;
import main.VinputText;

public class Controler {

	static String value;
	private Field field;
	private Class<Test> obj;
	private MyPatternValidator patternValidator;
	private Tooltip tooltip;
	private volatile boolean notated=false;

	public Controler() {
		if (isAnnotationPresent()) {
			notated=true;
		}
		
	}
	private boolean isAnnotationPresent() {
		if (Main.field.getAnnotation(Pattern.class) != null) {
			patternValidator = new MyPatternValidator();
			return true;
		} else
			return false;
	}

	private void validateField() {

		boolean validation = patternValidator.isValid();
		if (validation == false) {
			imageView.setImage(Main.falseImage);
			tooltip.setText(patternValidator.getMessage());
			button.setDisable(true);
		} else {
			imageView.setImage(Main.trueImage);
			button.setDisable(false);
			tooltip.setText(patternValidator.getMessage());
		}
	}

	@FXML
	public void initialize() {
		label.setMinWidth(70);
		label.setText("<----" + Main.field.getName());
		tooltip = new Tooltip();
		Tooltip.install(imageView, tooltip);
		imageView.setFitHeight(46);
		imageView.setFitWidth(40);
		if(notated)
		{
			textField.textProperty().addListener(new ChangeListener<String>()
			{
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
							VinputText.value = newValue;
							VinputText.registerValidaor(patternValidator);
							validateField();	
					}
			
				});
		}
	}

	@FXML
	private Button button;

	@FXML
	private ImageView imageView;

	@FXML
	private TextArea textArea;

	@FXML
	private ScrollPane scrollPane;

	@FXML
	private HBox hBox;

	@FXML
	private ImageView imageView2;

	@FXML
	private TextField textField;
	@FXML
	private Label label;

	@FXML
	void confirmClick(ActionEvent event) throws IllegalAccessException, IllegalArgumentException,
	InvocationTargetException, InstantiationException, ClassNotFoundException, InterruptedException {
		Class<?> cls = Class.forName("main.Test");
		Object instance = cls.newInstance();
		String value = textField.getText().toString();
		Main.setMethod.invoke(instance, value);
		textArea.setText("Created new Postal Code: " + Main.getMethod.invoke(instance).toString());
	}

}
