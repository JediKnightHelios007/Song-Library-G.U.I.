/*
Cyril Manayath
Isaac Manayath

 */

package list.of.songs.view;

import javafx.fxml.FXML;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import list.of.songs.model.Song;

public class SongEdit {
	

    @FXML
    private TextField NameField;
    @FXML
    private TextField ArtistField;
    @FXML
    private TextField AlbumField;
    @FXML
    private TextField YearField;

    private Stage dialogStage;
    private Song song;
    private boolean okClicked = false;
  
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setSong(Song song) {
        this.song = song;

        NameField.setText(song.getName());
        ArtistField.setText(song.getArtist());
        AlbumField.setText(song.getAlbum());
        YearField.setText(Integer.toString(song.getYear()));
       
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            song.setName(NameField.getText());
            song.setArtist(ArtistField.getText());
            song.setAlbum(AlbumField.getText());
            song.setYear(Integer.parseInt(YearField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (NameField.getText() == null || NameField.getText().length() == 0) {
            errorMessage += "Must be a band name\n"; 
        }
        if (ArtistField.getText() == null || ArtistField.getText().length() == 0) {
            errorMessage += "Must be a artist name\n"; 
        }
        if (AlbumField.getText() == null || AlbumField.getText().length() == 0) {
            errorMessage += "Must be an Album name\n"; 
        }

        if (YearField.getText() == null || YearField.getText().length() == 0) {
            errorMessage += "Not an year(integer)\n"; 
        } else {
           
            try {
                Integer.parseInt(YearField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Must be a year(integer)\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // error message
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Error");
            alert.setHeaderText("Coorect error fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}