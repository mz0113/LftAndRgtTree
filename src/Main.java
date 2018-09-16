import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    JTree jTree;

    public static void main(String[] args) {
      new Main().init();
    }

    private  void init() {

        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode("root","1",1,12,1));
        list.add(new TreeNode("gr1","2",2,7,2));
        list.add(new TreeNode("gr2","3",8,11,2));
        list.add(new TreeNode("gr1-1","4",3,4,3));
        list.add(new TreeNode("gr1-2","5",5,6,3));
        list.add(new TreeNode("gr2-1","6",9,10,3));
        DefaultMutableTreeNode root = new serviceImpl().convertToTree(list);
        jTree = new JTree();
        jTree.setModel(new DefaultTreeModel(root));
        this.add(jTree);
        this.setVisible(true);
    }
}