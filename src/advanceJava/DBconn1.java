package advanceJava;
import java.sql.*;

public class DBconn1 
{
	public static void main(String[] args) 
	{
		try
        {   String url, name, pwd;
            System.out.println("Hello");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Note:
            // 1. forName() can return a Class class's object or can return nothing
            // 2. Driver load statement points towards SQLServerDriver class present in the driver jar file, hence it needs to be correctly pointed
            // 3. Procedure to point driver class file in IntelliJ:
            //  - Click on File menu => Project Structure => Modules => Dependencies => Click + and add the jar
            //  - Jar name: mssql-jdbc-10.2.0.jre8.jar
            System.out.println("Driver loaded");
            // Note:
            // 1. To add SSL certificate to keystore (for PKIX error), use following commands:
            //     cd "/Library/Java/JavaVirtualMachines/jdk1.8.0_212.jdk/Contents/Home/jre/lib/security"
            //     keytool -import -alias example  -file cacert_advJava.der
            // 2. Naming convention for URL:
            //     jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
            //     url = "jdbc:sqlserver://" +serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;"
            url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;";
            name = "sa";
            pwd = "reallyStrongPwd123";
            Connection con = DriverManager.getConnection(url,name,pwd);
            if (con != null)
                System.out.println("Connection Established. \nHashcode => "+con);
            else
                System.out.println("Connection could not establish");
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
	}

}
