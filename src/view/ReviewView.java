package view;

import controller.ReviewController;
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
        /*리뷰번호*/ //sql에서 자동으로 넣어줌
        //System.out.println("");
        /*영화번호*////어떻게 영화번호 처리할지 정해야함
        //System.out.println("");
        /*등록일*/ //sql에서 자동으로 넣어주는게 어떤지 now()
        //System.out.println("");

        /*리뷰 내용(varchar)*/
        System.out.print("리뷰 내용을 입력해주세요 : ");
        scan.nextLine();
        String content = scan.nextLine();
        /*별점(int)*/
        System.out.print("별점을 입력해주세요(1~5점) : ");
        int star = scan.nextInt();
        /*추천 - 비추천(boolean)*/
        System.out.println("추천 비추천을 선택해주세요(true or false) : ");
        boolean good = scan.nextBoolean();

        boolean result = ReviewController.getInstance().reviewWrite(content,star,good);
        //작성한 게시물을 controller에 전달.
    }

    void ReveiwPrint(){
        ArrayList<ReviewDto> result = ReviewController.getInstance().reviewPrint();

        for(int index = 0; index<=result.size()-1;index++){
            System.out.print("리뷰번호" + result.get(index).getRv_Id()  );
            System.out.print("영화번호" + result.get(index).getRv_Mvid()  );
            System.out.print("등록일" + result.get(index).getRv_Date() );

            System.out.print("리뷰 내용" + result.get(index).getRv_Content()  );

            System.out.print("회원 번호" + result.get(index).getRv_Member()  );
            System.out.print("별점" + result.get(index).getRv_Star()  );
            System.out.print("추천" + result.get(index).getRv_Suggestion()   );
        }
    }

    void ReveiwUpdate(){/*리뷰수정*/}

    void ReveiwDelete(){/*리뷰 삭제*/}


}
