package model;

import java.util.ArrayList;

public class ReviewDao extends Dao{
    private static ReviewDao reviewDao = new ReviewDao();
    private ReviewDao(){}
    public static ReviewDao getInstance(){return reviewDao;}
    //싱글톤 작업//

    public ArrayList<ReviewDto> reviewPrint(){
        String sql = "";
        ArrayList<ReviewDto> list = new ArrayList<>();
        return list;
    }

}
