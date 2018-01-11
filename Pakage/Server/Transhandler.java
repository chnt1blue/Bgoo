package Server;
//Bgoo
//作者:陈瑜
//这个.JAVA实现了与百度API的桥接和对下发的XML字段进行正确截取
//

import java.io.UnsupportedEncodingException;

import Server.TransApi;

public class Transhandler {

    // 在平台申请的APP_ID 详见
	//http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20170519000048421";
    private static final String SECURITY_KEY = "Xc0L4k58myEsLqovoUq8";

    public String trans(String Query ,String From ,String To) throws UnsupportedEncodingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String result= api.getTransResult(Query, From , To); 
        //以下是对字符串的截取过程
        result =result.substring(40);
        result =result.substring(0,result.length()-4);
        String[] sourceStrArray = result.split(",");
        sourceStrArray[1]=sourceStrArray[1].substring(7);
        //截取完成
        return sourceStrArray[1];
        //return result;
    }

}
