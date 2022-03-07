package Diary;

public class LoginVo {

    public static Object logdata;
	private String ID;
    private String PW;
    
    public LoginVo() {
       
    }
    
    public LoginVo(String ID, String PW) {
       this.ID = ID;
       this.PW = PW;
    }
    
    public String getId() {
       return ID;
    }
    
    public String getPwd() {
       return PW;
    }

	public void LoginVo(String iD2, String pW2) {
		// TODO Auto-generated method stub
		
	}
 }