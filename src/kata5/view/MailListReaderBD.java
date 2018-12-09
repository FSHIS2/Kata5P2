package kata5.view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MailListReaderBD {
    public Connection connect(){
        String url = "jdbc:sqlite:email.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public List <String> read() throws SQLException{
        List <String> res = new ArrayList();
        String sql = "SELECT*FROM dir_email";
        try(Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                res.add(rs.getString("Mail"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
}
