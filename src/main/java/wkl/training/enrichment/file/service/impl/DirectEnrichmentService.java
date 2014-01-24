package wkl.training.enrichment.file.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import wkl.training.enrichment.file.service.IEnrichmentService;
import wkl.training.enrichment.util.FileUtils;

/**
 * 
 * @author Aliaksandr_Pleski
 *
 */
public class DirectEnrichmentService implements IEnrichmentService {

	public void appendFileToFile(File toFile, File fromFile) throws IOException {
		StringBuilder fromContent = new StringBuilder();
		Scanner scanner = new Scanner(new FileInputStream(fromFile));
		while(scanner.hasNextLine()){
			fromContent.append(scanner.nextLine());
			if(scanner.hasNextLine()){
				fromContent.append("\n");
			}
		}
		
		FileUtils.appendToFile(toFile, fromContent.toString());
	}

}
