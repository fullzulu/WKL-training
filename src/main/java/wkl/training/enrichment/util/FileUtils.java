package wkl.training.enrichment.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Aliaksandr_Pleski
 *
 */
public class FileUtils {
	public static void appendToFile(File file, String content) throws IOException{
		FileWriter fileWritter = new FileWriter(file, true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(content);
        bufferWritter.close();
	}
	
	public static StringBuilder concatLines(File file) throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileInputStream(file));
		try{
			StringBuilder result = new StringBuilder();
			while(scanner.hasNextLine()){
				result.append(scanner.nextLine());
				if(scanner.hasNextLine()){
					result.append(System.getProperty("line.separator"));
				}
			}
			return result;
		}finally{
			scanner.close();
		}
	}
}
