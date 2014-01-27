package wkl.training.mvn.runner;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wkl.training.enrichment.file.service.IEnrichmentService;
import wkl.training.enrichment.file.service.impl.RevertEnrichmentService;

/**
 * 
 * @author Aliaksandr_Pleski
 * 
 */
public class Main {
	static Logger log = LogManager.getLogger(Main.class);
	public static void main(String[] args) {
		
		if (args.length == 2) {
			File toFile = getFile(args[0]);
			File fromFile = getFile(args[1]);
			
			try {
				IEnrichmentService service = new RevertEnrichmentService();
				service.appendFileToFile(toFile, fromFile);
				log.info("DONE");
			} catch (IOException e) {
				log.error("Error occured while appendig file content from file "
						+ fromFile.getName() + " to file " + toFile.getName() + ":\n" + e.getMessage(), e);
			}
		} else {
			log.error("You need to provide two file paths as arguments");
		}
	}
	
	private static File getFile(String path){
		File file = new File(path);
		if(!file.exists()){
			file = new File(System.getProperty("user.dir") + File.separator + path);
		}
		
		return file;
	}
}
