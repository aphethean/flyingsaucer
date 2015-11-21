package org.xhtmlrenderer.pdf;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.lowagie.text.DocumentException;

public class TestITextRenderer {

	@Test
	public void testBasicRenderformXHTML() throws UnsupportedEncodingException,
			IOException, URISyntaxException, DocumentException {
		String yourXhtmlContentAsString = new String(Files.readAllBytes(Paths
				.get(getClass().getResource(
						"/TestITextRenderer-testBasicRenderformXHTML.xhtml")
						.toURI())), "UTF-8");
		String pdfOutputFilename = "target/TestITextRenderer-testBasicRenderformXHTML.pdf";
		FileOutputStream fos = new FileOutputStream(pdfOutputFilename);

		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(yourXhtmlContentAsString);
		renderer.layout();
		renderer.createPDF(fos);
		fos.close();

		assertTrue(new File(pdfOutputFilename).exists());
	}

}
