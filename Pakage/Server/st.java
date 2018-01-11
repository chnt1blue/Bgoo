package Server;
//Bgoo
//作者:陶冶
//这个.JAVA实现了mp3相关
//
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.media.Player;
import javax.media.Time;

public class st {
	
	private Vector<String> songlist=new Vector<String>();
    private int currentIndex = 0;
    private Player player = null;
    private boolean isStarted = false;
    private boolean isPaused = false;
    private Time pauseTime = null;
    private boolean triggerStart = false;
    File file = new File("data//songlist.txt");
    public st() {
    	 try{
    		             BufferedReader in = new BufferedReader(new FileReader("Source/songlist.txt"));
    		            String eachline;
    		             while((eachline = in.readLine()) != null){
    		                 songlist.addElement(eachline);
    		             }
    		             in.close();
    		         } catch(IOException e){
    		            System.out.println(e.getMessage());
    		             System.exit(1);
    		        }
    }
    	
 public Vector<String> getSonglist(){
       return songlist;
    }
    
    public void setTriggerStart(boolean state){
        triggerStart = state;
   }
   
    public boolean getTriggerStart(){
        return triggerStart;
    }    
   
   public void setCurrentIndex(int index){
        currentIndex = index;
    }
    
   public int getCurrentIndex(){
        return currentIndex;
    }
    
    public void setPlayer(Player player){
       this.player = player;
    }
   
   public Player getPlayer() {
        return player;
    }
    
    public void setIsStarted(boolean state){
        isStarted = state;
   }
    
    public boolean getIsStarted(){
        return isStarted;
    }
    
    public void setIsPaused(boolean state){
        isPaused = state;
    }
    
    public boolean getIsPaused(){
       return isPaused;
   }
    public void setPauseTime(Time time) {
		pauseTime = time;
	}

	public Time getPauseTime() {
		return pauseTime;
	
  
   }


}
