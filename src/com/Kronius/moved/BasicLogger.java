package com.Kronius.moved;

import java.io.BufferedWriter;
import java.io.Writer;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicLogger {
    
	private String logName = "log.log";
	private String currentDir = new File("").getAbsolutePath() + File.separator;
	private String logFileLocation = currentDir + logName;
	
	private BasicLogger(){}
	
	public void setLogName(String fileName){
		logName = fileName;
		logFileLocation = currentDir + logName;
	}

	public void log(String msg){
		writeLog("", msg,  getTime());
	}
	
	public void log(String source, String msg){
		writeLog(source, msg,  getTime());
	}
	
	public void log(String source, String msg, String time){
		writeLog(source, msg, time);
	}
	
	private String getTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return (dateFormat.format(date).toString());
	}
	
	private void writeLog(String source, String msg, String time){
		try{
			File file = new File(logFileLocation);
			Writer output = new BufferedWriter(new FileWriter(file, true));
			String messageToWrite = "";
			
			if(!time.equals("")){
				messageToWrite = messageToWrite + time + ": ";
			}
			
			if(!source.equals("")){
				messageToWrite = messageToWrite + source + ": ";
			}

			messageToWrite = messageToWrite + msg;		
			
			output.write(messageToWrite + "\n");
			output.close();
        } catch (IOException e){
        	//Error
        }
	}
	
	static private BasicLogger bl_instance;
	
	static public BasicLogger getInstance(){
	 if ( bl_instance == null )
		bl_instance = new BasicLogger();
	 return bl_instance;
	}
}