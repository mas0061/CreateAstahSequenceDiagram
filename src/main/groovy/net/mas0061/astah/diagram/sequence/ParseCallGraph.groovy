package net.mas0061.astah.diagram.sequence

import net.mas0061.astah.diagram.sequence.node.CallNode

class ParseCallGraph {

	def List<CallNode> parse(String fileName) {
		List<CallNode> nodeList = new ArrayList<>()
		def file = new File(fileName)
		def orgList = file.collect()

		orgList.each {str->
			nodeList.add(createCallNode(str))
		}

		nodeList
	}

	def int getSpaceNum(String str) {
		str.length() - str.stripIndent().length()
	}

	def String getClassName(String str) {
		splitBackQuote(str, 0)
	}

	def String getFnOpName(String str) {
		splitBackQuote(str, 1)
	}

	def String splitBackQuote(String str, int getNum) {
		def splited = str.stripIndent().split("`")
		if (splited.length >= getNum - 1) {
			splited[getNum]
		}
	}

	def CallNode createCallNode(String source) {
		new CallNode(className: getClassName(source),
					fnOpName: getFnOpName(source),
					spaceNum: getSpaceNum(source))
	}
}
