package net.mas0061.astah.diagram.sequence;

import static org.junit.Assert.*;

import org.junit.Test;

class CreateSequenceDiagramTest {

	@Test
	public void testCreate() {
		CreateSequenceDiagram crSeqDiag = new CreateSequenceDiagram()
		crSeqDiag.create("SampleProject")
		
		def parser = new ParseCallGraph()
		def list = parser.parse("./input/callGraph.txt")
		crSeqDiag.createSequenceDiagram("testSeq", list)
		
		crSeqDiag.close()
	}

}
