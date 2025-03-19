package package1;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.collections.*;
import javafx.scene.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main extends Application {

    TabPane tabPane;
    String patientName;
    int patientAge;
    String medicalRecords;
    long aadharnumber;
     String guardianname;
     long phone;
     LocalDate dob;
     String a1;
     String a2;
     String a3;
     String a4;
     int a5;
     double tax;
    double amt;
    String selectedPatientName;
    String selectedTimeSlot;
    String selectedDepartment;
    String selectedDoctor;
    String selectedDate;
	
    private ComboBox<String> timeSlotComboBox = new ComboBox<>();
    Map<String, Map<DayOfWeek, List<String>>> doctorTimeSlots = new HashMap<>();
    @Override
    public void start(Stage primaryStage) {
    	
        tabPane = new TabPane();

        
        Tab registrationTab = new Tab("Patient Registration");
        registrationTab.setContent(createRegistrationForm());
        

        Tab appointmentTab = new Tab("Appointment Scheduling");
        appointmentTab.setContent(createAppointmentForm());
       
        tabPane.getTabs().addAll(registrationTab, appointmentTab);

        Scene scene = new Scene(tabPane, 600, 400);
        primaryStage.setTitle("Healthcare Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
        initializeDoctorTimeSlots();
    }
    private void initializeDoctorTimeSlots() {
        doctorTimeSlots.put("Dr. Naresh Trehan", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Sandeep Vaishya", Map.of(
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Balbir Singh", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Tanaya Das", Map.of(
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SUNDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Namita Kaul", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Abhay Kumar", Map.of(
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Yash Oberoi", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Sarita Rao", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Rakesh Mahajan", Map.of(
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SUNDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Pranit Reddy", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Ashok Rajgopal", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Sunita Kumar", Map.of(
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.THURSDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.FRIDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SUNDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
        
        doctorTimeSlots.put("Dr. Indira Pavan", Map.of(
            DayOfWeek.MONDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.TUESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.WEDNESDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM"),
            DayOfWeek.SATURDAY, List.of("8-11 AM", "1-4 PM", "5-8 PM")
        ));
    }
    private void updateAvailableTimeSlots(String selectedDoctor, LocalDate selectedDate) {
        timeSlotComboBox.getItems().clear();

        if (selectedDoctor != null && selectedDate != null) {
            DayOfWeek selectedDay = selectedDate.getDayOfWeek();
            List<String> availableSlots = doctorTimeSlots.getOrDefault(selectedDoctor, Map.of()).get(selectedDay);

            if (availableSlots != null) {
                timeSlotComboBox.getItems().addAll(availableSlots);
            }
        }
    }
    private void registerPatient() {
    	Tab billingTab = new Tab("Billing");
        billingTab.setContent(createBillingForm());
    	tabPane.getTabs().add(billingTab);  
    	}
    private ScrollPane createRegistrationForm() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        Image backgroundImage = new Image("file:background.png");
        BackgroundImage bgImage = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, 
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        vbox.setBackground(new Background(bgImage));

        ImageView logoView = new ImageView(new Image("file:logo.png"));
        logoView.setFitWidth(100); 
        logoView.setPreserveRatio(true); 
        RadioButton yesRadioButton = new RadioButton("Yes");
        RadioButton noRadioButton = new RadioButton("No");
        ToggleGroup registeredGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(registeredGroup);
        noRadioButton.setToggleGroup(registeredGroup);

        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField aadharField = new TextField();
        TextField guardianField = new TextField();
        TextField phoneField = new TextField();
        DatePicker dp = new DatePicker();
        TextField a11 = new TextField();
        TextField a12 = new TextField();
        TextField a13 = new TextField();
        TextField a14 = new TextField();
        TextField a15 = new TextField();
        a11.setPromptText("house no./street");
        a12.setPromptText("area/locality");
        a13.setPromptText("city");
        a14.setPromptText("state");
        a15.setPromptText("pincode");

        CheckBox medicalRecord1 = new CheckBox("Diabetes");
        CheckBox medicalRecord2 = new CheckBox("Hypertension");
        CheckBox medicalRecord3 = new CheckBox("Asthma");
        CheckBox medicalRecord4 = new CheckBox("None");
        CheckBox medicalRecordOther = new CheckBox("Other");

        TextField otherTextField = new TextField();
        otherTextField.setPromptText("Please specify...");
        otherTextField.setVisible(false); 
        medicalRecordOther.selectedProperty().addListener((observable, oldValue, newValue) -> {
            otherTextField.setVisible(newValue);
        });
        
        medicalRecord4.selectedProperty().addListener((observable, oldValue, isSelected) -> {
            if (isSelected) {
                medicalRecord1.setSelected(false);
                medicalRecord2.setSelected(false);
                medicalRecord3.setSelected(false);
                medicalRecordOther.setSelected(false);
                otherTextField.setVisible(false);
            }
        });

        medicalRecord1.selectedProperty().addListener((observable, oldValue, isSelected) -> {
            if (isSelected) {
                medicalRecord4.setSelected(false);
            }
        });

        medicalRecord2.selectedProperty().addListener((observable, oldValue, isSelected) -> {
            if (isSelected) {
                medicalRecord4.setSelected(false);
            }
        });

        medicalRecord3.selectedProperty().addListener((observable, oldValue, isSelected) -> {
            if (isSelected) {
                medicalRecord4.setSelected(false);
            }
        });

        medicalRecordOther.selectedProperty().addListener((observable, oldValue, isSelected) -> {
            if (isSelected) {
                medicalRecord4.setSelected(false);
            }
        });

        Button registerButton = new Button("Register");

        vbox.getChildren().addAll(
            logoView,
            new Label("Are you registered?"), yesRadioButton, noRadioButton,
            new Label("Name:"), nameField,
            new Label("Age:"), ageField,
            new Label("Aadhar Number:"), aadharField,
            new Label("Parent/Guardian Name:"), guardianField,
            new Label("Phone Number:"), phoneField,
            new Label("Date of Birth:"),dp,
            new Label("Address info"), a11, a12, a13, a14, a15,
            new Label("Medical Records:"),
            medicalRecord1, medicalRecord2, medicalRecord3, medicalRecord4, medicalRecordOther, otherTextField,
            registerButton
        );

        registeredGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == yesRadioButton) {
                tabPane.getSelectionModel().select(1); 
            } else {
                nameField.setDisable(false);
                ageField.setDisable(false);
                aadharField.setDisable(false);
                guardianField.setDisable(false);
                dp.setDisable(false);
                a11.setDisable(false);
                a12.setDisable(false);
                a13.setDisable(false);
                a14.setDisable(false);
                a15.setDisable(false);
                medicalRecord1.setDisable(false);
                medicalRecord2.setDisable(false);
                medicalRecord3.setDisable(false);
                medicalRecord4.setDisable(false);
                medicalRecordOther.setDisable(false);
                registerButton.setDisable(false);
            }
        });

        registerButton.setOnAction(event -> {
            patientName = nameField.getText();
            dob=dp.getValue();
            patientAge = Integer.parseInt(ageField.getText());
            aadharnumber = Long.parseLong(aadharField.getText());
            guardianname = guardianField.getText();
            a1 = a11.getText();
            a2 = a12.getText();
            a3 = a13.getText();
            a4 = a14.getText();
            a5 = Integer.parseInt(a15.getText());
            phone = Long.parseLong(phoneField.getText());
            medicalRecords = getSelectedMedicalRecords(medicalRecord1, medicalRecord2, medicalRecord3, medicalRecord4, medicalRecordOther, otherTextField);
            System.out.println("Registered:"+patientName);
            tabPane.getSelectionModel().select(1);
            registerPatient();
        });

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }

    private String getSelectedMedicalRecords(CheckBox medicalRecord1, CheckBox medicalRecord2, CheckBox medicalRecord3, CheckBox medicalRecord4, CheckBox medicalRecordOther, TextField otherTextField) {
        StringBuilder records = new StringBuilder();
        if (medicalRecord1.isSelected()) records.append("Diabetes, ");
        if (medicalRecord2.isSelected()) records.append("Hypertension, ");
        if (medicalRecord3.isSelected()) records.append("Asthma, ");
        if (medicalRecord4.isSelected()) records.append("None, ");
        if (medicalRecordOther.isSelected()) records.append("Other: ").append(otherTextField.getText()).append(", ");
        if (records.length() > 0) records.setLength(records.length() - 2); 
        return records.toString();
    }

    private ScrollPane createAppointmentForm() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(50));
        vbox.setId("appointment-form");
        vbox.setAlignment(Pos.CENTER); 
        vbox.setStyle("-fx-background-color: #BFDAA4;");
        

        VBox backgroundBox = new VBox();
        
        backgroundBox.setStyle("-fx-background-color: #BFDAA4; -fx-padding: 20; -fx-spacing: 100;"); 
        backgroundBox.setAlignment(Pos.CENTER); 
        
           
        
           
        DatePicker datePicker = new DatePicker();
        ComboBox<String> departmentComboBox = new ComboBox<>();
        departmentComboBox.getItems().addAll("Cardiology", "Neurology", "Orthopedics", "Pediatrics");

        ComboBox<String> doctorComboBox = new ComboBox<>();

        Map<String, ObservableList<String>> departmentDoctors = new HashMap<>();
        departmentDoctors.put("Cardiology", FXCollections.observableArrayList("Dr. Naresh Trehan", "Dr. Sandeep Vaishya", "Dr. Balbir Singh", "Dr. Tanaya Das"));
        departmentDoctors.put("Neurology", FXCollections.observableArrayList("Dr. Namita Kaul", "Dr. Abhay Kumar", "Dr. Yash Oberoi"));
        departmentDoctors.put("Orthopedics", FXCollections.observableArrayList("Dr. Sarita Rao", "Dr. Rakesh Mahajan", "Dr. Pranit Reddy"));
        departmentDoctors.put("Pediatrics", FXCollections.observableArrayList("Dr. Ashok Rajgopal", "Dr. Sunita Kumar", "Dr. Indira Pavan"));

        ObservableList<String> allDoctors = FXCollections.observableArrayList(
                "Dr. Naresh Trehan", "Dr. Sandeep Vaishya", "Dr. Balbir Singh", "Dr. Tanaya Das",
                "Dr. Namita Kaul", "Dr. Abhay Kumar", "Dr. Yash Oberoi",
                "Dr. Sarita Rao", "Dr. Rakesh Mahajan", "Dr. Pranit Reddy",
                "Dr. Ashok Rajgopal", "Dr. Sunita Kumar", "Dr. Indira Pavan"
            );
            doctorComboBox.setItems(allDoctors); 

            departmentComboBox.setOnAction(event -> {
                String selectedDepartment = departmentComboBox.getSelectionModel().getSelectedItem();
                if (selectedDepartment != null) {
                    doctorComboBox.setItems(departmentDoctors.get(selectedDepartment));
                } else {
                    
                    doctorComboBox.setItems(allDoctors);
                }
            });

            doctorComboBox.setOnAction(event -> {
                String selectedDoctor = doctorComboBox.getSelectionModel().getSelectedItem();
                LocalDate selectedDate = datePicker.getValue();
                updateAvailableTimeSlots(selectedDoctor, selectedDate);
            });

            datePicker.setOnAction(event -> {
                String selectedDoctor = doctorComboBox.getSelectionModel().getSelectedItem();
                LocalDate selectedDate = datePicker.getValue();
                updateAvailableTimeSlots(selectedDoctor, selectedDate);
            });

        Button bookButton = new Button("Book Appointment");
        bookButton.setId("book-button");

        Text heading = new Text("SELECT YOUR SLOT");
        heading.setFont(Font.font("Times New Roman", 40)); 

        
        HBox departmentAndDoctorBox = new HBox(10,
        	    new VBox(
        	        new Label("Select Department:"),  
        	        departmentComboBox                
        	    ),
        	    new VBox(
        	        new Label("Select Doctor:"),      
        	        doctorComboBox                    
        	    )
        	);
        departmentAndDoctorBox.setAlignment(Pos.CENTER);
        departmentAndDoctorBox.setSpacing(80);
            
        HBox dateAndTimeSlotBox = new HBox(10, 
                new VBox(
            	    new Label("Select Date:"), 
            	    datePicker                  
            	),
            	new VBox(
            	    new Label("Available Time Slots:"), 
            	    timeSlotComboBox                   
            	)
        );
            dateAndTimeSlotBox.setAlignment(Pos.CENTER);
            dateAndTimeSlotBox.setSpacing(80);
            double preferredWidth = 300; 
            double preferredHeight = 40;  

            departmentComboBox.setPrefWidth(preferredWidth);
            doctorComboBox.setPrefWidth(preferredWidth);
            timeSlotComboBox.setPrefWidth(preferredWidth);
            datePicker.setPrefWidth(preferredWidth);

            departmentComboBox.setPrefHeight(preferredHeight);
            doctorComboBox.setPrefHeight(preferredHeight);
            timeSlotComboBox.setPrefHeight(preferredHeight);
            datePicker.setPrefHeight(preferredHeight);
            backgroundBox.getChildren().addAll(heading,departmentAndDoctorBox, dateAndTimeSlotBox, bookButton);
            vbox.getChildren().add(backgroundBox);

            ScrollPane scrollPane = new ScrollPane(vbox);
            scrollPane.setFitToWidth(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); 
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 

            vbox.prefWidthProperty().bind(scrollPane.widthProperty());
            backgroundBox.prefWidthProperty().bind(vbox.widthProperty().subtract(40)); 
            bookButton.setOnAction(event -> 
            {
            	selectedTimeSlot = timeSlotComboBox.getSelectionModel().getSelectedItem();
            	selectedDepartment = departmentComboBox.getSelectionModel().getSelectedItem();
            	selectedDoctor = doctorComboBox.getSelectionModel().getSelectedItem();
                LocalDate sd = datePicker.getValue();
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            	selectedDate=sd.format(formatter);
            	tax=0.13*price(selectedDepartment);
            	amt =tax+price(selectedDepartment);
                tabPane.getSelectionModel().select(2);
            });
            return scrollPane;
        }
        public int price(String s)
        { 
        switch (s)
        {
        	case "Cardiology":return 800;
        	case "Neurology":return 700;
        	case "Orthopedics":return 750;
        	case "Pediatrics":return 500;
        	default:return 0;	
        } 	
        }
        private BorderPane createBillingForm() {
        	 if (patientName == null) {
        		        return new BorderPane(new Label("No patient registered."));
        	   }
            BorderPane borderPane = new BorderPane();
            borderPane.setStyle("-fx-background-color: #BFDAA4;");

            ImageView logoView = new ImageView(new Image("file:logo.png"));
            logoView.setFitWidth(100); 
            logoView.setPreserveRatio(true); 

            HBox topBox = new HBox(10);
            topBox.setPadding(new Insets(10, 50, 10, 50));
            topBox.setAlignment(Pos.CENTER_LEFT);
            topBox.getChildren().add(logoView);

            VBox mainVBox = new VBox();
            mainVBox.setPadding(new Insets(20));

            VBox whiteBox = new VBox(10);
            whiteBox.setPadding(new Insets(20));
            whiteBox.setStyle("-fx-background-color: white; -fx-border-radius: 10; -fx-background-radius: 10;"); 

            TextArea billingDetailsArea = new TextArea();
            billingDetailsArea.setPrefHeight(150);

            Button calculateButton = new Button("Calculate");
            calculateButton.setStyle("-fx-background-color: #1976d2; -fx-text-fill: white;"); 
            HBox b1 = new HBox(10);
            b1.getChildren().addAll(new Label("Patient Name:"), new Label(patientName));
                   
            HBox b2 = new HBox(10);
            b2.getChildren().addAll(new Label("Age:"), new Label(String.valueOf(patientAge)));
           
            HBox b3 = new HBox(10);
            b3.getChildren().addAll(new Label("Aadhar Number:"), new Label(String.valueOf(aadharnumber)));
                    
            HBox b4 = new HBox(10);
            b4.getChildren().addAll(new Label("Parent/Guardian Name:"), new Label(guardianname));
                           
            HBox b5 = new HBox(10);
            b5.getChildren().addAll(new Label("Phone:"), new Label(String.valueOf(phone)));
            
            HBox b6 = new HBox(10);
            b6.getChildren().addAll(new Label("Date of Birth:"), new Label(String.valueOf(dob)));
            
            HBox b7 = new HBox(10);
            b7.getChildren().addAll(new Label("Address:"), new Label(a1+" "+a2+" "+a4+" "+a3+"-"+String.valueOf(a5)));
                
            HBox b8 = new HBox(10);
            b8.getChildren().addAll(new Label("Medical Records:"), new Label(medicalRecords));
            
            whiteBox.getChildren().addAll(
                b1,b2,b3,b4,b5,b6,b7,b8,
                billingDetailsArea,
                calculateButton
            );

            mainVBox.getChildren().add(whiteBox);

            borderPane.setCenter(mainVBox);
            borderPane.setTop(topBox);

            calculateButton.setOnAction(event -> {
                billingDetailsArea.setText("The Doctor appointed to you "+selectedDoctor +" of "+selectedDepartment+" Department\nAppointment date is "+selectedDate+ " from "+selectedTimeSlot+"\ntaxes="+tax+"\nconsultation charges="+amt+"\nYour Appointment is confirmed.Thank you!!");
               
            });

            return borderPane;
        }


    public static void main(String[] args) {
        launch(args);
    }
}

