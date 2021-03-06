package net.mas0061.astah.diagram.sequence

import net.mas0061.astah.diagram.sequence.node.CallNode

class ParseCallLog {
	def topSpaceNum

	List<CallNode> parse(String fileName) {
		List<String> orgList = new File(fileName).collect()
		
		def top = orgList.find{ !(it =~ /^(Init|debug|print)/) && it =~ /.*`.*/ }
		topSpaceNum = getSpaceNum(top)

		List<CallNode> nodeList = []
		orgList.findAll{ !(it =~ /^(Init|debug|print)/) && it =~ /.*`.*/ }.each {str->
			def trimStr = str.stripIndent(topSpaceNum)
			nodeList.add(createCallNode(trimStr))
		}

		nodeList
	}
	
	int getSpaceNum(String str) {
		str.length() - str.stripIndent().length()
	}

	String getClassName(String str) {
		splitBackQuote(str, 0)
	}

	String getFnOpName(String str) {
		splitBackQuote(str, 1)
	}

	String splitBackQuote(String str, int getNum) {
		def splited = str.stripIndent().split("`")
		if (splited.length >= getNum - 1) {
			splited[getNum]
		}
	}

	CallNode createCallNode(String source) {
		new CallNode(className: getClassName(source),
					fnOpName: getFnOpName(source),
					spaceNum: getSpaceNum(source))
	}
}
