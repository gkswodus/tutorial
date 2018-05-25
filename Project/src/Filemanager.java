import java.awt.BorderLayout;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Filemanager extends JFrame {
	
	private static final String Test = null;
	JTree tree;
	DefaultTreeModel treeModel;
	
	File dir = new File("c:\\");
	
	File[] files = dir.listFiles();
	FileFilter fileFilter = new FileFilter() {
		public boolean accept(File file) {
			return file.isDirectory();
		}
	};
	
	File dir1 = new File("d:\\");
	
	File[] files1 = dir1.listFiles();
	FileFilter fileFilter1 = new FileFilter() {
		public boolean accept(File file1) {
			return file1.isDirectory();
		}
	};
	
	protected boolean state;
	
	public Filemanager() {
		super("파일 탐색기");
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("내 컴퓨터");
		DefaultMutableTreeNode subroot = new DefaultMutableTreeNode("디스크 드라이브(c:)");
		DefaultMutableTreeNode subroot1 = new DefaultMutableTreeNode("디스크 드라이브(d:)");
		
		treeModel = new DefaultTreeModel(root);
		
		tree = new JTree(treeModel);
		JPanel p = new JPanel();
		JLabel l = new JLabel("Filemanager");
		
		JTextField tf = new JTextField("회로 2학년 1반 20번 한재연");
		
		root.add(subroot);
		root.add(subroot1);
		
		add(p, BorderLayout.SOUTH);
		add(tree, BorderLayout.WEST);
		add(tf, BorderLayout.NORTH);
		p.add(l, BorderLayout.SOUTH);
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		files = dir.listFiles(fileFilter);
		if(files.length == 0) {
			System.out.println("Either dir does not exist or iss not a directory");
		}
		else {
			for(int i = 0; i < files.length; i++) {
				File filename = files[i];
				if(filename.toString().contains("&") || filename.toString().contains("Recovery") || filename.toString().contains("System") || filename.toString().contains("Temp") || filename.toString().contains("PerLogs"))
					continue;
				else 
					System.out.println(filename.toString());
				
				Path path = Paths.get(filename.toString());
				DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(path.getFileName());
				
				treeModel = new DefaultTreeModel(subroot);
				treeModel.insertNodeInto(leaf, subroot, 0);
				
				subroot.add(leaf);
			}
		}
		files = dir1.listFiles(fileFilter1);
		if(files1.length == 0) {
			System.out.println("Either dir does not exist or iss not a directory");
		}
		else {
			for(int i = 0; i < files1.length; i++) {
				File filename1 = files1[i];
				if(filename1.toString().contains("&") || filename1.toString().contains("Recovery") || filename1.toString().contains("System") || filename1.toString().contains("Temp") || filename1.toString().contains("PerLogs"))
					continue;
				else
					System.out.println(filename1.toString());
				
				Path path1 = Paths.get(filename1.toString());
				DefaultMutableTreeNode leaf1 = new DefaultMutableTreeNode(path1.getFileName());
				
				treeModel = new DefaultTreeModel(subroot1);
				treeModel.insertNodeInto(leaf1, subroot1, 0);
				
				subroot1.add(leaf1);
			}
		}
	}
	
	public static void main(String[] args) {
		new Filemanager();
	}
}