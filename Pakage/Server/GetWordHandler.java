package Server;
//Bgoo
//作者：陈瑜
//功能：实现了随机选取英文单词和随机选取中文单词两种handler
//

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class GetWordHandler {
	//提取英语单词
	@SuppressWarnings("unchecked")
	public  String GetEng(String fr,int i) 
	
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
	
	//提取汉语单词
@SuppressWarnings("unchecked")
public  String GetChi(String fr,int i)
	
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