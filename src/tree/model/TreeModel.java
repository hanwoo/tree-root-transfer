package tree.model;

import tree.logic.print.TreePrint;
import tree.util.ObjectUtil;

public class TreeModel {
	
	private int node;
	private TreeModel leftTree;
	private TreeModel rightTree;
	private TreeModel parentTree;
	private boolean writeNode;
	private boolean root;
	
	public TreeModel(int node) {
		this.node = node;
	}

	public TreeModel() {
		// TODO Auto-generated constructor stub
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
	public boolean isWriteNode() {
		return writeNode;
	}
	public void setWriteNode(boolean writeNode) {
		this.writeNode = writeNode;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}


	public int getChoiceNode() {
		setWriteNode(true);
		return node;
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
//				if(!ObjectUtil.isNull(this.getLeftTree())) {
//					if(this.getLeftTree().getNode() == node.getNode()) {
//						return this.getLeftTree();
//					} else {
//						return this.getLeftTree().getChoice(node);
//					}
//				} else if(!ObjectUtil.isNull(this.getRightTree())) {
//					if(this.getRightTree().getNode() == node.getNode()) {
//						return this.getRightTree();
//					} else {
//						return this.getRightTree().getChoice(node);
//					}
//				}
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
