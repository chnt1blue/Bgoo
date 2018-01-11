package Server;
//Bgoo
//作者:陶冶
//这个.JAVA实现了mp3播放器相关
//
import java.io.File;
import java.util.Vector;

import javax.media.Manager;
import javax.media.Player;

import Server.st;

public class mp3player extends Thread{
	 private st mp3;
	   private int songlistLength;
	   private Vector<String> songlist;
	   private Player player = null;
	   public mp3player(st mp3){
	    	this.mp3=mp3;
	    	songlistLength=mp3.getSonglist().size();//�б?��
	    	songlist=mp3.getSonglist();
	    	
}
	   
@SuppressWarnings("deprecation")
public void run(){
	int currentIndex;
	double currentTime=0;
	double currentDuration=-1;
	currentIndex=mp3.getCurrentIndex();//��õ�ǰ�±�
	 while((currentIndex<=songlistLength))
	 {
		 if(mp3.getTriggerStart()&&(currentTime>=currentDuration))
		 {
			 try{
				 
				 String song = songlist.get(mp3.getCurrentIndex())
					.toString();
				System.out.println(mp3.getCurrentIndex());
				File currentSong = new File(song);
				 //File currentSong =new File(songlist.elementAt(currentIndex));
				 player=Manager.createRealizedPlayer(currentSong.toURL());
				 mp3.setPlayer(player);
				 if(mp3.getIsPaused())
				 {
					//player.getMediaTime();
					player.setMediaTime(mp3.getPauseTime());
				 }
				    player.start();//��ʼ����
					System.out.println(currentSong.getName());
					//System.out.print(">>>");
					mp3.setIsStarted(true);
					currentDuration = player.getDuration().getSeconds();
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
			if (mp3.getIsStarted()) {
				currentTime = player.getMediaTime().getSeconds();
			} else {
				currentTime = 0;
				currentDuration = -1;
			}
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
			}
		}
}	
}
