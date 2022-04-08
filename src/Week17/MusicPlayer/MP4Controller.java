package Week17.MusicPlayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Random;

public class MP4Controller {
private ObservableList<String>Playlist;
public ListView<String>Musiclist;
public TextField AddSongTF;
public TextField NowPlayingTF;
  @FXML
    public void initialize() {
      Playlist = FXCollections.observableArrayList("Hooked on a feeling", "uptown girl", "paino man");
      Musiclist.setItems(Playlist);
  }


    public void addButton(ActionEvent amt) {
        String newName =AddSongTF.getText();
        if( newName.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"enter a song to add to the playlist", ButtonType.OK);
            alert.showAndWait();
        }else{ Playlist.add(newName);
            AddSongTF.setText("");}
    }

    public void removeButton() {
        int selectionNumber = Musiclist.getSelectionModel().getSelectedIndex();

        if (selectionNumber == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "select a song to remove from playlist", ButtonType.OK);
            alert.showAndWait();
        } else {
            Playlist.remove(selectionNumber);
          Musiclist.getSelectionModel().clearSelection();
        }
    }

    public void PlayBTN() {
      int select =Musiclist.getSelectionModel().getSelectedIndex();
      if (select==-1){
          Alert alert = new Alert(Alert.AlertType.ERROR, "select a song to play",ButtonType.OK);
          alert.showAndWait();
      }else {
          NowPlayingTF.setText(""+Playlist.get(select));
          NowPlayingTF.setEditable(false);
      }
    }

    public void shuffleBTN(ActionEvent actionEvent) {
       int randomIDX=(int)(Math.random()*Playlist.size());
       NowPlayingTF.setText(""+Playlist.get(randomIDX));
    }

    public void StopBTN(ActionEvent actionEvent) {
    }
}



