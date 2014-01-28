package com.Kronius.moved;

import java.io.File;

public class MoveD {

	private static String DEFAULT_SRC = File.separator + "media" + File.separator + "PiDataDrive" + File.separator + "Downloads" + File.separator + "Done" + File.separator;
	private static String DEFAULT_DEST = File.separator + "media" + File.separator + "MediaDrive" + File.separator + "Video" + File.separator + "New" + File.separator;
	private String src = "";
	private String dest = "";
	
	public MoveD(String srcIn, String destIn){
		src = srcIn;
		dest = destIn;
		//TODO: Setup logging
	}
	
	public void move(){
		boolean done = false;
		
		do{
			try{
				
				File afile = new File(src);
			 
				if(afile.renameTo(new File(dest + afile.getName()))){
					System.out.println("File is moved successful!");
				}else{
					System.out.println("File is failed to move!");
				}
			 
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			
		}while(!done);
	}
	
	public static void main(String[] args){
		//TODO: Remove Test Paths
		String srcIn = "C:\\Users\\CASA\\moved\\testdir\\" + DEFAULT_SRC;
		String destIn = "C:\\Users\\CASA\\moved\\testdir\\" + DEFAULT_DEST;
		
		MoveD moveD = new MoveD(srcIn, destIn);
		moveD.move();
	}
}
