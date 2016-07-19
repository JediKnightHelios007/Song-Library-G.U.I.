/*
Cyril Manayath
Isaac Manayath

 */



package list.of.songs.model;

import java.time.LocalDate;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Song {

    private final StringProperty Name;
    private final StringProperty Artist;
    private final StringProperty Album;
    private final IntegerProperty Year;

    // Constructor with some initial data.

    public Song(String Name, String Album, String Artist, int Year) {
        this.Name = new SimpleStringProperty(Name);
        this.Album = new SimpleStringProperty(Album);     
        this.Artist = new SimpleStringProperty(Artist);
        this.Year = new SimpleIntegerProperty(Year);
      
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public StringProperty NameProperty() {
        return Name;
    }

    public String getArtist() {
        return Artist.get();
    }

    public void setArtist(String Artist) {
        this.Artist.set(Artist);
    }

    public StringProperty ArtistProperty() {
        return Artist;
    }

    public String getAlbum() {
        return Album.get();
    }

    public void setAlbum(String Album) {
        this.Album.set(Album);
    }

    public StringProperty AlbumProperty() {
        return Album;
    }

    public int getYear() {
        return Year.get();
    }

    public void setYear(int Year) {
        this.Year.set(Year);
    }

    public IntegerProperty YearProperty() {
        return Year;
    }

}