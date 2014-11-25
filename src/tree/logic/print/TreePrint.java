package tree.logic.print;

import tree.model.TreeModel;

public abstract class TreePrint implements Print<TreeModel> {

	public abstract void header();
	public abstract void footer();
	public abstract void print(TreeModel treeModel);

	public void display(TreeModel treeModel) {
		header();
		print(treeModel);
		footer();
	}
}
