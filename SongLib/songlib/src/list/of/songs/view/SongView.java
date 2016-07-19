/*
Cyril Manayath
Isaac Manayath

 */


package list.of.songs.view;

import javafx.fxml.FXML;





import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import list.of.songs.SongLib;
import list.of.songs.model.Song;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class SongView {
    @FXML
    private TableView<Song> songTable;
    @FXML
    private TableColumn<Song, String> Name;
    @FXML
    private TableColumn<Song, String> Artist;
    @FXML
    private TableColumn<Song, String> Album;
    @FXML
    private TableColumn<Song, Integer> Year;

    @FXML
    private Label NameLabel;
    @FXML
    private Label ArtistLabel;
    @FXML
    private Label AlbumLabel;
    @FXML
    private Label YearLabel;

    private SongLib songLib;

    @FXML
    private void initialize() {
        
        Name.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
     //   Artist.setCellValueFactory(cellData -> cellData.getValue().ArtistProperty());
     //   Album.setCellValueFactory(cellData -> cellData.getValue().AlbumProperty());
     //  Year.setCellValueFactory(cellData -> cellData.getValue().YearProperty());

        SongDetails(null);

        songTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> SongDetails(newValue));
    }

    public void setSongLib(SongLib songLib) {
        this.songLib = songLib;
        songTable.setItems(songLib.getSongData());
    }
 
    private void SongDetails(Song song) {
        if (song != null) {
          
            NameLabel.setText(song.getName());
            ArtistLabel.setText(song.getArtist());
            AlbumLabel.setText(song.getAlbum());
            YearLabel.setText(Integer.toString(song.getYear()));
        
        } else {
            // Person is null, remove all the text.
            NameLabel.setText("");
            ArtistLabel.setText("");
            AlbumLabel.setText("");
            YearLabel.setText("");
        }
    }
    
   //delete button
    @FXML
    private void DeleteSong() {
        int selectedIndex = songTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            songTable.getItems().remove(selectedIndex);
        } else {
    
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(songLib.getPrimaryStage());
            alert.setTitle("None selected");
            alert.setHeaderText("None selected");
            alert.setContentText("Please select a song in the table.");
            alert.showAndWait();
        }
    }
    
    //when new button is clicked, a dialog box opens so a person can type in their song
    @FXML
    private void NewSong() {
        Song tempSong = new Song(null, null, null, 0);
        boolean okClicked = songLib.SongEditDialog(tempSong);
        if (okClicked) {
            songLib.getSongData().add(tempSong);
        }
    }

   //Edits songs for a specific song
    
    @FXML
    private void EditSong() {
        Song song = songTable.getSelectionModel().getSelectedItem();
        if (song != null) {
            boolean okClicked = songLib.SongEditDialog(song);
            if (okClicked) {
                SongDetails(song);
            }

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(songLib.getPrimaryStage());
            alert.setTitle("Nothing selected");
            alert.setHeaderText("None selected");
            alert.setContentText("Please select a song in the table.");
            
            alert.showAndWait();
        }
    }
}