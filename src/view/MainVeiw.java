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
            System.out.println("1.영화검색 2.영화추천 3.로그인 4.회원가입 : ");
            int choose = scan.nextInt();
            if(choose == 1){/*영화검색*/}
            else if(choose == 2){/*코메디 장르 선택*/}
            else if(choose == 3){/*로그인*/}
            else if(choose == 4){/*회원가입*/}



        }//end while

    }// end mainpage

}// end class
