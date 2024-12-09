package controller;

import model.ReviewDao;
import model.ReviewDto;

import java.util.ArrayList;

public class ReviewController {
    private static ReviewController reviewController = new ReviewController();
    private ReviewController(){}
    public static ReviewController getInstance(){return reviewController;}
    //싱글톤 작업

    public boolean reviewWrite(String content,int star,boolean good){
        ReviewDto reviewDto = new ReviewDto(content,star,good);
        return ReviewDao.getInstance().reviewPrint(reviewDto);}

    public ArrayList<ReviewDto> reviewPrint(){
        ArrayList<ReviewDto> result = ReviewDao.getInstance().reviewPrint();
        return result;}

}//end class
