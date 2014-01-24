package wkl.training.enrichment.file.service.impl;

import java.io.File;
import java.io.IOException;

import wkl.training.enrichment.file.service.IEnrichmentService;
import wkl.training.enrichment.util.FileUtils;

/**
 * 
 * @author Aliaksandr_Pleski
 * 
 */
public class DirectEnrichmentService implements IEnrichmentService {

	public void appendFileToFile(File toFile, File fromFile) throws IOException {
		StringBuilder fromContent = FileUtils.concatLines(fromFile);

		FileUtils.appendToFile(toFile, fromContent.toString());
	}

}
