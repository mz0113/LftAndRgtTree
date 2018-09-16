public class TreeNode {
    String name;
    String id;
    int lft;
    int rgt;

    public TreeNode(String name, String id, int lft, int rgt, int level) {
        this.name = name;
        this.id = id;
        this.lft = lft;
        this.rgt = rgt;
        this.level = level;
    }

    int level;

    @Override
    public String toString(){
        return this.name;
    }
}
