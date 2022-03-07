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

      f=new Font("THE���⸶ī��",Font.BOLD,40);
      ff=new Font("THE���⸶ī��",Font.PLAIN,25);
      fff=new Font("THE���⸶ī��",Font.PLAIN,20);
      ffff=new Font("THE���⸶ī��",Font.PLAIN,15);

      lbTitle.setForeground(Color.BLACK);
      
      createJLabel(contentPane, lbTitle, "�����ϻ�",170,50,65,20,f);
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
        	   // id��
        	   String ID = txtld.getText();
        	   String PW = "";
        	   //pw
        	   char[] secret_pw = txtPw.getPassword(); 

        	 //secret_pw �迭�� ����� ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha �� �� ���ھ� ����
        	      for(char cha : secret_pw){         
        	          Character.toString(cha);      
        	        //pw �� �����ϱ�, pw �� ���� ��������� ����, ���� ������ �̾ �����ϴ� ���׿�����
        	          PW += (PW.equals("")) ? ""+cha+"" : ""+cha+"";   
        	      }
        	      
        	      if(ID.isEmpty()) {
        	    	  JOptionPane.showMessageDialog(null, "ID�� �Է��ϼ���!", "Message", JOptionPane.ERROR_MESSAGE);
        	    	  return;
        	      }
        	      if(PW.isEmpty()) {
        	    	  JOptionPane.showMessageDialog(null, "Password�� �Է��ϼ���!", "Message", JOptionPane.ERROR_MESSAGE);
        	    	  return;
        	      }
        	      LoginDAO dao = new LoginDAO();
        	      ArrayList<LoginVo> list = dao.list(ID);
        	      
        	      if (list.isEmpty() ) {
        	    	  JOptionPane.showMessageDialog(null, "ID�� �����ϴ�.", "Message", JOptionPane.ERROR_MESSAGE);
        	    	  return;
        	      }else{      	    
        	    	  //PW �� list.get(0).getPwd() �� ���� ������.
        	    	  //PW : textfiled���� �Է¹��� �� . list.PWD�� id�������� db��ȸ�ؿö� ���� ������ pw�� 
        	    	  if(!PW.equals(list.get(0).getPwd())) {
        	    		  JOptionPane.showMessageDialog(null, "Password�� Ʋ�Ƚ��ϴ�!", "Message", JOptionPane.ERROR_MESSAGE);
        	    		  return;
        	    	  }else {
        	    		  JOptionPane.showMessageDialog(null, "�α��� ����", "Message", JOptionPane.ERROR_MESSAGE);
            	      }
        	      }
        	        //dispose();
           }

           }
               public static void main(String[] args) {
        	   new LoginFram(); 
           }
}