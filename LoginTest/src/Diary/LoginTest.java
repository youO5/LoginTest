package Diary;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class LoginTest extends FrameManager {

   JLabel lbTitle,lbld,lbPw;
   JTextField txtld;
   JPasswordField txtPw;
   JButton btOk;
   JButton btExit;
   JButton btJoin;
   Font f, ff, fff , ffff;
   LoginTest(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container contentPane = getContentPane();
      setTitle("Login");
      setSize(300,300);
      setLayout(null);

      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      int screenX=(int)(screen.getWidth()/2 - this.getWidth()/2);
      int screenY=(int)(screen.getHeight()/2 - this.getHeight()/2);
      setLocation(screenX,screenY);

      lbTitle=new JLabel();
      lbld=new JLabel();
      lbPw=new JLabel();
      txtld=new JTextField();
      txtPw=new JPasswordField();
      btOk=new JButton();
      btExit=new JButton();
      btJoin=new JButton();

      f=new Font("THE딸기마카롱",Font.BOLD,40);
      ff=new Font("THE딸기마카롱",Font.PLAIN,25);
      fff=new Font("THE딸기마카롱",Font.PLAIN,20);
      ffff=new Font("THE딸기마카롱",Font.PLAIN,15);

      lbTitle.setForeground(Color.BLACK);
      
      createJLabel(contentPane, lbTitle, "별별일상",170,50,65,20,f);
      createJLabel(contentPane, lbld,"ID",80,30,65,90,ff);
      createJLabel(contentPane, lbPw,"PW",80,30,45,140,ff);
      createJPasswordField(contentPane, txtld, "",120,30,100,90,ff);
      createJPasswordField(contentPane, txtPw, "",120,30,100,140,ff);
      createJButton(contentPane,btOk,"Login",80,30,10,200,ffff);
      createJButton(contentPane,btJoin,"Join",80,30,100,200,ffff);
      createJButton(contentPane,btExit,"Exit",70,30,190,200,ffff);

      txtld.addActionListener(new LoginActionListener());
      txtPw.addActionListener(new LoginActionListener());
      btOk.addActionListener(new LoginActionListener());

      btJoin.addActionListener(new ActionListener(){
         
    	 public void actionPerformed(ActionEvent e){
         }
      });

       btExit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            dispose();
         }
      });
         setVisible(true);
       }
        class LoginActionListener implements ActionListener{
           public void actionPerformed(ActionEvent e){
        	   System.out.println("=====login======");
        	   LoginVo vo;
        	   // id값
        	   String ID = txtld.getText();
        	   String PW = "";
        	   //pw
        	   char[] secret_pw = txtPw.getPassword(); 

        	 //secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha 에 한 글자씩 저장
        	      for(char cha : secret_pw){         
        	          Character.toString(cha);      
        	        //pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
        	          PW += (PW.equals("")) ? ""+cha+"" : ""+cha+"";   
        	      }
        	      
        	      if(ID.isEmpty()) {
        	    	  JOptionPane.showMessageDialog(null, "ID를 입력하세요!", "Message", JOptionPane.ERROR_MESSAGE);
        	    	  return;
        	      }
        	      if(PW.isEmpty()) {
        	    	  JOptionPane.showMessageDialog(null, "Password를 입력하세요!", "Message", JOptionPane.ERROR_MESSAGE);
        	    	  return;
        	      }
        	      LoginDAO dao = new LoginDAO();
        	      ArrayList<LoginVo> list = dao.list(ID);
        	      
        	      if (list.isEmpty() ) {
        	    	  JOptionPane.showMessageDialog(null, "ID가 없습니다.", "Message", JOptionPane.ERROR_MESSAGE);
        	    	  return;
        	      }else{      	    
        	    	  //PW 가 list.get(0).getPwd() 와 같지 않으면.
        	    	  //PW : textfiled에서 입력받은 값 . list.PWD는 id기준으로 db조회해올때 같이 가져온 pw값 
        	    	  if(!PW.equals(list.get(0).getPwd())) {
        	    		  JOptionPane.showMessageDialog(null, "Password가 틀렸습니다!", "Message", JOptionPane.ERROR_MESSAGE);
        	    		  return;
        	    	  }else {
        	    		  JOptionPane.showMessageDialog(null, "로그인 성공", "Message", JOptionPane.ERROR_MESSAGE);
            	      }
        	      }
        	        //dispose();
           }

           }
               public static void main(String[] args) {
        	   new LoginFram(); 
           }
}