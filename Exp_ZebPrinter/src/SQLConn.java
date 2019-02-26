
import java.sql.*;
public class SQLConn 
{
    io_read read = new io_read();
    public Connection con( )
    {
        String url = "jdbc:sqlserver://" + read.read_ip() + ":" + read.read_TCP() + 
                ";instance="  + read.read_Instance() +
                ";databaseName=" + read.read_Data();
                
        
                /*
                ";integratedSecurity=" + true +
                ";encrypt =" + true +
                ";trustServerCertificate =" + true;*/
                
        String UserName = "username";
        String pass = "password";
        Connection con = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url,UserName, pass);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
        return con;
    }
}
