package controller;

import model.MovieDao;
import model.MovieDto;

import java.util.ArrayList;

public class MovieController {

    // 싱글톤
    private static MovieController movieController = new MovieController();
    private MovieController() {}
    public static MovieController getInstance() {
        return movieController;
    }

    // 1. 영화 출력 제어 함수
    public ArrayList<MovieDto> moviePrint() {   // e start
        ArrayList<MovieDto> result = MovieDao.getInstance().moviePrint();

        return result;

    }   // e end



    // 추천 영화 관련 추가 내용입니다

    // 추천된 영화 가져오기
    public ArrayList<MovieDto> getRecommendedMovies() {
        return MovieDao.getInstance().RecommendedMovies();
    }

    // 특정 리뷰를 추천으로 표시
    public boolean recommendReview(int reviewId) {
        return MovieDao.getInstance().markMovieAsRecommended(reviewId);
    }

    // 추천 영화 가져오기
    public ArrayList<MovieDto> recommendMovies( String genre, String director, String actor, String movieClass) {
        return MovieDao.getInstance().getRecommendedMovies(genre, director, actor, movieClass);
    }

    // 장르에 맞는 영화 가져오기
    public ArrayList<MovieDto> genreMovie(String genre) {   // e start
        ArrayList<MovieDto> result = MovieDao.getInstance().genreMovie(genre);
        return result;
    }   // e end

}
