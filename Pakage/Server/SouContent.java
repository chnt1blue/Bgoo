package Server;
//Bgoo
//作者:王梦圆
//这个.JAVA实现了mp3播放器相关
//
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SouContent {
		public static  void readToBuffer(StringBuffer buffer, String filePath)
	    throws IOException {
	        InputStream is = new FileInputStream(filePath);
	        String line; // 用来保存每行读取的内容
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        line = reader.readLine(); // 读取第一行
	        while (line != null) { // 如果 line 为空说明读完了
	            buffer.append(line); // 将读到的内容添加到 buffer 中
	            buffer.append("\n"); // 添加换行符
	            line = reader.readLine(); // 读取下一行
	        }
	        reader.close();
	        is.close();
	    }
		public String  Lyrics(String songname) throws IOException {
	        StringBuffer sb = new StringBuffer();
	        GetTextHandler.readToBuffer(sb, songname);
	        System.out.println(sb.toString());
	        return sb.toString();
	    }
		   
	   }
