

function autoIncrease(endNum, showNode) {
	// 调整速度
	var startNum = 0;
	var millisec = 30;
	switch (true) {
	case endNum > 100:
		startNum = endNum - 100;
		millisec = 8;
		break;
	case endNum > 50:
		startNum = endNum - 50;
		millisec = 20;
		break;
	default:
		break;
	}
	autoIncreaseCustom(startNum, endNum, millisec, showNode);
}

/**
 * 
 * @param startNum 起始
 * @param endNum 结束
 * @param millisec 间隔
 * @param showNode 展示节点
 * @returns
 */
function autoIncreaseCustom(startNum, endNum, millisec, showNode) {
	var flagNum = setInterval(function() {
		showNode.text(startNum);
		startNum++;
		if (startNum > endNum) {
			clearInterval(flagNum);
			return;
		}
	}, millisec);
}