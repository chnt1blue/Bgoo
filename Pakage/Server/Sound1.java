package Server;
//Bgoo
//作者:王梦圆
//这个.JAVA实现了mp3播放器相关
//
import Server.Controller;
import Server.mp3player;
import Server.st;

public class Sound1 {
	  
     
	 static st mp3 = new st();
       Controller controller =new Controller(mp3);
      static mp3player player=new mp3player(mp3);
      public String chushihua(){
          
    	  player.start();
          return "hao";
         }
    
      public String start1(){
    	    
       controller.mp3Start();
       return "hao";
      }
	   public String pause1(){
		   controller.mp3Pause();
		   return "hao";
	   }
	          
	   public String stop1(){
		   controller.mp3Stop();
		   return "hao";
	   }
	   public String next1(){
		   controller.mp3Next();
		   return "hao";
	   }
	   public String prev1(){
		   controller.mp3Previous();
		   return "hao";
	   }
	   public String choness1(int index){
		   
		   controller.choness(index);
		   return "hao";
	   }
	}
	
