package wkl.training.enrichment.file.service;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Aliaksandr_Pleski
 *
 */
public interface IEnrichmentService {
	void appendFileToFile(File toFile, File fromFile, String regexp) throws IOException;
}
