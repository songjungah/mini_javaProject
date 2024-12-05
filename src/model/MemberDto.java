package model;

public class MemberDto {
    // 데이터베이스 member 테이블과 매핑되는 객체 (데이터 저장 및 전달역할)
    private int uNumber; // 회원 번호
    private String uId; // 회원 아이디
    private String uPw; // 회원 비번
    private String uName; // 회원 이름
    private int uAge; // 회원 나이
    private String uAdd; // 회원 주소
    private String uEmail; // 회원 이메일
    private String uPhone; // 회원 전화번호
    private String uBirth; // 회원 생년월일

    // 기본 생성자(데이터 x 객체 초기화 시 사용)
    public MemberDto() {}

    // 매개변수 생성자(모든 필드 초기화 생성자_데이터베이스 조회 or 새 데이터 삽입 시 사용)
    public MemberDto(int uNumber, String uId, String uPw, String uName, int uAge, String uAdd, String uEmail, String uPhone, String uBirth){
        this.uNumber = uNumber;
        this.uId = uId;
        this.uPw = uPw;
        this.uName = uName;
        this.uAge = uAge;
        this.uAdd = uAdd;
        this.uEmail = uEmail;
        this.uPhone = uPhone;
        this.uBirth = uBirth;
    }

    // getter & setter 메서드 (데이터 읽고 쓰기 위한 접근자 메서드)

}
