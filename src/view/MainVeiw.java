package view;

import java.util.Scanner;

public class MainVeiw {
    private static MainVeiw mainVeiw = new MainVeiw();
    private MainVeiw(){};
    public static MainVeiw getInstance(){return mainVeiw;}
    //싱글톤 작업//

    Scanner scan = new Scanner(System.in); //스캔 객체 ///scan

    public void mainpage() { // 맨처음 나오는 화면

        while (true) {
            System.out.print("1.현재 상영작 보기 2.리뷰보기 3.영화추천 4.로그인 5.회원가입 6.로그아웃 : ");
            int choose = scan.nextInt();
            if(choose == 1){MovieView.getInstance().moviePrint();}
            else if(choose == 2){ReviewView.getInstance().ReveiwPrint();}
            else if(choose == 3){/*영화 추천*/}
            else if(choose == 4){MemberView.getInstance().memberdLogin();}
            else if(choose == 5){/*회원가입*/}
            else if(choose == 6){MemberView.getInstance().memberLogout();}


        }//end while

    }// end mainpage

}// end class
