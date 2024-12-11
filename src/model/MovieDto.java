package model;

public class MovieDto {

    // 영화필드
    private int mv_Id;              // 영화번호
    private String mv_Name;         // 영화제목
    private String mv_Director;     // 감독
    private String mv_Genre;        // 장르
    private String mv_Class;           // 등급
    private String mv_Time;         // 러닝타임
    private String mv_Detal;        // 영화설명
    private String mv_Date;         // 개봉날짜
    private String mv_Actor;        // 출연진
    private String mv_Startdate;    // 등록일

    public MovieDto(int mv_Id, String mv_Name, String mv_Director, String mv_Genre,
                    String mv_Class, String mv_Time, String mv_Detal, String mv_Date, String mv_Actor,
                    String mv_Startdate)
    {
        this.mv_Id = mv_Id;
        this.mv_Name = mv_Name;
        this.mv_Director = mv_Director;
        this.mv_Genre = mv_Genre;
        this.mv_Class = mv_Class;
        this.mv_Time = mv_Time;
        this.mv_Detal = mv_Detal;
        this.mv_Date = mv_Date;
        this.mv_Actor = mv_Actor;
        this.mv_Startdate = mv_Startdate;
    }

    public int getMv_Id() {
        return mv_Id;
    }

    public void setMv_Id(int mv_Id) {
        this.mv_Id = mv_Id;
    }

    public String getMv_Name() {
        return mv_Name;
    }

    public void setMv_Name(String mv_Name) {
        this.mv_Name = mv_Name;
    }

    public String getMv_Director() {
        return mv_Director;
    }

    public void setMv_Director(String mv_Director) {
        this.mv_Director = mv_Director;
    }

    public String getMv_Genre() {
        return mv_Genre;
    }

    public void setMv_Genre(String mv_Genre) {
        this.mv_Genre = mv_Genre;
    }

    public String getMv_Class() {
        return mv_Class;
    }

    public void setMv_Class(String mv_Class) {
        this.mv_Class = mv_Class;
    }

    public String getMv_Time() {
        return mv_Time;
    }

    public void setMv_Time(String mv_Time) {
        this.mv_Time = mv_Time;
    }

    public String getMv_Detal() {
        return mv_Detal;
    }

    public void setMv_Detal(String mv_Detal) {
        this.mv_Detal = mv_Detal;
    }

    public String getMv_Date() {
        return mv_Date;
    }

    public void setMv_Date(String mv_Date) {
        this.mv_Date = mv_Date;
    }

    public String getMv_Actor() {
        return mv_Actor;
    }

    public void setMv_Actor(String mv_Actor) {
        this.mv_Actor = mv_Actor;
    }

    public String getMv_Startdate() {
        return mv_Startdate;
    }

    public void setMv_Startdate(String mv_Startdate) {
        this.mv_Startdate = mv_Startdate;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "mv_Id=" + mv_Id +
                ", mv_Name='" + mv_Name + '\'' +
                ", mv_Director='" + mv_Director + '\'' +
                ", mv_Genre='" + mv_Genre + '\'' +
                ", mv_Class=" + mv_Class +
                ", mv_Time='" + mv_Time + '\'' +
                ", mv_Detal='" + mv_Detal + '\'' +
                ", mv_Date='" + mv_Date + '\'' +
                ", mv_Actor='" + mv_Actor + '\'' +
                ", mv_Startdate='" + mv_Startdate + '\'' +
                '}';
    }
}

