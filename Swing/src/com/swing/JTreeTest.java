package com.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class JTreeTest extends JFrame {

	private static final long serialVersionUID = -4982652866038983466L;
	private JTree tree;

	public JTreeTest() {
		this.setSize(new Dimension(300, 300));
		
		//节点
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("hello");

		DefaultMutableTreeNode yes = new DefaultMutableTreeNode("yes");

		DefaultMutableTreeNode no = new DefaultMutableTreeNode("no");

		DefaultMutableTreeNode leaf = new DefaultMutableTreeNode("world");
		
		leaf.add(yes);

		leaf.add(no);

		root.add(leaf);
		
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		
		//tree = new JTree(root);
		
		tree = new JTree(treeModel);
		// tree.putClientProperty("JTree.lineStyle", "None");//取消父子之间的连线
		
		
		//设置构建
		DefaultTreeCellRenderer render = new DefaultTreeCellRenderer();
		
		//render.setIcon(icon);
		
		tree.setCellRenderer(render);
		
		tree.setCellRenderer(new DefaultTreeCellRenderer() {
			
			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
					boolean leaf, int row, boolean hasFocus) {
				//this.setIcon(icon);
				//this.setClosedIcon(newIcon);
				//this.openIcon
				return null;
			}
		});
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				/**
				 * [hello, world] 
				 * [hello, world, yes] 
				 * [hello, world, no]
				 */
				JTree e_tree = (JTree) e.getSource(); 
				//TreePath treePath = e.getPath();
				TreePath treePath = e_tree.getSelectionPath();
				//treePath.getParentPath();
				//treePath.getPathComponent(1);
				//为什么要用path来封装，该方法之所以没有被称为getSelectedNode，
				//是因为这棵树并不了解它包含的节点，它的树模型只处理对象的路径。
				//treeModel.insertNodeInto(new DefaultMutableTreeNode("djf"), (DefaultMutableTreeNode)treePath.getLastPathComponent(), 0);
				//treeModel.removeNodeFromParent((DefaultMutableTreeNode)treePath.getLastPathComponent());
				/*System.out.println((DefaultMutableTreeNode)treePath.getLastPathComponent());
				System.out.println(e_tree.getLastSelectedPathComponent());*/
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("www.baidu.com");
				
				treeModel.insertNodeInto(new DefaultMutableTreeNode("djf"), (DefaultMutableTreeNode)treePath.getLastPathComponent(), 0);
				
				
				TreeNode[] nodes = treeModel.getPathToRoot(newNode);
				TreePath path = new TreePath(nodes); 
				//tree.makeVisible(path);
				tree.scrollPathToVisible(path);
				tree.setEditable(true);//设置可编辑
			}
		});
		this.getContentPane().add(new JScrollPane(tree));

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				new JTreeTest();
			}
		});

	}

}
