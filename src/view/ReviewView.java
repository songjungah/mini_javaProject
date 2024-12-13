package view;

import controller.MemberController;
import controller.MovieController;
import controller.ReviewController;
import model.MemberDao;
import model.MemberDto;
import model.ReviewDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ReviewView {
    private static ReviewView reviewView = new ReviewView();
    private ReviewView(){}
    public static ReviewView getInstance(){return reviewView;}
    //싱글톤 작업//

    Scanner scan = new Scanner(System.in);

    void ReveiwWrite(){

        System.out.println("======================================");
        /*영화번호*/
        System.out.println("영화 번호를 입력해주세요 : ");
        String mvid = scan.next();
        /*리뷰 내용(varchar)*/
        scan.nextLine();
        System.out.print("리뷰 내용을 입력해주세요 : ");
        String content = scan.nextLine();
        /*별점(int)*/
        System.out.print("별점을 입력해주세요(1~5점) : ");
        int star = scan.nextInt();
        /*추천 - 비추천(bo1olean)*/
        System.out.println("추천 비추천을 선택해주세요(true or false) : ");
        boolean rv_Suggestion = scan.nextBoolean();

        String member = MemberController.getLoginId();
        boolean result = ReviewController.getInstance().reviewWrite(mvid,content,star,member,rv_Suggestion);
        //작성한 게시물을 controller에 전달.
    }

    void ReveiwPrint(){
        ArrayList<ReviewDto> result = ReviewController.getInstance().reviewPrint();

        for(int index = 0; index<=result.size()-1;index++){
            System.out.println("=================+++==============================");
            System.out.print("등록일 : " + result.get(index).getRv_Date() + " ");
            System.out.print("리뷰번호 : " + result.get(index).getRv_Id() + " " );
            System.out.println("영화번호 : " + result.get(index).getRv_Name()  );

            System.out.println("리뷰 내용 : " + result.get(index).getRv_Content()  );

            System.out.print("회원 번호 : " + result.get(index).getRv_Member() + " " );
            System.out.print("별점 : " + result.get(index).getRv_Star() + "점 " );
            System.out.println("추천 : " + result.get(index).getRv_Suggestion()   );
            System.out.println("========================+++=======================");
        }
    }

//    void ReveiwUpdate(){/*리뷰수정*/}
//
//    void ReveiwDelete(){/*리뷰 삭제*/}


}
