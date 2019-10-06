package org.tecnificados.com.lector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lector de ficheros linea a linea
 */
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	log.info("Inicio");
    	List<String> readedLines = new ArrayList<String>();
        try {
        	readedLines = FileUtils.readLines(new File("fichero.txt"),"utf-8");
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
