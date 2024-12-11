package view;

import controller.MemberController;

import java.util.Scanner;

public class MainVeiw {
    private static MainVeiw mainVeiw = new MainVeiw();
    private MainVeiw(){};
    public static MainVeiw getInstance(){return mainVeiw;}
    //싱글톤 작업//

    Scanner scan = new Scanner(System.in); //스캔 객체 ///scan

    public void mainpage() { // 맨처음 나오는 화면

        while (true) {
            if(!MemberController.getLogin()) {
                System.out.print("1.현재 상영작 보기 2.영화추천 3.로그인 4.회원가입 : ");
                int choose = scan.nextInt();
                if (choose == 1) {/*현재 상영작 보기*/MovieView.getInstance().moviePrint();}
                  else if (choose == 2) {/*영화 추천*/MovieView.getInstance().moviePrint();}
                  else if (choose == 3) {/*로그인*/MemberView.getInstance().memberdLogin();}
                  else if (choose == 4) {/*회원가입*/MemberView.getInstance().memberSign();}
            }
            else{
                System.out.println("[ 로그인 상태 ]");
                System.out.print("1.현재 상영작 보기 2.리뷰쓰기 3.영화추천 4.로그아웃 : ");
                int choose = scan.nextInt();
                    if (choose == 1) {/*현재 상영작 보기*/MovieView.getInstance().moviePrint();}
                    else if (choose == 2) {/*리뷰쓰기*/ReviewView.getInstance().ReveiwPrint();}
                    else if (choose == 3) {/*영화 추천*/MovieView.getInstance().moviePrint();}
                    else if (choose == 4) {/*로그아웃*/MemberView.getInstance().memberLogout();}
            }




//             원본
//            System.out.print("1.현재 상영작 보기 2.리뷰보기 3.영화추천 4.로그인 5.회원가입 6.로그아웃 : ");
//            int choose = scan.nextInt();
//            if (choose == 1) {
//                MovieView.getInstance().moviePrint();
//            } else if (choose == 2) {
//                ReviewView.getInstance().ReveiwPrint();
//            } else if (choose == 3) {/*영화 추천*/} else if (choose == 4) {
//                MemberView.getInstance().memberdLogin();
//            } else if (choose == 5) {/*회원가입*/} else if (choose == 6) {
//                MemberView.getInstance().memberLogout();
//            }


        }//end while

    }// end mainpage

}// end class
