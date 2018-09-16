import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

public interface CRUD {

    //就是需要构造一堆节点，然后子类添加到父类下面，将其加到treeModel中
    public DefaultMutableTreeNode convertToTree(List<TreeNode> list);
}
