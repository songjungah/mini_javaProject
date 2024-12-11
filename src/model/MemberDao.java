package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class MemberDao extends Dao {
    // 싱글톤 패턴
    private static MemberDao memberDao = new MemberDao(); // 단일 인스턴스 생성
    private MemberDao() {} // private 생성자
    public static MemberDao getInstance() {
        return memberDao; // 외부접근 가능 메서드
    }

    // 회원 목록 출력 메서드
    public ArrayList<MemberDto> getAllMembers() {
        ArrayList<MemberDto> memberList = new ArrayList<>(); // 회원 정보 저장 리스트 생성
        try {
            // SQL 작성
            String sql = "SELECT * FROM member";
            PreparedStatement psmt = conn.prepareStatement(sql); //SQL 실행 준비
            ResultSet rs = psmt.executeQuery(); // SQL 실행 및 결과 저장

            // 결과 처리
            while (rs.next()) {
                // 각 컬럼의 값을 가져와 변수에 저장
                int uNumber = rs.getInt("uNumber");
                String uId = rs.getString("u_id");
                String uPw = rs.getString("u_pw");
                String uName = rs.getString("u_name");
                int uAge = rs.getInt("u_old");
                String uAdd = rs.getString("u_add");
                String uEmail = rs.getString("u_email");
                String uPhone = rs.getString("u_phone");
                String uBirth = rs.getString("u_birth");

                // dto 객체 생성
                MemberDto memberDto = new MemberDto(uNumber, uId, uPw, uName, uAge, uAdd, uEmail, uPhone, uBirth);

                // 리스트에 dto 추가
                memberList.add(memberDto);
            }
        } catch (SQLException e) {
            System.out.println("[회원 조회 중 오류 발생]" + e.getMessage());
        }
        return memberList; // 회원 리스트 반환
    }

    // 특정 회원 조회 메서드
    public MemberDto getMemberById(String memberId) {
        MemberDto member = null;

        try {
            // SQL 작성
            String sql = "SELECT * FROM member WHERE u_id = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, memberId); // 조건 값 설정
            ResultSet rs = psmt.executeQuery();

            // 결과 처리
            if (rs.next()) {
                // 데이터 읽기
                int uNumber = rs.getInt("u_number");
                String uId = rs.getString("u_id");
                String uPw = rs.getString("u_pw");
                String uName = rs.getString("u_name");
                int uAge = rs.getInt("u_old");
                String uAdd = rs.getString("u_add");
                String uEmail = rs.getString("u_email");
                String uPhone = rs.getString("u_phone");
                String uBirth = rs.getString("u_birth");

                // dto 객체 생성
                member = new MemberDto(uNumber, uId, uPw, uName, uAge, uAdd, uEmail, uPhone, uBirth);
            }
        } catch (SQLException e) {
            System.out.println("[회원 조회 중 오류 발생]" + e.getMessage());
        }
        return member; // 조회된 회원 반환 (없을 경우 null값 반환)
    }

    // 회원 추가 메서드
    public boolean insertMember(MemberDto member) {
        try{
            // sql 작성
            String sql = "INSERT INTO member (u_id, u_pw, u_name, u_old, u_add, u_email, u_phone, u_birth) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            // 값 설정
            ps.setString(1, member.getuId());
            ps.setString(2, member.getuPw());
            ps.setString(3, member.getuName());
            ps.setInt(4, member.getuAge());
            ps.setString(5, member.getuAdd());
            ps.setString(6, member.getuEmail());
            ps.setString(7, member.getuPhone());
            ps.setString(8, member.getuBirth());

            // 실행
            int result = ps.executeUpdate();
            return result > 0; // 성공시 true 반환
        } catch (SQLException e) {
            System.out.println("[회원 추가 중 오류 발생]" + e.getMessage());
            return false;
        }
    }

    public boolean updateMember(MemberDto member) {
        try {
            // SQL 작성
            String sql = "UPDATE member SET u_pw = ?, u_name = ?, u_old = ?, u_add = ?, u_email = ?, u_phone = ?, u_birth = ? " +
                    "WHERE u_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            // 값 설정
            ps.setString(1, member.getuPw());
            ps.setString(2, member.getuName());
            ps.setInt(3, member.getuAge());
            ps.setString(4, member.getuAdd());
            ps.setString(5, member.getuEmail());
            ps.setString(6, member.getuPhone());
            ps.setString(7, member.getuBirth());
            ps.setString(8, member.getuId());

            // 실행
            int result = ps.executeUpdate();
            return result > 0; // 성공 시 true 반환
        } catch (SQLException e) {
            System.out.println("[회원 수정 중 오류 발생] " + e.getMessage());
            return false;
        }
    }

    // 회원 삭제 메서드
    public boolean deleteMember(String memberId) {
        try {
            // SQL 작성
            String sql = "DELETE FROM member WHERE u_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberId);

            // 실행
            int result = ps.executeUpdate();
            return result > 0; // 성공 시 true 반환
        } catch (SQLException e) {
            System.out.println("[회원 삭제 중 오류 발생] " + e.getMessage());
            return false;
        }
    }

    // 회원 로그인 메서드
    public boolean loginMember(String id, String pwd){

        try {
            String sql = "select count(*) from member where u_id= ? and u_pw= ? ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);

            ResultSet rs = ps.executeQuery();

            // 결과 처리
            if (rs.next()) { // 결과를 읽을 수 있다면 ==  sql이 출력한 값이 있으면
                // 데이터 읽기
                int count = rs.getInt(1); //getInt(1) => 1열의 값 읽어 오기
                return  count == 1; //count(가져온값)이 1이면  true 리턴
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return false;
    }


}
