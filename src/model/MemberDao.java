package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 회원 데이터 db와 연동시켜 crud 작업 수행
public class MemberDao {
    // db 연결 정보

    // db 연결 메서드
    private Connection conn; // Dao 클래스 Connection 공유

    // MemeberDao 생성자
    public MemberDao() {
        Dao dao = new Dao(); // dao 객체 생성
        this.conn = dao.conn; // Connection 객체 가져옴
    }

    // 회원 데이터 삽입
    public void insertMember(MemberDto member) {
        String sql = "INSERT INTO member (uNumber, uPw,uId, uPw, uName, uAge, uAdd, uEmail, uPhone, uBirth)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1,member.getuNumber());
        pstmt.setString(2,member.getuId());
        pstmt.setString(3, member.getuPw());
        pstmt.setString(4, member.getuName());
        pstmt.setInt(5, member.getuAge());
        pstmt.setString(6, member.getuAdd());
        pstmt.setString(7, member.getuEmail());
        pstmt.setString(8, member.getuPhone());
        pstmt.setString(9, member.getuBirth());

        pstmt.executeUpdate();
        System.out.println("회원 정보가 성공적으로 삽입되었습니다");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("회원 정보 삽입 오류 발생" + e.getMessage());
    }
    }

    // 회원 데이터 조회
    public  MemberDto getMember(String uId){
        String sql = "SELECT * FROM member WHERE uId = ?";
        MemberDto member = null;

        try(PreparedStatement pstmt = conn.prepareStatement())
    }



}
