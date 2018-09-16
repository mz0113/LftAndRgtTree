import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

public interface CRUD {

    /**
     * list转换为java tree，返回根节点
     */
    public DefaultMutableTreeNode convertToTree(List<TreeNode> list);

    /**
     * 将swing tree根节点转换为xml
     */
    public String convertToXml(DefaultMutableTreeNode rootNode,String leafType,StringBuffer xml);

}
