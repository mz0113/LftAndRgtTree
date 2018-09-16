import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultDocument;
import com.sun.xml.internal.ws.server.ServiceDefinitionImpl;
import org.w3c.dom.Document;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    JTree jTree;
    String xml;
    public static void main(String[] args) {
      new Main().init();
    }

    private  void init() {

        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode("root","1",1,12,1));
        list.add(new TreeNode("group1","2",2,7,2));
        list.add(new TreeNode("group2","3",8,11,2));
        list.add(new TreeNode("1-1","4",3,4,3));
        list.add(new TreeNode("1-2","5",5,6,3));
        list.add(new TreeNode("2-1","6",9,10,3));
        //Test
        DefaultMutableTreeNode root = new serviceImpl().convertToTree(list);
        //Test
        xml = new serviceImpl().convertToXml(root,"item",new StringBuffer(xml = new String()));
        jTree = new JTree();
        jTree.setModel(new DefaultTreeModel(root));
        this.add(jTree);
        this.setVisible(true);
        System.out.println(xml);
    }
}