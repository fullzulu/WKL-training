package wkl.training.enrichment.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
