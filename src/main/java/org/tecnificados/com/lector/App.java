package org.tecnificados.com.lector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Lector de ficheros linea a linea
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<String> readedLines = new ArrayList<String>();
        try {
        	readedLines = FileUtils.readLines(new File("fichero.txt"),"utf-8");
			System.out.println("Lineas: "+readedLines.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (String actual:readedLines)
        {
			System.out.println("\t"+actual);
        }
    }
}
