package wkl.training.mvn.runner;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wkl.training.enrichment.file.service.IEnrichmentService;
import wkl.training.enrichment.file.service.impl.DirectEnrichmentService;

/**
 * 
 * @author Aliaksandr_Pleski
 * 
 */
public class Main {
	static Logger log = LogManager.getLogger(Main.class);
	public static void main(String[] args) {
		
		if (args.length == 3) {
			File toFile = getFile(args[0]);
			File fromFile = getFile(args[1]);
			String regexp = args[2];
			
			try {
				IEnrichmentService service = new DirectEnrichmentService();
				service.appendFileToFile(toFile, fromFile, regexp);
				log.info("DONE");
			} catch (IOException e) {
				log.error("Error occured while appendig file content from file "
						+ fromFile.getName() + " to file " + toFile.getName() + ":\n" + e.getMessage(), e);
			}
		} else {
			log.error("You need to provide two file paths and regexp as arguments");
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
