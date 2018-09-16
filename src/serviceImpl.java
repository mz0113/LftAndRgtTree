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

    @Override
    public String convertToXml(DefaultMutableTreeNode rootNode,String leafType,StringBuffer xml) {
                String space = "";
                //做自动缩进
                for(int i = rootNode.getPath().length; i>1; i --)
                {
                    space = space+"    ";
                }
                if(rootNode.isLeaf())
                {
                    //如果是叶子节点，则直接写入文件； leaftype是我自己的需要指定叶子节点在xml中的属性，不需要的可以删除该参数；
                    xml.append(space+"<"+leafType+">\r\n");
                    String[]testCase = rootNode.toString().split("\n");
                    for(int i =0;i<testCase.length;i++)
                    {
                        xml.append(space+"    "+testCase[i]+"\r\n");
                    }
                    xml.append(space+"</"+leafType+">\r\n");
                }
                else{
                    //不是叶子节点，则递归遍历；
                    xml.append(space + "<"+rootNode.toString()+">\r\n");
                    for(int i = 0; i<rootNode.getChildCount(); i++)
                    {
                        DefaultMutableTreeNode childeNode = (DefaultMutableTreeNode)rootNode.getChildAt(i);
                        convertToXml(childeNode, leafType, xml);
                    }
                    xml.append(space + "</"+rootNode.toString()+">\r\n");
                }
                return xml.toString();
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