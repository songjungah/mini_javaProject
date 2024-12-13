package controller;

import model.ReviewDao;
import model.ReviewDto;

import java.util.ArrayList;

public class ReviewController {
    private static ReviewController reviewController = new ReviewController();
    private ReviewController(){}
    public static ReviewController getInstance(){return reviewController;}
    //싱글톤 작업

    public boolean reviewWrite(String mvid, String content,int star,String member,boolean rv_Suggestion){
        ReviewDto reviewDto = new ReviewDto(mvid,content,star,member,rv_Suggestion);
        return ReviewDao.getInstance().reviewWrite(reviewDto);}

    public ArrayList<ReviewDto> reviewPrint(){
        ArrayList<ReviewDto> result = ReviewDao.getInstance().reviewPrint();
        return result;}

}//end class
