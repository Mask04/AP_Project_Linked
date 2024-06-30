package org.Linked.client.viewControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.gleidson28.GNAvatarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.Linked.client.viewControllers.Http.HttpController;
import org.Linked.client.viewControllers.Http.HttpMethod;
import org.Linked.client.viewControllers.Http.HttpResponse;
import org.Linked.client.viewControllers.Utils.JWTController;
import org.Linked.client.viewControllers.Utils.UserTypeAdapter;
import org.Linked.server.Model.Education;
import org.Linked.server.Model.Follow;
import org.Linked.server.Model.Skill;
import org.Linked.server.Model.User;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.ArrayList;

public class ProfileController extends AbstractViewController{

    @FXML
    private Label GradeEduLabel;

    @FXML
    private Label GraduationDateEduLabel;

    @FXML
    private RadioButton MobileNumberContactsRB;

    @FXML
    private Label RegisterDateEduLabel;

    @FXML
    private Label activityDescriptionEduLabel;

    @FXML
    private TextArea activityEduTF;

    @FXML
    private Label addInfoEduLabel;

    @FXML
    private TextArea additionalEduTF;

    @FXML
    private TextField additionalNameEditTF;

    @FXML
    private Label addressContactsLabel;

    @FXML
    private TextArea addressContactsTF;

    @FXML
    private ImageView bannerImageView;

    @FXML
    private DatePicker birthdayContactsDP;

    @FXML
    private Label birthdayContactsLabel;

    @FXML
    private Button cancelContactsButton;

    @FXML
    private Button cancelEduButton;

    @FXML
    private Button cancelInfoButton;

    @FXML
    private Button cancelSkillsButton;

    @FXML
    private Button chooseAvatarButton;

    @FXML
    private Button chooseBannerButton;

    @FXML
    private Label cityAndCountryLabel;

    @FXML
    private TextField cityEditTF;

    @FXML
    private Button connectButton;

    @FXML
    private RadioButton contactsOnlyBirthContactsRB;

    @FXML
    private TextField countryEditTF;

    @FXML
    private Button editContactButton;

    @FXML
    private Button editEduButton;

    @FXML
    private Button editInfoButton;

    @FXML
    private VBox editInfoVbox;

    @FXML
    private Label educationLabel1;

    @FXML
    private Label educationLabel11;

    @FXML
    private Label emailContactsLabel;

    @FXML
    private TextField emailContactsTF;

    @FXML
    private RadioButton everyoneBirthContactsRB;

    @FXML
    private TextField firstNameEditTF;

    @FXML
    private Button followButton;

    @FXML
    private Label fullNameLabel;

    @FXML
    private TextField gradeEduTF;

    @FXML
    private DatePicker graduateDateDP;

    @FXML
    private TextArea headLineTA;

    @FXML
    private TextArea headlineEditTA;

    @FXML
    private RadioButton hiringRadioBtn;

    @FXML
    private Button homeButton;

    @FXML
    private HBox homeHbox;

    @FXML
    private RadioButton homeNumberContactsRB;

    @FXML
    private Label instituteNameEduLabel;

    @FXML
    private TextField instituteNameEduTF;

    @FXML
    private RadioButton jobRadioBtn;

    @FXML
    private TextField lastNameEditTF;

    @FXML
    private Label majorEduLabel;

    @FXML
    private TextField majorEduTF;

    @FXML
    private RadioButton nobodyBirthContactsRB;

    @FXML
    private Button notificationButton;

    @FXML
    private HBox notificationHbox;

    @FXML
    private Label numberContactsLabel;

    @FXML
    private TextField numberContactsTF;

    @FXML
    private ToggleGroup numberFormat;

    @FXML
    private Label otherAccContactsLabel;

    @FXML
    private TextArea otherAccountsContactsTF;

    @FXML
    private TextField professionEditTF;

    @FXML
    private Label professionLabel;

    @FXML
    private GNAvatarView profileAvatar;

    @FXML
    private BorderPane profileBP;

    @FXML
    private Button profileButton;

    @FXML
    private HBox profileHbox;

    @FXML
    private StackPane profileStackPane;

    @FXML
    private DatePicker registerDateDP;

    @FXML
    private BorderPane rootBP;

    @FXML
    private Button saveContactsButton;

    @FXML
    private Button saveEduButton;

    @FXML
    private Button saveInfoButton;

    @FXML
    private Button saveSkillsButton;

    @FXML
    private Button searchButton;

    @FXML
    private HBox searchHbox;

    @FXML
    private RadioButton servicesRadioBtn;

    @FXML
    private Button settingButton;

    @FXML
    private HBox settingHbox;

    @FXML
    private Label skill1SkillsLabel;

    @FXML
    private Label skill1SkillsLabel1;

    @FXML
    private Label skill1SkillsLabel2;

    @FXML
    private Label skill1SkillsLabel3;

    @FXML
    private Label skill1SkillsLabel4;

    @FXML
    private TextField skill1SkillsTF;

    @FXML
    private TextField skill2SkillsTF;

    @FXML
    private TextField skill3SkillsTF;

    @FXML
    private TextField skill4SkillsTF;

    @FXML
    private TextField skill5SkillsTF;

    @FXML
    private VBox tabVBox;

    @FXML
    private RadioButton workNumberContactsRB;

    @FXML
    private VBox contactsInfoVbox;

    @FXML
    private VBox educationVbox;

    @FXML
    private VBox skillsVbox;

    @FXML
    private Button editSkillsButton;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String avatarAddress;
    private String bannerAddress;
    private static String currentUserEmail = JWTController.getSubjectFromJwt(JWTController.getJwtKey()).split(":")[0];
    private static String profileUserEmail = currentUserEmail;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String firstName;
    private String lastName;
    private String password;
    private JsonNode additionalName;
    private JsonNode headline;
    private JsonNode country;
    private JsonNode city;
    private JsonNode profession;
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    private JsonNode instituteName;
    private JsonNode major;
    private JsonNode registerDate;
    private JsonNode graduationDate;
    private JsonNode grade;
    private JsonNode activityDiscription;
    private JsonNode additionalInformation;
    /////////////////////////////////////////////////////////////////////////////////////////////////
    private JsonNode email;
    private JsonNode phoneNumber;
    private JsonNode address;
    private JsonNode birthday;
    private JsonNode otherAccounts;
    /////////////////////////////////////////////////





    @FXML
    private final ToggleGroup status = new ToggleGroup();

    @FXML
    public void initialize() {
        bannerImageView.fitWidthProperty().bind(profileBP.widthProperty());
        jobRadioBtn.setToggleGroup(status);
        hiringRadioBtn.setToggleGroup(status);
        servicesRadioBtn.setToggleGroup(status);
        editInfoVbox.setVisible(false);
        editInfoVbox.setDisable(true);

        /* ___ GET USER INFO ___ */

        HttpResponse userResponse = getUserResponse();

        JsonNode userJson = getUserJson(userResponse);

        firstName = userJson.get("firstName").asText();
        lastName = userJson.get("lastName").asText();
        password = userJson.get("password").asText();
        additionalName = userJson.get("additionalName");
        headline = userJson.get("headline");
        country = userJson.get("country");
        String countryName = country == null ? "" : country.asText();
        city = userJson.get("city");
        String cityName = city == null ? "" : city.asText();
        profession = userJson.get("profession");

        firstNameEditTF.setText(firstName);
        additionalNameEditTF.setText(additionalName == null ? "" : additionalName.asText());
        lastNameEditTF.setText(lastName);
        headlineEditTA.setText(headline == null ? "" : headline.asText());
        countryEditTF.setText(countryName);
        cityEditTF.setText(cityName);
        professionEditTF.setText(profession == null ? "" : profession.asText());

        avatarAddress = userJson.get("profilePicture") == null ? null : userJson.get("profilePicture").asText();
        bannerAddress = userJson.get("backgroundPicture") == null ? null : userJson.get("backgroundPicture").asText();

        if (avatarAddress != null){
            Image avatar = new Image(Paths.get(avatarAddress).toUri().toString());
            profileAvatar.setImage(avatar);
        }

        if (bannerAddress != null){
            Image banner = new Image(Paths.get(bannerAddress).toUri().toString());
            bannerImageView.setImage(banner);
        }

        fullNameLabel.setText(firstName + " " + (additionalName == null ? "" : (additionalName.asText() + " ")) + lastName);
        headLineTA.setText(headline == null ? "No Headline." : headline.asText());
        professionLabel.setText(profession == null ? "No profession." : profession.asText());
        cityAndCountryLabel.setText(cityName + ", " + countryName);

        //education
        HttpResponse educationResponse = getEducationResponse();

        JsonNode educationJson = getEducationJson(educationResponse);

        if (educationJson != null) {
            instituteName = educationJson.get("collegeName");
            major = educationJson.get("major");
            registerDate = educationJson.get("enterYear");
            graduationDate = educationJson.get("exitYear");
            grade = educationJson.get("grade");
            activityDiscription = educationJson.get("activitiesInfo");
            additionalInformation = educationJson.get("additionalInfo");

            instituteNameEduTF.setText(instituteName == null ? "" : instituteName.asText());
            majorEduTF.setText(major == null ? "" : major.asText());
            registerDateDP.setChronology(registerDate == null ? Chronology.of(""): Chronology.of(registerDate.asText()));
            graduateDateDP.setChronology(graduationDate == null ? Chronology.of(""): Chronology.of(graduationDate.asText()));
            gradeEduTF.setText(grade == null ? "" : grade.asText());
            activityEduTF.setText(activityDiscription == null ? "" : activityDiscription.asText());
            additionalEduTF.setText(additionalInformation == null ? "" : additionalInformation.asText());

            instituteNameEduLabel.setText(instituteName == null ? "no institute name mentioned" : instituteName.asText());
            majorEduLabel.setText(major == null ? "no major mentioned" : major.asText());
            RegisterDateEduLabel.setText(registerDate == null ? "no register date mentioned" : registerDate.asText()); //idk if it works or not
            GraduationDateEduLabel.setText(graduationDate == null ? "no graduation date mentioned" :graduationDate.asText()); //idk if it works or not
            GradeEduLabel.setText(grade == null ? "no grade mentioned" : grade.asText());
            activityDescriptionEduLabel.setText(activityDiscription == null ? "no activity discription mentioned" : activityDiscription.asText());
            addInfoEduLabel.setText(additionalInformation == null ? "no additional information mentioned" : additionalInformation.asText());
        }

        // contacts info
        HttpResponse contactsResponse = getContactsInfoResponse();

        JsonNode contactsJson = getContactsJson(contactsResponse);

        if (contactsJson != null) {
            email = contactsJson.get("email");
            phoneNumber = contactsJson.get("phoneNumber");
            address = contactsJson.get("address");
            birthday = contactsJson.get("birthday");
            otherAccounts = contactsJson.get("contactUs");

            emailContactsTF.setText(email == null ? "" : email.asText());
            numberContactsTF.setText(phoneNumber == null ? "" : phoneNumber.asText());
            addressContactsTF.setText(address == null ? "" : address.asText());
            birthdayContactsDP.setChronology(birthday == null ? Chronology.of("") : Chronology.of(birthday.asText())); //idk if it works or not
            otherAccountsContactsTF.setText(otherAccounts == null ? "" : otherAccounts.asText());

            emailContactsLabel.setText(email == null ? "no email mentioned" : email.asText());
            numberContactsLabel.setText(phoneNumber == null ? "no number mentioned" : phoneNumber.asText());
            addressContactsLabel.setText(address == null ? "no address mentioned" : address.asText());
            birthdayContactsLabel.setText(birthday == null ? "no birthday mentioned" : birthday.asText()); //idk if it works or not
            otherAccContactsLabel.setText(otherAccounts == null ? "no other account mentioned" : otherAccounts.asText());
        }

        // skills








        if (profileUserEmail.equals(currentUserEmail)) {
            followButton.setVisible(false);
            connectButton.setVisible(false);
        } else {
            editInfoButton.setVisible(false);
            editContactButton.setVisible(false);
            editEduButton.setVisible(false);
            editSkillsButton.setVisible(false);

            try {
                HttpResponse httpResponse = HttpController.sendRequest(SERVER_ADDRESS + "/follow/" + currentUserEmail +
                        "/" + profileUserEmail, HttpMethod.GET, null, null);
                if (!httpResponse.getBody().equals("No such follow info found!") ) {
                    followButton.setText("Following");
                } else {
                    followButton.setText("Follow");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void on_searchButton_clicked(ActionEvent event) {
        switchScenes("/fxml/searchView.fxml", searchButton);
    }

    @FXML
    void on_cancelInfoButton_clicked(ActionEvent event) {
        editInfoVbox.setVisible(false);
        editInfoVbox.setDisable(true);
    }

    @FXML
    void on_chooseAvatarButton_clicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        avatarAddress = selectedFile == null ? null : selectedFile.getAbsolutePath();
    }

    @FXML
    void on_chooseBannerButton_clicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        bannerAddress = selectedFile == null ? null : selectedFile.getAbsolutePath();
    }

    @FXML
    void on_editInfoButton_clicked(ActionEvent event) {
        editInfoVbox.setDisable(false);
        editInfoVbox.setVisible(true);
    }

    @FXML
    void on_saveInfoButton_clicked(ActionEvent event) {
        String newAdditionalName = additionalNameEditTF.getText();
        String newHeadline = headlineEditTA.getText();
        String newCountry = countryEditTF.getText();
        String newCity = cityEditTF.getText();
        String newProfession = professionEditTF.getText();
        User user = new User(currentUserEmail, firstNameEditTF.getText(), lastNameEditTF.getText(), password,
                newAdditionalName, avatarAddress, bannerAddress, newHeadline, newCountry, newCity, newProfession,
                JWTController.getJwtKey());


        String userJson = gson.toJson(user);

        try {
            HttpResponse response = HttpController.sendRequest(SERVER_ADDRESS + "/users", HttpMethod.PUT, userJson, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        editInfoVbox.setDisable(true);
        editInfoVbox.setVisible(false);
        initialize();
    }

    @FXML
    void on_followButton_clicked(ActionEvent event) {
        if (followButton.getText().equals("Follow")){
            Follow follow = new Follow(currentUserEmail, profileUserEmail);
            String followJson = gson.toJson(follow);

            try {
                HttpController.sendRequest(SERVER_ADDRESS + "/follow/" + currentUserEmail, HttpMethod.POST, followJson, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            followButton.setText("Following");
        } else {
            try {
                HttpController.sendRequest(SERVER_ADDRESS + "/follow/" + currentUserEmail + "/" + profileUserEmail,
                        HttpMethod.DELETE, null, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            followButton.setText("Follow");
        }
        initialize();
    }

    private HttpResponse getUserResponse(){
        HttpResponse userResponse;
        try {
            userResponse = HttpController.sendRequest(SERVER_ADDRESS + "/users/" + profileUserEmail, HttpMethod.GET, null, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (userResponse.getStatusCode() != 200) throw new RuntimeException("Error getting user data");

        return userResponse;
    }

    private HttpResponse getEducationResponse(){
        HttpResponse educationResponse;
        try {
            educationResponse = HttpController.sendRequest(SERVER_ADDRESS + "/education/" + profileUserEmail ,HttpMethod.GET , null , null);
        } catch (IOException e){
            throw  new RuntimeException(e);
        }

        if (educationResponse.getStatusCode() != 200) throw new RuntimeException("Error getting education data");
        return  educationResponse;
    }

    private HttpResponse getContactsInfoResponse(){
        HttpResponse contactsInfoResponse;
        try {
            contactsInfoResponse = HttpController.sendRequest(SERVER_ADDRESS + "/contacts/" + profileUserEmail , HttpMethod.GET , null , null);
        }catch (IOException e){
            throw  new RuntimeException(e);
        }

        if (contactsInfoResponse.getStatusCode() != 200) throw new RuntimeException("Error getting contactsInfo data");
        return  contactsInfoResponse;

    }

    private JsonNode getUserJson(HttpResponse userResponse){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readTree(userResponse.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonNode getEducationJson(HttpResponse EducationResponse){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (EducationResponse.getBody().equals("No such education info found!")) return null;
            return objectMapper.readTree(EducationResponse.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonNode getContactsJson(HttpResponse contactsResponse){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (contactsResponse.getBody().equals("No such contact found!")) return null;
            return objectMapper.readTree(contactsResponse.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void on_cancelContactsButton_clicked(ActionEvent event) {
        contactsInfoVbox.setVisible(false);
        contactsInfoVbox.setDisable(true);
    }

    @FXML
    void on_cancelEduButton_Clicked(ActionEvent event) {
        educationVbox.setVisible(false);
        educationVbox.setDisable(true);
    }


    @FXML
    void on_cancelSkillsButton_clicked(ActionEvent event) {
        skillsVbox.setVisible(false);
        skillsVbox.setDisable(true);
    }
    @FXML
    void on_editContactButton_clicked(ActionEvent event) {
        contactsInfoVbox.setDisable(false);
        contactsInfoVbox.setVisible(true);
    }

    @FXML
    void on_editEduButton_clicked(ActionEvent event) {
        educationVbox.setDisable(false);
        educationVbox.setVisible(true);
    }

    @FXML
    void on_editSkillsButton_clicked(ActionEvent event) {
        skillsVbox.setDisable(false);
        skillsVbox.setVisible(true);
    }



    @FXML
    void on_saveContactsButton_clicked(ActionEvent event) {

    }

    @FXML
    void on_saveEduButton_clicked(ActionEvent event) {
        String newInstituteName = instituteNameEduTF.getText();
        String newMajor = majorEduTF.getText();
        String newGrade = gradeEduTF.getText();
        String newActivityDescription = activityEduTF.getText();
        String newAdditionalInformation = additionalEduTF.getText();
        LocalDate localDate1 = registerDateDP.getValue();
        java.sql.Date newRegisterDate = java.sql.Date.valueOf(localDate1);
        LocalDate localDate2 = graduateDateDP.getValue();
        java.sql.Date newGraduateDate = java.sql.Date.valueOf(localDate2);
        ArrayList<String> newSkills = null;

        Education education = new Education(profileUserEmail , newInstituteName , newMajor, newRegisterDate ,
                newGraduateDate , newGrade , newActivityDescription ,newSkills, newAdditionalInformation);


        String educationJson = gson.toJson(education);

        try {
            HttpResponse response = HttpController.sendRequest(SERVER_ADDRESS + "/education", HttpMethod.PUT, educationJson, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        educationVbox.setDisable(true);
        educationVbox.setVisible(false);
        initialize();
    }



    @FXML
    void on_saveSkillsButton_clicked(ActionEvent event) {

    }

    public static String getCurrentUserEmail() {
        return currentUserEmail;
    }

    public static void setCurrentUserEmail(String currentUserEmail) {
        ProfileController.currentUserEmail = currentUserEmail;
    }

    public static String getProfileUserEmail() {
        return profileUserEmail;
    }

    public static void setProfileUserEmail(String profileUserEmail) {
        ProfileController.profileUserEmail = profileUserEmail;
    }
}