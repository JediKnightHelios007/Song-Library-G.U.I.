/*
Cyril Manayath
Isaac Manayath

 */

package list.of.songs;

import java.io.IOException;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import list.of.songs.model.Song;
import list.of.songs.view.SongEdit;
import list.of.songs.view.SongView;

public class SongLib extends Application {

    private Stage primaryStage;
    private BorderPane mainDesign;
    
    // A list of songs.
     
    private ObservableList<Song> songData = FXCollections.observableArrayList();

    public ObservableList<Song> getSongData() {
        return songData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Song Library");
        initRootLayout();
        showSongOverview();
    }

    public void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SongLib.class.getResource("view/MainDesign.fxml"));
            mainDesign = (BorderPane) loader.load();

            Scene scene = new Scene(mainDesign);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Load Song View
    
    public void showSongOverview() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SongLib.class.getResource("view/SongView2.fxml"));
            AnchorPane songView = (AnchorPane) loader.load();

            mainDesign.setCenter(songView);

            SongView controller = loader.getController();
            controller.setSongLib(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 //Dialog Box for Editing Songs
    
    public boolean SongEditDialog(Song song) {
        try {
       
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SongLib.class.getResource("view/SongEdit2.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Song");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SongEdit controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setSong(song);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}