package controller;

import model.MemberDao;
import model.MemberDto;
import view.ReviewView;

public class MemberController {
    private static MemberController memberController = new MemberController();
    private MemberController(){}
    public static MemberController getInstance(){return memberController;}
    //싱글톤 작업

    static boolean login; //로그인 상태 나타내는 변수
    public static boolean getLogin() {return login;}
    public static void setLogin(boolean login) {MemberController.login = login;}
    //로그인 상태를 다른 view에서 가져오기 위한 getter,setter

    static String loginId; //로그인된 아이디
    public static String getLoginId(){return loginId;}
    public static void setLoginId(String loginId){MemberController.loginId=loginId;}
    //로그인된 아이디를 다른 view에서 가져오기 위한 getter,setter

    static String genre; //선택된 장르
    public static String getGenre(){return genre;}
    public static void setGenre(String genre){MemberController.genre=genre;}
    //선택된 장르를 다른 view에서 가져오기 위한 getter,setter


    // 멤버컨트롤러!

    //김이삭 작업
    public boolean memberLogin(String id,String pwd){
        boolean result = MemberDao.getInstance().loginMember(id,pwd);

        return result;
    }

    public boolean memberSign(MemberDto memberDto){
        boolean result = MemberDao.getInstance().insertMember(memberDto);
        return result;
    }
    //김이삭 작업

}//end class
