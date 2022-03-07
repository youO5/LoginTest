package Diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
   public static final String logdata = null;
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String user = "c##ezen";
   String password = "ezen1234";

   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   
   public ArrayList<LoginVo> list(String pid) {
      ArrayList<LoginVo> list = new ArrayList<LoginVo>();

      try {
         connDB();

         String query = "SELECT * FROM login";
         if(pid != null) {
            query += " where ID='" + pid + "'";
         }
         System.out.println(query);
         rs = stmt.executeQuery(query);
         rs.last();
         
         System.out.println("rs.getRow() : " + rs.getRow());
         
         if(rs.getRow() == 0) {
            System.out.println("0 row selected...");
         }else {
            rs.previous();
            while (rs.next()) {
               String ID = rs.getString("ID");
               String PW = rs.getString("PW");

               LoginVo data = new LoginVo(ID, PW);
               list.add(data);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return list;
   }

   public void connDB() {
      try {
         Class.forName(driver);
         System.out.println("jdbc driver loading success.");
         con = DriverManager.getConnection(url, user, password);
         System.out.println("oracle connection success.");
         stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         System.out.println("statement create success.");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}