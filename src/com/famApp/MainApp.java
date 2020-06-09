package com.famApp;

import java.io.IOException;

import com.famApp.view.MainLoginController;
import com.famApp.view.SignUpController;
import com.model.Member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane MainLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FamilyScheduler");
        initRootLayout();

    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view\\MainLoginView.fxml"));
            MainLayout = (AnchorPane) loader.load();

            // 상위 레이아웃을 포함하는 scene을 보여준다.
            Scene scene = new Scene(MainLayout);
            primaryStage.setScene(scene);

            // 컨트롤러한테 MainApp 접근 권한을 준다.
            MainLoginController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   

    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean showOverview(Member member) {
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Overview.fxml"));
            AnchorPane overView = (AnchorPane) loader.load();

            primaryStage.setTitle("To-do list");
            Scene scene = new Scene(overView);
            primaryStage.setScene(scene);
            
         // member를 컨트롤러에 설정한다.
            MainLoginController controller = loader.getController();
            controller.setDialogStage(primaryStage);
            controller.setMember(member);

            // 다이얼로그를 보여주고 사용자가 닫을 때까지 기다린다.
            primaryStage.show();
            return controller.isOkClicked();
    	}catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 회원가입 다이얼로그를 연다.
     * 만일 사용자가 OK를 클릭하면 주어진 member에 내용을 저장한 후 true를 반환한다.
     * @return 
     */
    public boolean showSignUpDialog(Member member) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SignUpView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // 다이얼로그 스테이지를 만든다.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Sign up");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
         // member를 컨트롤러에 설정한다.
            SignUpController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMember(member);

            // 다이얼로그를 보여주고 사용자가 닫을 때까지 기다린다.
            dialogStage.showAndWait();
            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		
    }
    
   
    
}