package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import server.controller.UIController;
import server.model.ConnectionModel;
import server.model.ServerDataModel;

public class ServerMain extends Application
{
	public static void main(String[] args)
	{

		ServerDataModel model = new ServerDataModel();
		ConnectionModel connectionModel = new ConnectionModel(model);

		UIController.setModel(model);
		UIController.setConnectionModel(connectionModel);

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/server/ui/ServerUI.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("SSL Server v0.1");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
		{
			@Override
			public void handle(WindowEvent e)
			{
				System.exit(0);
			}
		});
		primaryStage.show();
	}
}
