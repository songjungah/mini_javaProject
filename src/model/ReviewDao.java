package model;

public class ReviewDao extends Dao{
    private static ReviewDao reviewDao = new ReviewDao();
    private ReviewDao(){}
    public static ReviewDao getInstance(){return reviewDao;}
    //싱글톤 작업//

}
