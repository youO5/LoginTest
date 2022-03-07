package Diary;

import java.awt.*;
import javax.swing.*;
//예시
//05가 바꾼거
public class FrameManager extends JFrame {
    void createJLabel(Container c,JLabel obj,String name, int sx, int sy, int dx,int dy,Font f)
   {
      obj.setText(name);
      obj.setSize(sx,sy);
      obj.setLocation(dx, dy);
      obj.setFont(f);
      c.add(obj);
   }
   void createJPasswordField(Container c,JTextField obj,String name, int sx, int sy, int dx, int dy, Font f){
      obj.setText(name);
      obj.setSize(sx,sy);
      obj.setLocation(dx,dy);
      obj.setFont(f);
      c.add(obj);
   }
   void createJButton(Container c,JButton btOk,String name, int sx, int sy, int dx, int dy, Font f )
   {
      btOk.setText(name);
      btOk.setSize(sx,sy);
      btOk.setLocation(dx,dy);
      btOk.setFont(f);
      c.add(btOk);
   }
   void createJPanel(Container c,JButton obj,String name, int sx, int sy, int dx, int dy, Font f)
   {
      obj.setText(name);
      obj.setSize(sx,sy);
      obj.setLocation(dx,dy);
      obj.setFont(f);
      c.add(obj);
   }
   void createJPanel(Container c,JPanel obj,int sx, int sy, int dx, int dy, Font f)
   {
      obj.setSize(sx,sy);
      obj.setLocation(dx,dy);
      obj.setFont(f);
      c.add(obj);
   }
}