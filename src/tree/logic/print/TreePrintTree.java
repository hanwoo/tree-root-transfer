package tree.logic.print;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import tree.model.TreeModel;
import tree.util.ObjectUtil;

public class TreePrintTree extends TreePrint {

	public void header() {
		System.out.println("===============");
		System.out.println("Tree Print");
		System.out.println("===============");
	}

	public void print(TreeModel treeModel) {
		if(!ObjectUtil.isNull(treeModel)) {
			int indent = 10;
			int depth = 1;
			Queue<TreeModel> currentLevel = new LinkedList<TreeModel>();
	        Queue<TreeModel> nextLevel = new LinkedList<TreeModel>();
	
	        currentLevel.add(treeModel);
	
	        while(!currentLevel.isEmpty()) {
	            Iterator<TreeModel> iter = currentLevel.iterator();
	            indent = 10 + 1 - depth;
	            while(iter.hasNext()) {
	                TreeModel currentNode = iter.next();
	                if(!ObjectUtil.isNull(currentNode.getLeftTree())) {
	                    nextLevel.add(currentNode.getLeftTree());
	                }
	                if (!ObjectUtil.isNull(currentNode.getRightTree())) {
	                    nextLevel.add(currentNode.getRightTree());
	                }
	                print(currentNode.getNode(), indent);
	                indent = 1;
	            }
	            System.out.println();
	            if(!nextLevel.isEmpty()) {
	            	printLine(10 + 1 - depth, nextLevel.size());
	            }
	            currentLevel = nextLevel;
	            nextLevel = new LinkedList<TreeModel>();
	            depth++;
	        }
		}
	}

	public void footer() {
		System.out.println("===============");
	}

	private void print(int node, int indent) {
        for(int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
		System.out.print(node);
	}

	private void printLine(int indent, int size) {
		final String BLANK = "   ";
		final String LEFT_LINE = "/";
		final String RIGHT_LINE = "\\";
        for(int i = 1; i < indent; i++) {
            System.out.print(BLANK);
        }
		System.out.print(" ");
        for(int i = 0; i < size; i++) {
        	System.out.print(" ");
        	if((i % 2) == 0) 
        		System.out.print(LEFT_LINE);
        	else
        		System.out.print(RIGHT_LINE + BLANK);
        }
        System.out.println();
	}
}
