package SQLServerConnection;


import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import SQLServerConnection.JDBCObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 8/18/2017.
 */
@SuppressLint("NewApi")
public class JDBCModel {

    public Connection getConnectionOf() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection objConn = null;
        String sConnURL = null;
        JDBCObject objEntity = new JDBCObject("192.168.1.8", "sa", "saxsax11", "master", "1433");
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            sConnURL = "jdbc:jtds:sqlserver://" + objEntity.getsServerName() + ":" + objEntity.getsPrort() + ";" +
                        "databaseName=" + objEntity.getsDatabase()
                        + ";encrypt=False;sslProtocol=TLSv1.2";
            objConn = DriverManager.getConnection(sConnURL, "sa", "saxsax11");
        } catch (SQLException se) {
            Log.e("Error", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("Error", e.getMessage());
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return objConn;
    }
}

