package tree.logic.print;

import tree.model.TreeModel;
import tree.util.ObjectUtil;

public class TreePrintText extends TreePrint {

	public void header() {
		System.out.println("================================");
		System.out.println("Text print : left | node | right");
		System.out.println("================================");
	}
	public void print(TreeModel treeModel) {
		if(!ObjectUtil.isNull(treeModel)) {
			if(!ObjectUtil.isNull(treeModel.getLeftTree())) System.out.print(treeModel.getLeftTree().getNode());
			System.out.print(" | " + treeModel.getNode() + " | ");
			if(!ObjectUtil.isNull(treeModel.getRightTree())) System.out.print(treeModel.getRightTree().getNode());
			System.out.println("");
			print(treeModel.getLeftTree());
			print(treeModel.getRightTree());
		}
	}
	public void footer() {
		System.out.println("================================");
	}
}
