package com.example.pt09fileio2072028;

import com.example.pt09fileio2072028.model.Komentar;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public TextField txtUsername;
    public TextArea txtKomentar;
    public Button btnSave2;
    public Button btnLoad2;
    public Button btnAdd;
    public Button btnSave;
    public Button btnLoad;
    public ListView listviewKomentar;
    public Button btnSaveFile;
    public Button btnLoadFile;
    private ObservableList<Komentar> komenList;
    private ObservableList<String> strList;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize() {
        komenList = FXCollections.observableArrayList();
    }

    public void addNewData(ActionEvent actionEvent) {
        komenList.add(new Komentar(txtUsername.getText(), txtKomentar.getText()));
        listviewKomentar.setItems(komenList);
    }

    public void saveIo(ActionEvent actionEvent) {
        BufferedWriter writer;
        String path = "data/hasil.txt";
        try {
            writer = new BufferedWriter(new FileWriter(path));
            Gson gson = new Gson();
            String komenJson = gson.toJson(listviewKomentar.getItems());
            writer.write(komenJson);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void loadIo(ActionEvent actionEvent) {
        String path = "data/hasil.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String sTemp;
            String hasil = "";
            while ( (sTemp = reader.readLine()) != null) {
                hasil += sTemp + "\n";
            }
            Gson gson = new Gson();
            Komentar[] cArray = gson.fromJson(hasil, Komentar[].class);
            ObservableList<Komentar> cList = FXCollections.observableArrayList(cArray);
            listviewKomentar.setItems(cList);
            komenList = listviewKomentar.getItems();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveNio(ActionEvent actionEvent) {
        Path p = Paths.get("data/hasil.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(p, Charset.forName("UTF-8"))) {
            Gson gson = new Gson();
            String komenJson = gson.toJson(listviewKomentar.getItems());
            writer.write(komenJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadNio(ActionEvent actionEvent) {
        Path p = Paths.get("data/hasil.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);
            String hasil = "";
            for (String sTemp:lines) {
                hasil += sTemp+"\n";
            }
            Gson gson = new Gson();
            Komentar[] cArray = gson.fromJson(hasil, Komentar[].class);
            ObservableList<Komentar> cList = FXCollections.observableArrayList(cArray);
            listviewKomentar.setItems(cList);
            komenList = listviewKomentar.getItems();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(ActionEvent actionEvent) {
        BufferedWriter writer;
        FileChooser chooser = new FileChooser();
        File path = chooser.showSaveDialog(new Stage());
        try {
            writer = new BufferedWriter(new FileWriter(path));
            Gson gson = new Gson();
            String komenJson = gson.toJson(listviewKomentar.getItems());
            writer.write(komenJson);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File path = chooser.showOpenDialog(new Stage());
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String sTemp;
            String hasil = "";
            while ( (sTemp = reader.readLine()) != null) {
                hasil += sTemp + "\n";
            }
            Gson gson = new Gson();
            Komentar[] cArray = gson.fromJson(hasil, Komentar[].class);
            ObservableList<Komentar> cList = FXCollections.observableArrayList(cArray);
            listviewKomentar.setItems(cList);
            komenList = listviewKomentar.getItems();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}