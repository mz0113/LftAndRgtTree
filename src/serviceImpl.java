import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class serviceImpl implements CRUD {
    @Override
    public DefaultMutableTreeNode convertToTree(List<TreeNode> list) {

        List<DefaultMutableTreeNode> listTemp = new ArrayList<>();
        for (TreeNode node:list) {
           DefaultMutableTreeNode javaNode  = new DefaultMutableTreeNode();
           javaNode.setUserObject(node);
           listTemp.add(javaNode);
        }
        for (DefaultMutableTreeNode defaultMutableTreeNode:listTemp) {
            if(((TreeNode)defaultMutableTreeNode.getUserObject()).lft == 1){
                findChild(listTemp,defaultMutableTreeNode);
                return defaultMutableTreeNode;
            }
        }
        return  null;
    }

    private MutableTreeNode findChild(List<DefaultMutableTreeNode> list,DefaultMutableTreeNode parent) {
        for (DefaultMutableTreeNode node:list) {
            if( ((TreeNode)node.getUserObject()).level == (((TreeNode)parent.getUserObject()).level+1)
                    &&  ((TreeNode)node.getUserObject()).lft >((TreeNode)parent.getUserObject()).lft
                    && ((TreeNode)node.getUserObject()).rgt < ((TreeNode)parent.getUserObject()).rgt
                    && ((TreeNode)node.getUserObject()).lft <((TreeNode)parent.getUserObject()).rgt
                    && ((TreeNode)node.getUserObject()).rgt > ((TreeNode)parent.getUserObject()).lft
            ){
                parent.add(findChild(list,node));
            }
        }
        return parent;
    }
}