package controller;

import model.MemberDao;
import view.ReviewView;

public class MemberController {
    private static MemberController memberController = new MemberController();
    private MemberController(){}
    public static MemberController getInstance(){return memberController;}
    //싱글톤 작업
    // 멤버컨트롤러!










    //김이삭 작업
    public boolean memberLogin(String id,int pwd){
//        boolean result = MemberDao.getInstance().memberLogin(id,pwd);
        return false;
    }
    //김이삭 작업

}//end class
