package view;

import controller.MemberController;
import model.MemberDto;

import java.lang.reflect.Member;
import java.util.Scanner;

public class MemberView {
    private static MemberView memberView= new MemberView();
    private MemberView(){}
    public static MemberView getInstance(){return memberView;}
    //싱글톤 작업

    Scanner scan = new Scanner(System.in); //스캔 사용

    //김이삭 작업
    //회원가입
    void memberSign(){
        System.out.print("아이디를 입력 해주세요 : ");
        String uId = scan.next(); //아이디 입력 받기
        System.out.print("비밀번호를 입력 해주세요 : ");
        String uPw = scan.next(); //비밀번호 입력 받기
        System.out.print("이름을 입력 해주세요 : ");
        String uName = scan.next(); //이름 입력 받기
        System.out.print("나이를 입력 해주세요 : ");
        int uAge = scan.nextInt(); //나이 입력 받기
        System.out.print("주소를 입력 해주세요 : ");
        String uAdd = scan.next(); //주소 입력 받기
        System.out.print("이메일을 입력 해주세요 : ");
        String uEmail = scan.next(); //이메일 입력 받기
        System.out.print("전화번호를 입력 해주세요 : ");
        String uPhone = scan.next(); //전화번호 입력 받기
        System.out.print("생년월일을 입력 해주세요(예시20010101 : )" );
        String uBirth = scan.next(); //이메일 입력 받기

        MemberDto memberDto = new MemberDto(uId,uPw,uName,uAge,uAdd,uEmail,uPhone,uBirth);

        boolean result = MemberController.getInstance().memberSign(memberDto);

        if(result){
            System.out.println("회원가입에 성공했습니다");
            System.out.println("다시 로그인 해주세요");
        }
        else{
            System.out.println("회원가입에 실패했습니다");
            System.out.println("잠시후 다시 시도해주세요");
        }

    }

    //로그인
    void memberdLogin(){
        //loing = 로그인 상태를 이용한 제한
        if(!MemberController.getLogin()){ // 로그인이 되어 있지 않으면
            System.out.print("아이디를 입력 해주세요 : ");
            String id = scan.next(); //아이디 입력 받기
            System.out.print("비밀번호를 입력 해주세요 : ");
            String pwd = scan.next(); //비밀번호 입력 받기

            //1. 입력 받은 정보를 컨트롤로 이동
            //2. 로그인 결과를 result에 저장
            MemberController.setLoginId(id);
            boolean result = MemberController.getInstance().memberLogin(id,pwd);

            if(result){
                System.out.println("[ 로그인 성공 ]");

                MemberController.setLogin(true); // 로그인상태를 참으로

            }
            else{
                System.out.println("아이디/비밀번호가 다릅니다.");
            }

        }
        else if(MemberController.getLogin()){ // 로그인이 되어있으면
            System.out.println("이미 로그인 되어 있습니다");
        }
    }

    //로그아웃
    void memberLogout(){
        if(MemberController.getLogin()){
            System.out.println("[ 로그아웃 성공 ]");
            MemberController.setLogin(false);
        }
        else if(!MemberController.getLogin()){
            System.out.println("이미 로그아웃 되어 있습니다");
        }
    }
    //김이삭 작업

}//end class


