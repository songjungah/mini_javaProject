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

}
