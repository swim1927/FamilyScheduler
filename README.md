# FamilyScheduler
가족용 집안일 일정 공유 및 채팅 어플리케이션.

패키지 설명
application : Main.java
com
- com.biz : MemberBiz.java (dao의 계산결과를 콘트롤러에 리턴)
- com.dao :   
MemberDAO.java (getInsert(), getLogIn() 메소드. 새로 가입한 회원 디비에 추가 / 로그인 할 때 아이디 및 비번 확인)   
   MySql.java (sql문: member_insert, member_login)
- com.famApp : MainApp.java (메인어플리케이션)
- com.famApp.view: 콘트롤러와 뷰를 갖고 있는 폴더   
  ChatClient.java (채팅 클라이언트 접속 등)   
  Data.java (클라이언트 이름, 메시지, 상태 등 정보)   
  MainLoginController.java (메인화면에서 로그인 기능)   
  SignUpController.java (회원가입 기능)   
  MainLoginView.fxml (메인화면 로그인 뷰)   
  Overview.fxml (임시 todo-list 뷰 - 아무것도 없음)   
  SignUpView.fxml (회원가입 뷰)   
- com.model : Member.java (멤버(회원) 객체)
- com.server : ChatServer.java
               ChatServerThread.java
- com.util : DateUtil.java
             LocalDateAdapter.java
- common : JDBCTemplate.java (드라이버 참조해서 자바와 디비 연결)
