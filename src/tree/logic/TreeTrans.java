package tree.logic;

import tree.exception.NotChoiceException;
import tree.exception.NotLastNodeException;
import tree.logic.print.TreePrintText;
import tree.logic.print.TreePrintTree;
import tree.model.TreeModel;
import tree.util.ObjectUtil;

public class TreeTrans {
	private static TreeModel treeModel = new TreeModel(1);
	
	public static void main(String[] args) {
		init();

		System.out.println("========= Input Node ================");
		treeModel.display(new TreePrintTree());
		
		System.out.println("");
		System.out.println("========= Root Transfer Node ================");
		TreeModel treeTransModel = treeTrans(5);
		treeTransModel.display(new TreePrintText());
		treeTransModel.display(new TreePrintTree());
	}
	
	private static void init() {

		TreeModel tree2Model = new TreeModel(2);
		TreeModel tree3Model = new TreeModel(3);
		TreeModel tree4Model = new TreeModel(4);
		TreeModel tree5Model = new TreeModel(5);
		TreeModel tree6Model = new TreeModel(6);
		TreeModel tree7Model = new TreeModel(7);
//		TreeModel tree8Model = new TreeModel(8);
//		TreeModel tree9Model = new TreeModel(9);
//		TreeModel tree10Model = new TreeModel(10);
//		TreeModel tree11Model = new TreeModel(11);
//		TreeModel tree12Model = new TreeModel(12);
//		TreeModel tree13Model = new TreeModel(13);
//		TreeModel tree14Model = new TreeModel(14);
//		TreeModel tree15Model = new TreeModel(15);

//		tree4Model.setLeftTree(tree8Model);
//		tree4Model.setRightTree(tree9Model);
//
//		tree5Model.setLeftTree(tree10Model);
//		tree5Model.setRightTree(tree11Model);
//
//		tree6Model.setLeftTree(tree12Model);
//		tree6Model.setRightTree(tree13Model);
//
//		tree7Model.setLeftTree(tree14Model);
//		tree7Model.setRightTree(tree15Model);
		
		tree2Model.setLeftTree(tree4Model);
		tree2Model.setRightTree(tree5Model);
		tree3Model.setLeftTree(tree6Model);
		tree3Model.setRightTree(tree7Model);
		treeModel.setLeftTree(tree2Model);
		treeModel.setRightTree(tree3Model);
	}

	private static TreeModel treeTrans(int node) {
		TreeModel choiceTree = treeModel.getChoice(new TreeModel(node));
		if(ObjectUtil.isNull(choiceTree)) {
			throw new NotChoiceException("Input number is not choice.");
		}
		if(ObjectUtil.isNull(choiceTree) || ObjectUtil.isNull(choiceTree.getParentTree())) {
			return choiceTree;
		}
		if(ObjectUtil.isNull(choiceTree.getLeftTree()) && ObjectUtil.isNull(choiceTree.getRightTree())) {
			TreeModel transTree = new TreeModel(choiceTree.getNode());
			transTree.setLeftTree(new TreeModel(choiceTree.getParentTree().getNode()));
			insert(choiceTree.getParentTree(), transTree.getLeftTree());
			return transTree;
		} else {
			throw new NotLastNodeException("Last Node is not.");
		}
	}

	private static TreeModel insert(TreeModel currentTree, TreeModel transTree) {
		 
		if(!ObjectUtil.isNull(currentTree.getParentTree())) {
			transTree.setLeftTree(new TreeModel(currentTree.getParentTree().getNode()));
			if(currentTree.getLeftTree().getNode() == transTree.getParentTree().getNode()) {
				transTree.setRightTree(currentTree.getRightTree());
			} else {
				transTree.setRightTree(currentTree.getLeftTree());
			}
			insert(currentTree.getParentTree(), transTree.getLeftTree());
		} else {
			if(currentTree.getLeftTree().getNode() == transTree.getParentTree().getNode()) {
				transTree.setLeftTree(currentTree.getRightTree());
			} else {
				transTree.setLeftTree(currentTree.getLeftTree());
			}

		}
		return transTree;
	}
	
}
