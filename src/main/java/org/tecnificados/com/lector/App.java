package org.tecnificados.com.lector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lector de ficheros linea a linea
 */
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	private static String filePath="fichero.txt";
	
	private static void configuration() {
		Properties prop = new Properties();
    	try 
    	{
    		InputStream input = new FileInputStream("conf.properties");
    		prop.load(input);    	         	    
    	} 
    	catch (IOException ex) {
    	    log.error("Error reading  configuration file",ex);
    	}
    	
    	if (prop.getProperty("pathToFile")!=null) {
    		filePath=prop.getProperty("pathToFile");
    	}else {
    		log.info("pathToFile not readed in conf.properties");
    	}
		
	}
	
    public static void main( String[] args )
    {
    	log.info("Inicio");
    	    	  	
    	configuration();    	
    	
    	List<String> readedLines = new ArrayList<String>();
        try {
        	readedLines = FileUtils.readLines(new File(filePath),"utf-8");
        	log.info("Lineas: "+readedLines.size());
			
		} catch (IOException e) {
			log.error("Error reading file",e);
		}
        for (String actual:readedLines)
        {
			log.info(actual);
        }
        log.info("Fin");
    }

	
}
