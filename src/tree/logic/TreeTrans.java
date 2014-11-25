package tree.logic;

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
		TreeModel treeTransModel = treeTrans(5);
		System.out.println("");
		System.out.println("========= Root Transfer Node ================");
		treeTransModel.display(new TreePrintText());
		treeTransModel.display(new TreePrintTree());
	}
	
	private static void init() {

//		insert(2);
//		insert(3);
//		insert(4);
//		insert(5);
//		insert(6);
//		insert(7);
		
		TreeModel tree2Model = new TreeModel(2);
		TreeModel tree3Model = new TreeModel(3);
		TreeModel tree4Model = new TreeModel(4);
		TreeModel tree5Model = new TreeModel(5);
		TreeModel tree6Model = new TreeModel(6);
		TreeModel tree7Model = new TreeModel(7);
		TreeModel tree8Model = new TreeModel(8);
		TreeModel tree9Model = new TreeModel(9);
		TreeModel tree10Model = new TreeModel(10);
		TreeModel tree11Model = new TreeModel(11);
		TreeModel tree12Model = new TreeModel(12);
		TreeModel tree13Model = new TreeModel(13);
		TreeModel tree14Model = new TreeModel(14);
		TreeModel tree15Model = new TreeModel(15);

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
		treeModel.setRoot(true);
	}

	private static TreeModel treeTrans(int node) {
		TreeModel choiceTree = treeModel.getChoice(new TreeModel(node));
		if(ObjectUtil.isNull(choiceTree)) return new TreeModel(0);
		if(ObjectUtil.isNull(choiceTree) || ObjectUtil.isNull(choiceTree.getParentTree())) {
			return choiceTree;
		}
		if(ObjectUtil.isNull(choiceTree.getLeftTree()) && ObjectUtil.isNull(choiceTree.getRightTree())) {
			TreeModel tranTree = new TreeModel(choiceTree.getChoiceNode());
			tranTree.setLeftTree(new TreeModel(choiceTree.getParentTree().getChoiceNode()));
			insert(choiceTree.getParentTree(), tranTree.getLeftTree());
			return tranTree;
		} else {
			System.out.println("Last Node is not.");
			return new TreeModel(0);
		}
	}
	private static TreeModel insert(TreeModel currentTree, TreeModel tranTree) {
		 
		if(!ObjectUtil.isNull(currentTree.getParentTree())) {
			tranTree.setLeftTree(new TreeModel(currentTree.getParentTree().getChoiceNode()));
			if(currentTree.getLeftTree().getNode() == tranTree.getParentTree().getNode()) {
				tranTree.setRightTree(currentTree.getRightTree());
			} else {
				tranTree.setRightTree(currentTree.getLeftTree());
			}
			//tranTree.display(new TreePrintText());
			insert(currentTree.getParentTree(), tranTree.getLeftTree());
		} else {
			if(currentTree.getLeftTree().getNode() == tranTree.getParentTree().getNode()) {
				tranTree.setLeftTree(currentTree.getRightTree());
			} else {
				tranTree.setLeftTree(currentTree.getLeftTree());
			}
//			if(!ObjectUtil.isNull(currentTree.getLeftTree()) && !currentTree.getLeftTree().isWriteNode()) {
//				tranTree.setLeftTree(new TreeModel(currentTree.getLeftTree().getChoiceNode()));
//				insert(currentTree.getLeftTree(), tranTree);
			
//			} else if(!ObjectUtil.isNull(currentTree.getRightTree()) && !currentTree.getRightTree().isWriteNode()) {
//				tranTree.setRightTree(new TreeModel(currentTree.getRightTree().getChoiceNode()));
//				insert(currentTree.getRightTree(), tranTree);
//			}
		}
		//currentTree.getLeftTree();
		return tranTree;
	}
	
}
