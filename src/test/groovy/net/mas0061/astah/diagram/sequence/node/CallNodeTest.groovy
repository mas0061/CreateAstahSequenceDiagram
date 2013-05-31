package net.mas0061.astah.diagram.sequence.node;

import static org.junit.Assert.*

import org.junit.Test

class CallNodeTest {

	@Test
	public void testCallNode() {
		def node = new CallNode(className: "A")
		node.addFnOp("a1")
		assertTrue(node.className == "A" && node.fnOpList.first() == "a1")
	}

	@Test
	public void testCallNode2() {
		def node = new CallNode(className: "A")
		def fnOp = ["a1", "a2"]
		node.addFnOps(fnOp)
		println node.fnOpList.dump()
		assertTrue(node.fnOpList.size() == 2 && node.fnOpList.equals(fnOp))
	}

}
