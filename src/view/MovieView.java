package view;

import controller.MemberController;
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
            System.out.println("------------------------------------------------");
            System.out.println("영화번호 : " + result.get(index).getMv_Id() + " ");
            System.out.println("영화제목 : " + result.get(index).getMv_Name()+ " ");
            System.out.println("감독 : " + result.get(index).getMv_Director());
            System.out.println("장르 : " + result.get(index).getMv_Genre()+ " ");
            System.out.println("등급 : " + result.get(index).getMv_Class()+ " ");
            System.out.println("러닝타임 : " + result.get(index).getMv_Time());
            System.out.println("영화설명 : " + result.get(index).getMv_Detal());
            System.out.println("개봉날짜 : " + result.get(index).getMv_Date());
            System.out.println("출연진 : " + result.get(index).getMv_Actor());
            System.out.println("등록일 : " + result.get(index).getMv_Startdate());
            System.out.println("------------------------------------------------");

        }   // for e

    }


    // 추천 영화 관련 추가 내용입니다

    // 추천된 영화 출력
    public void showRecommendedMovies() {
        ArrayList<MovieDto> recommendedMovies = MovieController.getInstance().getRecommendedMovies();

        if (recommendedMovies.isEmpty()) {
            System.out.println("추천된 영화가 없습니다.");
        } else {
            System.out.println();
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

    // 영화 장르 선택
    public void genreMovie(){
    //장르 선택해서 membercontroller에 전달
        System.out.println();
        System.out.println("1.드라마 2.스릴러 3.애니메이션 4.판타지 5.액션 6.공포");
        System.out.print("장르를 선택하세요 : ");
        int select = scan.nextInt();
        String genre = null;

        if( select == 1){
            genre = "드라마";
            MovieController.getInstance().genreMovie(genre); //선택된 장르값 전달
        }
        else if(select ==2){
            genre = "스릴러";
            MovieController.getInstance().genreMovie(genre); //선택된 장르값 전달
        }
        else if(select ==3){
            genre = "애니메이션";
            MovieController.getInstance().genreMovie(genre); //선택된 장르값 전달
        }
        else if(select ==4){
            genre = "판타지";
            MovieController.getInstance().genreMovie(genre); //선택된 장르값 전달
        }
        else if(select ==5){
            genre = "액션";
            MovieController.getInstance().genreMovie(genre); //선택된 장르값 전달
        }
        else if(select ==6){
            genre = "공포";
            MovieController.getInstance().genreMovie(genre); //선택된 장르값 전달
        }

        ArrayList<MovieDto> result = MovieController.getInstance().genreMovie(genre);

        for (int index = 0; index <= result.size()-1; index++) {    // for s
            System.out.println("------------------------------------------------");
            System.out.println("영화번호 : " + result.get(index).getMv_Id() + " ");
            System.out.println("영화제목 : " + result.get(index).getMv_Name()+ " ");
            System.out.println("감독 : " + result.get(index).getMv_Director());
            System.out.println("장르 : " + result.get(index).getMv_Genre()+ " ");
            System.out.println("등급 : " + result.get(index).getMv_Class()+ " ");
            System.out.println("러닝타임 : " + result.get(index).getMv_Time());
            System.out.println("영화설명 : " + result.get(index).getMv_Detal());
            System.out.println("개봉날짜 : " + result.get(index).getMv_Date());
            System.out.println("출연진 : " + result.get(index).getMv_Actor());
            System.out.println("등록일 : " + result.get(index).getMv_Startdate());
            System.out.println("------------------------------------------------");

        }   // for e
    }
    // 영화 이름 선택
//    public void selectMovie(){
//        //장르 선택해서 moviecontroller에 전달
//
//        ArrayList<MovieDto> result = MovieController.getInstance().moviePrint();
//
//        // 출력
//        for (int index = 0; index <= result.size()-1; index++) {    // for s
//
//            System.out.println("영화번호 : " + result.get(index).getMv_Id());
//            System.out.println("영화제목 : " + result.get(index).getMv_Name());
//            System.out.println("감독 : " + result.get(index).getMv_Director());
//            System.out.println("장르 : " + result.get(index).getMv_Genre());
//            System.out.println("등급 : " + result.get(index).getMv_Class());
//            System.out.println("러닝타임 : " + result.get(index).getMv_Time());
//            System.out.println("영화설명 : " + result.get(index).getMv_Detal());
//            System.out.println("개봉날짜 : " + result.get(index).getMv_Date());
//            System.out.println("출연진 : " + result.get(index).getMv_Actor());
//            System.out.println("등록일 : " + result.get(index).getMv_Startdate());
//            System.out.println("------------------------------------------------");
//
//        }   // for e
//
//    }

}
