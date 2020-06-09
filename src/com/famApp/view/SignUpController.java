package com.famApp.view;

import com.biz.MemberBiz;
import com.famApp.MainApp;
import com.model.Member;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
	 	@FXML
	    private TextField member_idField;
	    @FXML
	    private TextField passwordField;
	    @FXML
	    private TextField family_idField;
	    @FXML
	    private TextField nicknameField;
	 
	  	private Stage dialogStage;
	    private Member member;
	    private boolean okClicked = false;
	    
	    // ���� ���ø����̼� ����
	    private MainApp mainApp;

	    //������.initialize() �޼��� ������ ȣ��ȴ�.
	    public SignUpController() {}

	    //��Ʈ�ѷ� Ŭ������ �ʱ�ȭ�Ѵ�.�� �޼���� fxml ������ �ε�� �� �ڵ����� ȣ��ȴ�.
	    @FXML
	    private void initialize() {}

	    //���̾�α��� ���������� �����Ѵ�.
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	    
	   //ȸ������ â
	    public void setMember(Member member) {
	        this.member = member;
	        member_idField.setText(member.getMember_id());
	        passwordField.setText(member.getPassword());
	        family_idField.setText(member.getFamily_id());
	        nicknameField.setText(member.getNickname());  
	    }
	    
	    public boolean isOkClicked() {
	        return okClicked;
	    }
	    
	    @FXML
	    private void handleOk() {
	        if (isInputValid()) {
	        	member.setMember_id(member_idField.getText());
	        	member.setPassword(passwordField.getText());
	        	member.setFamily_id(family_idField.getText());
	        	member.setNickname(nicknameField.getText());
	        	int res = new MemberBiz().getInsert(member);
	        	if (res >0 ) {
					System.out.println("�Է� ����!");
				}
	        	okClicked = true;
	            dialogStage.close();
	        }
	    }

	    /**
	     * ����ڰ� cancel�� Ŭ���ϸ� ȣ��ȴ�.
	     */
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	        }

	    /**
	     * �ؽ�Ʈ �ʵ�� ����� �Է��� �˻��Ѵ�.
	     *
	     * @return true if the input is valid
	     */
	    private boolean isInputValid() {
	        String errorMessage = "";

	        if (member_idField.getText() == null || member_idField.getText().length() == 0) {
	            errorMessage += "No valid id!\n";
	        }
	        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
	            errorMessage += "No valid last password!\n";
	        }
	        if (family_idField.getText() == null || family_idField.getText().length() == 0) {
	            errorMessage += "No valid family id!\n";
	        }

	        if (nicknameField.getText() == null || nicknameField.getText().length() == 0) {
	            errorMessage += "No valid nickname!\n";
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
}
