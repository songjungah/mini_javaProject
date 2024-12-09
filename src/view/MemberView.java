package view;

import controller.MemberController;

import java.util.Scanner;

public class MemberView {
    private static MemberView memberView= new MemberView();
    private MemberView(){}
    public static MemberView getInstance(){return memberView;}
    //싱글톤 작업

    Scanner scan = new Scanner(System.in); //스캔 사용

    public static boolean login; // 로그인 상태














    //김이삭 작업
    //회원가입
    void membersign(){

    }

    //로그인
    void memberdLogin(){
        //loing = 로그인 상태를 이용한 제한
        if(!login){ // 로그인이 되어 있지 않으면
            System.out.println("아이디를 입력 해주세요");
            String id = scan.next(); //아이디 입력 받기
            System.out.println("비밀번호를 입력 해주세요");
            int pwd = scan.nextInt(); //비밀번호 입력 받기

            //1. 입력 받은 정보를 컨트롤로 이동
            //2. 로그인 결과를 result에 저장
            boolean result = MemberController.getInstance().memberLogin(id,pwd);

            if(result){
                System.out.println("로그인 성공");
                login = true; // 로그인상태를 참으로
            }
            else{
                System.out.println("아이디/비밀번호가 다릅니다.");
            }

        }
        else if(login){ // 로그인이 되어있으면
            System.out.println("이미 로그인 되어 있습니다");
        }
    }

    //로그아웃
    void memberLogout(){
        if(login){
            System.out.println("로그아웃 성공");
            login=false;
        }
        else if(!login){
            System.out.println("이미 로그아웃 되어 있습니다");
        }
    }
    //김이삭 작업

}//end class


