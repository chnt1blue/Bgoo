package Server;
//Bgoo
//作者:陈瑜
//这个.JAVA实现了数据库查询修改调派相关
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLHandler {
	//
	//以下函数功能分别为：
	//Getzh:根据英文获取中文
	//Getranden：根据ID号获取英文
	//Getrandzh：根据ID号获取中文
	//pisoff：根据ID号删掉wordw中的字段，然后为wordy添加新的字段(转移字段)
	//
	public String Getzh(String en) throws ClassNotFoundException, SQLException {
	//声明Connection对象
    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/word";
    //MySQL配置时的用户名
    String user = "chenyu";
    //MySQL配置时的密码
    String password = "123456";
    //遍历查询结果集
        //加载驱动程序
        Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        //2.创建statement类对象，用来执行SQL语句！！
        Statement statement = con.createStatement();
        //要执行的SQL语句
        String sql = "select zh from wordw where en = \""+en+"\"";
        //3.ResultSet类，用来存放获取的结果集！！
        ResultSet rs = statement.executeQuery(sql);
        String zh = null;
        while(rs.next()){
            zh = rs.getString("zh");
            
        }
            //输出结果
        rs.close();
        con.close();
        return zh;
}
	public String Getranden(int k) throws ClassNotFoundException, SQLException {
		//声明Connection对象
	    Connection con;
	    //驱动程序名
	    String driver = "com.mysql.jdbc.Driver";
	    //URL指向要访问的数据库名mydata
	    String url = "jdbc:mysql://localhost:3306/word";
	    //MySQL配置时的用户名
	    String user = "chenyu";
	    //MySQL配置时的密码
	    String password = "123456";
	    //遍历查询结果集
	        //加载驱动程序
	        Class.forName(driver);
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = DriverManager.getConnection(url,user,password);
	        if(!con.isClosed())
	            System.out.println("Succeeded connecting to the Database!");
	        //2.创建statement类对象，用来执行SQL语句！！
	        Statement statement = con.createStatement();
	        //要执行的SQL语句
	        String sql = "select en from wordw where id = \""+k+"\"";
	        //3.ResultSet类，用来存放获取的结果集！！
	        ResultSet rs = statement.executeQuery(sql);
	        String en = null;
	        while(rs.next()){
	            en = rs.getString("en");
	            //输出结果
	        }
	        rs.close();
	        con.close();
	        return en;
	}
	public String Getrandzh(int k) throws ClassNotFoundException, SQLException {
		//声明Connection对象
	    Connection con;
	    //驱动程序名
	    String driver = "com.mysql.jdbc.Driver";
	    //URL指向要访问的数据库名mydata
	    String url = "jdbc:mysql://localhost:3306/word";
	    //MySQL配置时的用户名
	    String user = "chenyu";
	    //MySQL配置时的密码
	    String password = "123456";
	    //遍历查询结果集
	        //加载驱动程序
	        Class.forName(driver);
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = DriverManager.getConnection(url,user,password);
	        if(!con.isClosed())
	            System.out.println("Succeeded connecting to the Database!");
	        //2.创建statement类对象，用来执行SQL语句！！
	        Statement statement = con.createStatement();
	        //要执行的SQL语句
	        String sql = "select zh from wordw where id = \""+k+"\"";
	        //3.ResultSet类，用来存放获取的结果集！！
	        ResultSet rs = statement.executeQuery(sql);
	        String zh = null;
	        while(rs.next()){
	            zh = rs.getString("zh");
	            
	        }
	            //输出结果
	        rs.close();
	        con.close();
	        return zh;
	}
	public String pisoff(String word) throws ClassNotFoundException, SQLException {
		//声明Connection对象
	    Connection con;
	    //驱动程序名
	    String driver = "com.mysql.jdbc.Driver";
	    //URL指向要访问的数据库名mydata
	    String url = "jdbc:mysql://localhost:3306/word";
	    //MySQL配置时的用户名
	    String user = "chenyu";
	    //MySQL配置时的密码
	    String password = "123456";
	    //遍历查询结果集
	        //加载驱动程序
	        Class.forName(driver);
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = DriverManager.getConnection(url,user,password);
	        if(!con.isClosed())
	            System.out.println("Succeeded connecting to the Database!");
	        //2.创建statement类对象，用来执行SQL语句！！
	        Statement statement = con.createStatement();
	        //要执行的SQL语句
	        String sql = "INSERT INTO wordy (en,zh) SELECT en,zh FROM wordw where zh = \""+word+"\"";
	        //3.ResultSet类，用来存放获取的结果集！！
	        statement.execute(sql);
	        con.close();
	        return "";
	}
	public String Getthemall() throws ClassNotFoundException, SQLException {
		//声明Connection对象
	    Connection con;
	    //驱动程序名
	    String driver = "com.mysql.jdbc.Driver";
	    //URL指向要访问的数据库名mydata
	    String url = "jdbc:mysql://localhost:3306/word";
	    //MySQL配置时的用户名
	    String user = "chenyu";
	    //MySQL配置时的密码
	    String password = "123456";
	    //遍历查询结果集
	        //加载驱动程序
	        Class.forName(driver);
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = DriverManager.getConnection(url,user,password);
	        if(!con.isClosed())
	            System.out.println("Succeeded connecting to the Database!");
	        //2.创建statement类对象，用来执行SQL语句！！
	        Statement statement = con.createStatement();
	        //要执行的SQL语句
	        String sql2 = "select * from wordy";
	        //3.ResultSet类，用来存放获取的结果集！！
	        ResultSet rs = statement.executeQuery(sql2);
	        String zh = null;
	        String en = null;
	        String id = null;
	        String result = null;
	        while(rs.next()){
	        	//获取num这列数据
                id = rs.getString("id");
                //获取en这列数据
                en = rs.getString("en");
                //获取zh这列数据
                zh = rs.getString("zh");

                //输出结果
                result = result +"\n"+(id+"\t" +en + "\t" + zh);
            }
	            //输出结果
	        rs.close();
	        con.close();
	        return result;
	}
}
