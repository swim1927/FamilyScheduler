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

            // ���� ���̾ƿ��� �����ϴ� scene�� �����ش�.
            Scene scene = new Scene(MainLayout);
            primaryStage.setScene(scene);

            // ��Ʈ�ѷ����� MainApp ���� ������ �ش�.
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
            
         // member�� ��Ʈ�ѷ��� �����Ѵ�.
            MainLoginController controller = loader.getController();
            controller.setDialogStage(primaryStage);
            controller.setMember(member);

            // ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
            primaryStage.show();
            return controller.isOkClicked();
    	}catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * ȸ������ ���̾�α׸� ����.
     * ���� ����ڰ� OK�� Ŭ���ϸ� �־��� member�� ������ ������ �� true�� ��ȯ�Ѵ�.
     * @return 
     */
    public boolean showSignUpDialog(Member member) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SignUpView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // ���̾�α� ���������� �����.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Sign up");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
         // member�� ��Ʈ�ѷ��� �����Ѵ�.
            SignUpController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMember(member);

            // ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
            dialogStage.showAndWait();
            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		
    }
    
   
    
}