package Server;
//Bgoo
//作者:陈瑜
//这个.JAVA实现了对单词的随机选取和其中文意思的对应选取
//
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReciteHandler {
	//��ȡӢ�ﵥ��
	@SuppressWarnings("unchecked")
	public  String Recite(String fr,int i) 
	
	{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fr));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tmp;
		ArrayList wd =new ArrayList();
		try {
			while((tmp=br.readLine())!=null)
			{
				tmp = tmp.substring(3, 18);
				wd.add(tmp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String f=wd.get(i).toString();
	         return f;
		
	}
	
	//��ȡ���ﵥ��
@SuppressWarnings("unchecked")
public  String Mean(String fr,int i)
	
	{
		BufferedReader be = null;
		try {
			be = new BufferedReader(new FileReader(fr));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tmp1;
		ArrayList me =new ArrayList();
		try {
			while((tmp1=be.readLine())!=null)
			{
				tmp1=tmp1.substring(19);
				me.add(tmp1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   String f=me.get(i).toString();
	      return f;
		
	}
}
