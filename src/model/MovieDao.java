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


    // 추천 영화 관련 추가 내용입니다

    // 추천된 영화를 가져오는 함수
    public ArrayList<MovieDto> RecommendedMovies() {
        ArrayList<MovieDto> recommendedMovies = new ArrayList<>();

        try {
            // 추천된 영화들을 추천 횟수 내림차순으로 가져오는 SQL 쿼리
            String sql = """
                SELECT m.mv_id, m.mv_name, m.mv_director, m.mv_genre, m.mv_class,
                       m.mv_time, m.mv_detal, m.mv_date, m.mv_actor, m.mv_startdate,
                       COUNT(r.rv_suggestion) AS suggestion_count
                FROM movie m
                LEFT JOIN review r ON m.mv_id = r.rv_id
                WHERE r.rv_suggestion = TRUE
                GROUP BY m.mv_id
                ORDER BY suggestion_count DESC;
            """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // 결과를 리스트로 변환
            while (rs.next()) {
                MovieDto movie = new MovieDto(
                        rs.getInt("mv_id"),
                        rs.getString("mv_name"),
                        rs.getString("mv_director"),
                        rs.getString("mv_genre"),
                        rs.getInt("mv_class"),
                        rs.getString("mv_time"),
                        rs.getString("mv_detal"),
                        rs.getString("mv_date"),
                        rs.getString("mv_actor"),
                        rs.getString("mv_startdate")
                );
                recommendedMovies.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[추천된 영화 가져오기 오류]");
        }

        return recommendedMovies;
    }

    public ArrayList<MovieDto> getRecommendedMovies(String genre, String director, String actor, String movieClass) {
        ArrayList<MovieDto> recommendedMovies = new ArrayList<>();
        try {
            String sql = "SELECT * FROM movie WHERE mv_suggestion = true ORDER BY mv_id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                recommendedMovies.add(new MovieDto(
                        rs.getInt("mv_id"),
                        rs.getString("mv_name"),
                        rs.getString("mv_director"),
                        rs.getString("mv_genre"),
                        rs.getInt("mv_class"),
                        rs.getString("mv_time"),
                        rs.getString("mv_detal"),
                        rs.getString("mv_date"),
                        rs.getString("mv_actor"),
                        rs.getString("mv_startdate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recommendedMovies;
    }


    // 특정 영화를 추천 상태로 변경하는 함수
    public boolean markMovieAsRecommended(int movieId) {
        try {
            // 영화의 추천 상태를 true로 변경
            String sql = "UPDATE movie SET mv_suggestion = TRUE WHERE mv_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, movieId);  // 영화 ID를 설정
            return ps.executeUpdate() > 0; // 업데이트 성공 여부 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
