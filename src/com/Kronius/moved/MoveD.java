package com.Kronius.moved;

import java.io.File;
import java.util.ArrayList;

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
				
				String[] directoryList = srcDirectory.list();
//				ArrayList<String> fileList = new ArrayList<String>();
//				
				for(String fileName: directoryList){
					System.out.println(fileName);
					
					File fileToMove = new File(srcDirectory + File.separator + fileName);
					System.out.println(fileToMove.getPath());
					File destFile = new File(dest + File.separator + fileToMove.getName());
					System.out.println(destFile.getPath());
					
					if(fileToMove.renameTo(destFile)){
						System.out.println("File was moved successfully!");
					}else{
						System.out.println("File failed to move!");
					}
//					
//					if(!(new File(srcDirectory + fileName)).isDirectory()){//This Check Fails
//						
//						System.out.println("directoryList: " + fileName + " IS NOT a Directory" );
//						
//						fileList.add(fileName);
//					}
//					else{
//						System.out.println("directoryList: " + fileName + " IS a Directory" );
//					}
				}
//				
//				System.out.println("-----------------------------------------------------------");
//				
//				for(String fileName: fileList){
//					System.out.println("fileList: " + fileName);
//				}
				
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
