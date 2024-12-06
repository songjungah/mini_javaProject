package model;

import jdk.internal.icu.impl.CharacterIteratorWrapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDao extends Dao{

    // 싱글톤
    private static MovieDao movieDao = new MovieDao();
    private MovieDao() {}
    public static MovieDao getInstance() {
        return movieDao;
    }

    // 1. 영화 출력 접근 함수
    public ArrayList<MovieDto> moviePrint() {   // main s
        ArrayList<MovieDto> list = new ArrayList<>();   // 조회된 레코드를 저장할 리스트객체

        try {
            // SQL 작성
            String sql = "select * from movie";
            // SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // SQL 실행
            ResultSet rs = ps.executeQuery();
            // SQL 결과
            while (rs.next()) {

                // 레코드를 읽어서 각 필드별 호출
                int mv_Id = rs.getInt("mv_Id");
                String mv_Name = rs.getString("mv_Name");
                String mv_Director = rs.getString("mv_Director");
                String mv_Genre = rs.getString("mv_Genre");
                int mv_Class = rs.getInt("mv_Class");
                String mv_Time = rs.getString("mv_Time");
                String mv_Detal = rs.getString("mv_Detal");
                String mv_Date = rs.getString("mv_Date");
                String mv_Actor = rs.getString("mv_Actor");
                String mv_Startdate = rs.getString("mv_Startdate");

                // 레코드의 호출된 필드값들을 객체화 > DTO 생성
                MovieDto movieDto = new MovieDto(mv_Id, mv_Name, mv_Director, mv_Genre, mv_Class,
                                                mv_Time, mv_Detal, mv_Date, mv_Actor, mv_Startdate);
                
                // 1개의 레코드를 DTO 객체로 변환된 DTO로 리스트에 저장
                list.add(movieDto);

            }

        } catch (SQLException e) {
            e.getMessage();
            System.out.println("[게시물 출력시 예외 발생]");
        }

        // 구성한 리스트 객체를 반환
        return list;

    }       // main e


    }
