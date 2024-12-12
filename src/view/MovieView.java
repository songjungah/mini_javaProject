package view;

import controller.MovieController;
import model.MovieDto;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieView {

    // 싱글톤
    private static MovieView movieView = new MovieView();
    private MovieView() {}
    public static MovieView getInstance() {
        return movieView;
    }

    // 입력 객체
    Scanner scan = new Scanner(System.in);

    // 1. 영화 출력 함수
    void moviePrint() {
        // 게시물 출력 함수 호출
        ArrayList<MovieDto> result = MovieController.getInstance().moviePrint();

        // 출력
        for (int index = 0; index <= result.size()-1; index++) {    // for s

            System.out.printf("영화번호 : " + result.get(index).getMv_Id());
            System.out.printf("영화제목 : " + result.get(index).getMv_Name());
            System.out.printf("감독 : " + result.get(index).getMv_Director());
            System.out.printf("장르 : " + result.get(index).getMv_Genre());
            System.out.printf("등급 : " + result.get(index).getMv_Class());
            System.out.printf("러닝타임 : " + result.get(index).getMv_Time());
            System.out.printf("영화설명 : " + result.get(index).getMv_Detal());
            System.out.printf("개봉날짜 : " + result.get(index).getMv_Date());
            System.out.printf("출연진 : " + result.get(index).getMv_Actor());
            System.out.printf("등록일 : " + result.get(index).getMv_Startdate());

        }   // for e

    }


    // 추천 영화 관련 추가 내용입니다

    // 추천된 영화 출력
    public void showRecommendedMovies() {
        ArrayList<MovieDto> recommendedMovies = MovieController.getInstance().getRecommendedMovies();

        if (recommendedMovies.isEmpty()) {
            System.out.println("추천된 영화가 없습니다.");
        } else {
            System.out.println("추천된 영화 목록:");
            for (MovieDto movie : recommendedMovies) {
                // getMvName()과 getMvDirector() 메소드 사용
                System.out.println(movie.getMv_Name() + " (" + movie.getMv_Director() + ")");
            }
        }
    }

    // 영화 추천 버튼을 누르면 추천 처리
    public void recommendMovie() {
        System.out.print("추천할 영화 ID를 입력하세요: ");
        int movieId = scan.nextInt();
        scan.nextLine(); // 버퍼 비우기

        boolean success = MovieController.getInstance().recommendReview(movieId);

        if (success) {
            System.out.println("영화가 성공적으로 추천되었습니다.");
        } else {
            System.out.println("영화 추천에 실패했습니다.");
        }
    }
}
