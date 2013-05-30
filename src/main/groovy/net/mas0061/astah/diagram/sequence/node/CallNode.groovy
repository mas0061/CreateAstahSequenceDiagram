package net.mas0061.astah.diagram.sequence.node

class CallNode {
	String className
	String fnOpName
	List<String> fnOpList = []
	int spaceNum
	
	def addFnOp(String name) {
		fnOpList.add(name)
	}
	
	def addFnOps(List<String> names) {
		fnOpList += names
	}
}
