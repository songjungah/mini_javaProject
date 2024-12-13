package model;

public class ReviewDto {
    private int rv_Id;              //         int - 리뷰번호
    private String rv_Name;         // varchar(50) - 영화아이디
    private String rv_Date;         //        date - 등록일
    private int rv_Star;            //         int - 별점
    private String rv_Content;      //varchar(200) - 리뷰내용
    private String rv_Member;          //         String - 회원번호
    private boolean rv_Suggestion;  //     boolean - 추천/비추천
    ///수정항목 넣으려면 비밀번호를 넣어야겠는데_아니면 비밀번호 없이 수정하던지

    //기본생성자
    public ReviewDto(){}

    //생성자 매개변수(회원-쓰기)
    public ReviewDto(String rv_Name, String rv_Content, int rv_Star,String rv_Member,boolean rv_Suggestion) {
        this.rv_Name = rv_Name;
        this.rv_Content = rv_Content;
        this.rv_Star = rv_Star;
        this.rv_Member =rv_Member;
        this.rv_Suggestion = rv_Suggestion;
    }

    //생성자 매개변수(전부)
    public ReviewDto(int rv_Id, String rv_Name, String rv_Date, int rv_Star, String rv_Content, String rv_Member, boolean rv_Suggestion) {
        this.rv_Id = rv_Id;
        this.rv_Name = rv_Name;
        this.rv_Date = rv_Date;
        this.rv_Star = rv_Star;
        this.rv_Content = rv_Content;
        this.rv_Member = rv_Member;
        this.rv_Suggestion = rv_Suggestion;
    }

    //getter setter


    public int getRv_Id() {
        return rv_Id;
    }

    public void setRv_Id(int rv_Id) {
        this.rv_Id = rv_Id;
    }

    public String getRv_Name() {
        return rv_Name;
    }

    public void setRv_Name(String rv_Mvid) {
        this.rv_Name = rv_Mvid;
    }

    public String getRv_Date() {
        return rv_Date;
    }

    public void setRv_Date(String rv_Date) {
        this.rv_Date = rv_Date;
    }

    public int getRv_Star() {
        return rv_Star;
    }

    public void setRv_Star(int rv_Star) {
        this.rv_Star = rv_Star;
    }

    public String getRv_Content() {
        return rv_Content;
    }

    public void setRv_Content(String rv_Content) {
        this.rv_Content = rv_Content;
    }

    public String getRv_Member() {
        return rv_Member;
    }

    public void setRv_Member(String rv_Member) {
        this.rv_Member = rv_Member;
    }

    public boolean getRv_Suggestion() {
        return rv_Suggestion;
    }

    public void setRv_Suggestion(boolean rv_Suggestion) {
        this.rv_Suggestion = rv_Suggestion;
    }
}//class end


