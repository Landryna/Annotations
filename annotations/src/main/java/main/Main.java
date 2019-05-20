package main;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

import controller.Controler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private Pane pane;
	private Scene scene;
	public static Class<Test> obj;
	public static Field field;
	//images
	public static Image falseImage;
	public static Image trueImage;
	public static Image wowImage;
	///data
	public static Method getMethod;
	public static Method setMethod;
	
	public static void main(String[] program) {
		launch(program);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		getAnnotation();
		loadPane();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	private void loadPane() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/Pane.fxml"));
			pane = new Pane();
			pane = loader.load();
			scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("FXML/bull.css").toExternalForm());
			getImages();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void getAnnotation() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		obj = Test.class;
		field = obj.getDeclaredField("postalCode");
		getMethod = obj.getDeclaredMethod("getPostalCode");
		setMethod = obj.getDeclaredMethod("setPostalCode",String.class);
		
	}
	private void getImages()
	{
		falseImage = new Image(getClass().getClassLoader().getResourceAsStream("FXML/false.png"));
		trueImage = new Image(getClass().getClassLoader().getResourceAsStream("FXML/true.png"));
		wowImage = new Image(getClass().getClassLoader().getResourceAsStream("FXML/wow.png"));
		
	}

}
