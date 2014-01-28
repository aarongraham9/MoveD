package com.Kronius.moved;

import java.io.File;

public class MoveD {

	private static final boolean DEBUG_MODE = true;
	
	private static String DEFAULT_SRC = File.separator + "media" + File.separator + "PiDataDrive" + File.separator + "Downloads" + File.separator + "Done" + File.separator;
	private static String DEFAULT_DEST = File.separator + "media" + File.separator + "MediaDrive" + File.separator + "Video" + File.separator + "New" + File.separator;
	private String src = "";
	private String dest = "";
	
//	public MoveD(){
//		//TODO: XML Parsing for paths
//		
//		MoveD(DEFAULT_SRC, DEFAULT_DEST);
//	}
	
	public MoveD(String srcIn, String destIn){
		src = srcIn;
		dest = destIn;
		//TODO: Setup logging
		//TODO: XML Parsing
	}
	
	public void move(){
		
		boolean done = false;//TODO: Store done flag in XML File?
		
		do{
			try{
				File srcDirectory = new File(src);
				
				//Get list of all files in the folder
				
				String[] fileList = srcDirectory.list();
				
				for(String fileName: fileList){
					System.out.println(fileName);
				}
				
				//---------------------------------------------------------------------------------------------------------------------------------
				
				
			 
//				if(srcDirectory.renameTo(new File(dest + srcDirectory.getName()))){
//					System.out.println("File is moved successful!");
//				}else{
//					System.out.println("File is failed to move!");
//				}
			 
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			
			done = true;
			
		}while(!done);
	}
	
	public static void main(String[] args){
		MoveD moveD;
		
		//TODO: Remove Test Paths
		String srcIn = "C:\\Users\\CASA\\moved\\testdir\\" + DEFAULT_SRC;
		String destIn = "C:\\Users\\CASA\\moved\\testdir\\" + DEFAULT_DEST;	
		moveD = new MoveD(srcIn, destIn);
		
		moveD.move();
	}
}
