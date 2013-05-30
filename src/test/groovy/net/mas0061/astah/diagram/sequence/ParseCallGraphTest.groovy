package net.mas0061.astah.diagram.sequence;

import static org.junit.Assert.*;

import org.junit.Test;

class ParseCallGraphTest {

	@Test
	public void testParse() {
		def parser = new ParseCallGraph()
		def fileStr = parser.parse("./input/callGraph.txt")
		assertTrue(fileStr.size() == 5)
	}

}
