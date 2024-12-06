package model;

public class ReviewDto {
    private int rv_Id;              //         int - 아이디
    private String rv_Mvid;         // varchar(50) - 영화아이디
    private String rv_Date;         //        date - 등록일
    private int rv_Star;            //         int - 별점
    private String rv_Content;      //varchar(200) - 리뷰내용
    private int rv_Member;          //         int - 회원번호
    private boolean rv_Suggestion;  //     boolean - 추천/비추천
    ///수정항목 넣으려면 비밀번호를 넣어야겠는데_아니면 비밀번호 없이 수정하던지

    //기본생성자
    public ReviewDto(){}

    //생성자 매개변수(회원-쓰기)
    public ReviewDto(String rv_Content, int rv_Star, boolean rv_Suggestion) {
        this.rv_Content = rv_Content;
        this.rv_Star = rv_Star;
        this.rv_Suggestion = rv_Suggestion;
    }

    //생성자 매개변수(전부)
    public ReviewDto(int rv_Id, String rv_Mvid, String rv_Date, int rv_Star, String rv_Content, int rv_Member, boolean rv_Suggestion) {
        this.rv_Id = rv_Id;
        this.rv_Mvid = rv_Mvid;
        this.rv_Date = rv_Date;
        this.rv_Star = rv_Star;
        this.rv_Content = rv_Content;
        this.rv_Member = rv_Member;
        this.rv_Suggestion = rv_Suggestion;
    }




}//class end


