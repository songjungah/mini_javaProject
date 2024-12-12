package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDao extends Dao {
    private static ReviewDao reviewDao = new ReviewDao();
    private ReviewDao() {}
    public static ReviewDao getInstance() {return reviewDao;}
    //싱글톤 작업//

    public ArrayList<ReviewDto> reviewPrint() {
        ArrayList<ReviewDto> list = new ArrayList<>();

        try {
            String sql = "select * from review ;"; //테이터 입력 Sql 작성
            PreparedStatement ps = conn.prepareStatement(sql); //Sql 실행
            ResultSet rs = ps.executeQuery();//실행 결과를 ResultSet 타입으로 rs에 저장

            while (rs.next()) {
                //실행 결과를 각 필드별로 호출
                int rv_id = rs.getInt("rv_id");
                String rv_Name = rs.getString("rv_name");
                String rv_Date = rs.getString("rv_date");
                int rv_Star = rs.getInt("rv_star");
                String rv_Content = rs.getString("rv_content");
                String rv_Member = rs.getString("rv_member");
                boolean rv_Suggestion = rs.getBoolean("rv_suggestion");
                //레코드의 호출된 필드값들을 객체화 -> DAo 형태로 생성

                ReviewDto reviewDto = new ReviewDto(rv_id, rv_Name, rv_Date, rv_Star, rv_Content, rv_Member, rv_Suggestion);

                // 1개의 레코드를 DTO 객체로 변환된 DTO로 리스트에 저장

                list.add(reviewDto); //가져온 값을 리턴

            } // end while

        } catch (SQLException e) {e.printStackTrace();}// end catch
        return list;
    }//end Print

        public boolean reviewWrite(ReviewDto reviewDto) {
            //1. 리뷰 데이터 베이스 추가하는 SQL작성
            String sql = "insert into review(rv_date,rv_content,rv_star,rv_suggestion) values(now(),?,?,?);";
            try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reviewDto.getRv_Content());
            ps.setInt(2, reviewDto.getRv_Star());
            ps.setBoolean(3, reviewDto.getRv_Suggestion());

            ps.executeUpdate();
        }catch(SQLException e){e.printStackTrace();}
            return true;
        }


}