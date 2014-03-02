package com.Kronius.moved;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.Kronius.moved.BasicLogger;
import com.Kronius.moved.MoveDConfig;

public class MoveD {

	private static final boolean DEBUG_MODE = false;
	
	private static String CLASS_NAME;
	
	private BasicLogger logger;
	
	private JAXBContext jc;
	private Unmarshaller unmarshaller;
    private File xml;
    private MoveDConfig moveDConfig;
    private Marshaller marshaller;
	
	private static String DEFAULT_SRC = File.separator + "media" + File.separator + "PiDataDrive" + File.separator + "Downloads" + File.separator + "Done" + File.separator;
	private static String DEFAULT_DEST = File.separator + "media" + File.separator + "MediaDrive" + File.separator + "Video" + File.separator + "New" + File.separator;
	private String src = "";
	private String dest = "";
	
//	public MoveD(){
//		//TODO: XML Parsing for paths
//		
//		MoveD(DEFAULT_SRC, DEFAULT_DEST);
//	}
	
	public MoveD(){
		//logger.log(CLASS_NAME, "Init");
		String src = "";
		String dest = "";
		
		try{
			//Setup logging
			logger = BasicLogger.getInstance();
			logger.setLogName("MoveD.log");
			
			//XML Parsing
			jc = JAXBContext.newInstance(MoveDConfig.class);
	        unmarshaller = jc.createUnmarshaller();
	        xml = new File("res" + File.separator + "MoveDConfig.xml");
	        moveDConfig = (MoveDConfig) unmarshaller.unmarshal(xml);
	        
			src = moveDConfig.getSource();
			dest = moveDConfig.getDestination();
			//logger.log(CLASS_NAME, "JAXB src and dest loaded successfully");
			
			src = src.replace("\\", File.separator);
			src = src.replace("/", File.separator);
			dest = dest.replace("\\", File.separator);
			dest = dest.replace("/", File.separator);
			
			marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        //marshaller.marshal(moveDConfig, System.out);
			
	        //logger.log(CLASS_NAME, "src: " + src + " dest: " + dest);
			MoveDConstructor(src, dest);
	
		}catch(JAXBException JAXBe){
			src = DEFAULT_SRC;
			dest = DEFAULT_DEST;
			//System.out.println(JAXBe.getStackTrace().toString());
			//logger.log(CLASS_NAME, "JAXB Exception: " + JAXBe.getStackTrace().toString() + "\n\nsrc: " + src + " dest: " + dest);
		}
	}
	
	public void overrideXMLPaths(String srcIn, String destIn){
		MoveDConstructor(srcIn, destIn);
	}
	
	private void MoveDConstructor(String srcIn, String destIn){
		src = srcIn;
		dest = destIn;
	}
	
	public void move(){
		
		boolean done = false;//TODO: Store done flag in XML File?
		
		do{
			try{
				File srcDirectory = new File(src);
				
				//Get list of all files in the folder
				
				String[] directoryList = srcDirectory.list();
				
				for(String fileName: directoryList){
					//System.out.println(fileName);
					//logger.log(CLASS_NAME, fileName);
					
					File fileToMove = new File(srcDirectory + File.separator + fileName);
					//System.out.println(fileToMove.getPath());
					//logger.log(CLASS_NAME, fileToMove.getPath());
					File destFile = new File(dest + File.separator + fileToMove.getName());
					//System.out.println(destFile.getPath());
					//logger.log(CLASS_NAME, destFile.getPath());
					
					if(fileToMove.renameTo(destFile)){
						//System.out.println("File was moved successfully!");
						//logger.log(CLASS_NAME, "File was moved successfully!");
					}else{
						//System.out.println("File failed to move!");
						//logger.log(CLASS_NAME, "File failed to move!");
					}
				}
			 
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			
			done = true;
			
		}while(!done);
	}
	
	public static void main(String[] args){
		
		CLASS_NAME = MoveD.class.getName();
		
		MoveD moveD;
		moveD = new MoveD();
		
		if(DEBUG_MODE){
			String srcIn = "C:\\Users\\CASA\\moved\\testdir\\" + DEFAULT_SRC;
			String destIn = "C:\\Users\\CASA\\moved\\testdir\\" + DEFAULT_DEST;	
			moveD.overrideXMLPaths(srcIn, destIn);
		}
		
		moveD.move();
	}
}
