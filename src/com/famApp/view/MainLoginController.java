package com.famApp.view;


import java.io.IOException;

import com.biz.MemberBiz;
import com.famApp.view.ChatClient;
import com.famApp.MainApp;
import com.model.Member;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainLoginController {
	
	 // ���� ���ø����̼� ����
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

	@FXML
    private TextField login_idField;
    @FXML
    private TextField login_pwField;
    @FXML
    private TextField login_familyIDField;
    
    private Stage dialogStage;
    private Member member;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMember(Member login_member) {
        this.member = login_member;
        login_idField.setText(login_member.getMember_id());
        login_pwField.setText(login_member.getPassword());
        login_familyIDField.setText(login_member.getFamily_id());
        
    }
    
    
    public boolean isOkClicked() {
        return okClicked;}
    
    @FXML
    private void handleOk() {
    	if (isInputValid()) {
    		Member member = new Member();
    		member.setMember_id(login_idField.getText());
    		member.setPassword(login_pwField.getText());
    		member.setFamily_id(login_familyIDField.getText());
    		int rs = new MemberBiz().getLogIn(member);
    		if (rs == 1) {
    			okClicked = true;
    			
    			//ä�� Ŭ���̾�Ʈ�� ����
    			String id = member.getMember_id();
    			ChatClient client = new ChatClient(id);
    			client.start();
    			
    			//����â����
    	   		mainApp.showOverview(member);	
    		}else {
    			Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("wrong id or pw");
                alert.showAndWait();

    		}
    	}
     }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
   
    @FXML
    private void handleSignUp() {
    	Member newMember = new Member();
        mainApp.showSignUpDialog(newMember);
     } 
   

    private boolean isInputValid() {
        String errorMessage = "";

        if (login_idField.getText() == null || login_idField.getText().length() == 0) {
            errorMessage += "No valid id!\n";
        }
        if (login_pwField.getText() == null || login_pwField.getText().length() == 0) {
            errorMessage += "No valid last password!\n";
        }
        if (login_familyIDField.getText() == null || login_familyIDField.getText().length() == 0) {
            errorMessage += "No valid family id!\n";
        }
     
        if (errorMessage.length() == 0) {
            return true;
            
        } else {
            // ���� �޽����� �����ش�.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    
    /**
     * ���ø����̼��� �ݴ´�.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
