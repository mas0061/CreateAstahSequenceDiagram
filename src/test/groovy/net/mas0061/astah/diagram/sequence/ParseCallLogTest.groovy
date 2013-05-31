package net.mas0061.astah.diagram.sequence;

import static org.junit.Assert.*

import org.junit.Test

class ParseCallLogTest {

	@Test
	public void testParse() {
		def parser = new ParseCallLog()
		def fileStr = parser.parse("./input/callGraph.txt")
		fileStr.each {
			println it
		}
		assertTrue(fileStr.size() == 8)
	}

	@Test
	public void testParse2() {
		def parser = new ParseCallLog()
		def fileStr = parser.parse("./input/calllog.txt")
		fileStr.each {
			println it.spaceNum
		}
		assertTrue(fileStr.size() == 69)
	}

}
