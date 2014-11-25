package tree.model;

import tree.logic.print.TreePrint;
import tree.util.ObjectUtil;

public class TreeModel {
	
	private int node;
	private TreeModel leftTree;
	private TreeModel rightTree;
	private TreeModel parentTree;
	
	public TreeModel(int node) {
		this.node = node;
	}

	public TreeModel() {
	}

	public int getNode() {
		return node;
	}
	public void setNode(int node) {
		this.node = node;
	}
	public TreeModel getLeftTree() {
		return leftTree;
	}
	public void setLeftTree(TreeModel leftTree) {
		this.leftTree = leftTree;
		leftTree.setParentTree(this);
	}
	public TreeModel getRightTree() {
		return rightTree;
	}
	public void setRightTree(TreeModel rightTree) {
		this.rightTree = rightTree;
		rightTree.setParentTree(this);
	}
	public TreeModel getParentTree() {
		return parentTree;
	}
	public void setParentTree(TreeModel parentTree) {
		this.parentTree = parentTree;
	}

	public TreeModel getChoice(TreeModel node) {
		TreeModel choiceTree = null;
		if(!ObjectUtil.isNull(node)) {
			if(this.getNode() == node.getNode()) {
				return this;
			} else {
				if(!ObjectUtil.isNull(this.getLeftTree())) {
					choiceTree = this.getLeftTree().getChoice(node);
					if(ObjectUtil.isNull(choiceTree) && !ObjectUtil.isNull(this.getRightTree())) {
						choiceTree = this.getRightTree().getChoice(node);
					}
				}
				if(!ObjectUtil.isNull(this.getRightTree())) {
					choiceTree = this.getRightTree().getChoice(node);
					if(ObjectUtil.isNull(choiceTree) && !ObjectUtil.isNull(this.getLeftTree())) {
						choiceTree = this.getLeftTree().getChoice(node);
					}
				}
				return choiceTree;
			}
		} else {
			System.out.println(node.getNode() + " is not node!");
			return null;
		}
	}
	
	public void display(TreePrint print) {
		print.display(this);
	}


}
