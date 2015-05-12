package org.stavros;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.stavros.text.process.FileUtils;

public class GetExtensionTest {
	
	@Test
	public void testSimple() {
		File f = getFile("C:\\workspaces\\aaa.txt");
		assertEquals("txt", FileUtils.getExtension(f));
		
		f = getFile("C:\\workspaces\\aaa.jsp");
		assertEquals("jsp", FileUtils.getExtension(f));
	}
	
	@Test
	public void testNoExtension() {
		File f = getFile("C:\\workspaces\\aaa");
		assertEquals("", FileUtils.getExtension(f));
	}
	
	private File getFile(String filename) {
		return new File(filename);
	}

}
