package Server;
//bgoo
//作者：王梦圆
//功能：mp3播放器相关

import javax.media.Player;

import Server.st;

public class Controller {
	 private st mp3;
    
    public Controller(st mp3){
        this.mp3 = mp3;
   }
//��ʼ����   
   public void mp3Start(){
       if(!mp3.getIsStarted()){
           mp3.setTriggerStart(true);
           System.out.println("has started!");
       } else {
       	//mp3Pause();
           System.out.println("Error: A song is playing now, thus player cannot start another");
       }
   }
   //ֹͣ
   public void mp3Stop() {
       if(mp3.getIsStarted()){
           Player player = mp3.getPlayer();
           player.stop();
           player.deallocate();
           player.close();
          mp3.setIsStarted(false);
          mp3.setTriggerStart(false);
         //  mp3.setCurrentIndex(mp3.getCurrentIndex() - 1);
       } else if(mp3.getIsPaused()){
           mp3.setIsPaused(false);
          mp3.setPauseTime(null);
       } else {
           System.out.println("Error: No song has been playing yet, thus can not been stopped");
       }
   }
   //��һ��In
   public void mp3Next(){
      if(mp3.getIsStarted() || mp3.getIsPaused()){
           this.mp3Pause();
       }
      int currentIndex = mp3.getCurrentIndex();
      System.out.println(currentIndex);
      System.out.println(mp3.getSonglist().size());
      if(currentIndex < (mp3.getSonglist().size() - 1)){
   	   currentIndex=currentIndex+1;
          mp3.setCurrentIndex( currentIndex );
          System.out.println(currentIndex);
          this.mp3Start();
       } else {
           System.out.println("Error: End of the songlist");
       }
   }
   //��һ��
   public void mp3Previous() {
       if(mp3.getIsStarted()){
           this.mp3Stop();
       }
       if(mp3.getIsPaused()){
          mp3.setPauseTime(null);
           mp3.setIsPaused(false);
       }
       int currentIndex = mp3.getCurrentIndex();
       System.out.println(currentIndex);
     if(currentIndex > 0){
       	mp3.setCurrentIndex(currentIndex - 1);
         this.mp3Start();
      } else {
       System.out.println("Error: Start of the songlist");
       }
   }
  
   public void mp3Pause() {
       if(mp3.getIsStarted()){
           
           Player player = mp3.getPlayer();
           mp3.setPauseTime(player.getMediaTime());
           System.out.println(player.getMediaTime());
           player.stop();
           player.deallocate();
           player.close();
           mp3.setIsStarted(false);
           mp3.setIsPaused(true);
           mp3.setTriggerStart(false);
         // mp3.setCurrentIndex(mp3.getCurrentIndex() - 1);
      } else {
           System.out.println("Error: No song has been playing yet, thus can not paused");
       }
 }
 
   public void choness(int index)
   {
   	
			if (mp3.getCurrentIndex() !=index ){
				if (mp3.getIsStarted())
					mp3Stop();
				mp3.setCurrentIndex(index);
               mp3Start();
			}
		}
   
}
