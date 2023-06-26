package mateusz;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import mateusz.UserFx;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.currentTimeMillis;


public class WindowController implements Initializable {
    @FXML
    Button login=new Button();
    @FXML
    TextField tLogin;
    @FXML
    TextField tName;
    @FXML
    TextField tLastName;
    @FXML
    TextField tPhone;
    @FXML
    TextField tMail;
    @FXML
    TextField tPesel;

    @FXML
    PasswordField tPassword;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Tab tabTables;
    @FXML
    ImageView image;
    @FXML
    Button bAdd;
    @FXML
    Button button2;
    @FXML
    TextField showmeTime;
    @FXML
    TextField YourAdress;



    @FXML
    TableView<UserFx> tabUsers;
    @FXML
    TableColumn cName = new TableColumn();
    @FXML
    TableColumn cLastName = new TableColumn();
    @FXML
    TableColumn cPhone = new TableColumn();
    @FXML
    TableColumn cMail = new TableColumn();
    @FXML
    TableColumn cPesel = new TableColumn();
    @FXML
    TableColumn cAdress = new TableColumn();
    @FXML
    Button Save;


    private ActionEvent actionEvent;


    @FXML
    private DatePicker dateofBirth;
    @FXML
    private TextField ageField;

    @FXML
    private void showAge(ActionEvent he) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int birthYear = (dateofBirth.getValue().getYear());
        int age = year - birthYear;
        ageField.setText(Integer.toString(age) + "Years");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabTables.setDisable(true);
        cName.setCellValueFactory(new PropertyValueFactory<UserFx, String>("Name"));
        cLastName.setCellValueFactory(new PropertyValueFactory<UserFx, String>("LastName"));
        cPhone.setCellValueFactory(new PropertyValueFactory<UserFx, String>("Phone"));
        cMail.setCellValueFactory(new PropertyValueFactory<UserFx, String>("Mail"));
        cPesel.setCellValueFactory(new PropertyValueFactory<UserFx, String>("Pesel"));
        cAdress.setCellValueFactory(new PropertyValueFactory<UserFx, String>("Adress"));
        readfromFile("dane.txt");

    }

    @FXML
    private void doLogin(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
        String login = tLogin.getText();
        String passw = tPassword.getText();
        if (login.equals("Mateusz") && passw.equals("1111")) {
            tabTables.setDisable(false);

        }
    }

    public void AddToTables(ActionEvent actionEvent) {
        String name = tName.getText();
        String lastname = tLastName.getText();
        String phone = tPhone.getText();
        String mail = tMail.getText();
        String pesel = tPesel.getText();
        String adress= YourAdress.getText();
        UserFx newUser = new UserFx(name, lastname, phone, mail, pesel, adress);
        tabUsers.getItems().add(newUser);
        tName.setText(" ");
        tLastName.setText(" ");
        tPhone.setText(" ");
        tMail.setText(" ");
        tPesel.setText(" ");
        YourAdress.setText(" ");
    }


    @FXML
    public void SavetoFile(ActionEvent actionEvent) {
        List<User> Users = new ArrayList<>();
        for (UserFx ux : tabUsers.getItems()) {
            User user = new User(ux.getLastName(),
                    ux.getName(), ux.getPesel(), ux.getPhone(), ux.getMail(), ux.getAdress());
            Users.add(user);
        }
        String text = "";
//     serializacja do Json


        File ux = new File("dane.txt");
        try {
            FileWriter fw = new FileWriter(ux);
            BufferedWriter bw = new BufferedWriter(fw);
            for (User u : Users) {
                bw.write(u.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void showmeTime(ActionEvent actionEvent) {
        Calendar c = Calendar.getInstance();
        LocalDateTime nowDate = LocalDateTime.now();
        String sTime = converttoString(nowDate);
        System.out.println("current date: " + nowDate);
        showmeTime.setText(sTime);
    }
     public String converttoString(LocalDateTime nowDate){
         int h = nowDate.getHour();
         int m = nowDate.getMinute();
         int s = nowDate.getSecond();
         String sTime = "" + h + ":";
         if (m < 10) sTime += "0";
         sTime += m + ":";
         if (s < 10) sTime += "0";
         sTime += s;
         return sTime;
     }
    public void readfromFile(String fileName) {
        File file = new File(fileName);
        Gson gh = new Gson();
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] frag = line.split(";");
                    if (frag.length<5) {
                   continue;
                    }
                    String name = frag[0];
                    String lastName = frag[1];
                    String mail = frag[2];
                    String phone = frag[3];
                    String pesel = frag[4];
                    String adress = frag[5];

                    //User u = new User(name,lastName,mail,phone,pesel);
                    UserFx ux = new UserFx(name, lastName, mail, phone, pesel,adress);
                    tabUsers.getItems().add(ux);

                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());

            }

        }
    }

    public int add(int a, int b) {
        return a + b;

    }
}






