package Tree.tree;

public class BinaryTree {
    Node root;

    public BinaryTree(int data) {
        this.root = new Node(data);
    }

    //for delete node
    public Node findReplace(Node root , int data) {
        Node node = new Node(data);
        if(this.root==null)
            return null;

        if(this.root.data==node.data)
            return root;
        else if(node.data<root.data){
            return findReplace(root.left , data);
        }
        else {
            return findReplace(root.right , data);
        }
    }
    public boolean isLeaf(Node node){
        if(node.left==null && node.right==null){
            return true;
        }
        else return false;
    }
    public void free(Node node){
        node.right=null;
        node.left=null;
        node.data=-1;
    }
    public Node delete(Node root , int data){

        if(root == null){
            return root;
        }
         if(root.data<data){
             root.right =  delete(root.right,data);
             return root;
         } else if (root.data > data) {
             root.left = delete(root.left , data);
             return root;
         }

         if(root.left==null){
             Node temp = root.right;
             return temp;
         } else if (root.right == null) {
             Node temp = root.left;
             return temp;
         }

         else {
             Node succparent = root;
             Node succ = root.right;
             while(succ.left!=null){
                 succparent=succ;
                 succ=succ.left;
             }
             if(succparent!=root){
                 succparent.left=succ.right;
             }
             else {
                 succparent.right=succ.right;
             }
             root.data = succ.data;
             return root;
         }

    }

    void deleteEBI(Node root){
        if(isLeaf(root)){
            free(root);
            return;
        }
        Node p = findReplace(root , root.data);
        root.data = p.data;
        deleteEBI(p);
    }

    public Node search(Node root , int x){
        if(root == null){
            return null;
        }
        else if(root.data == x){
            return root;
        }
        else if(root.data < x){
           return search(root.left,x);
        }
        else {
            return search(root.right,x);
        }
    }

    public void insert(int data){
        insertBST(this.root,data);
    }
    public Node insertBST(Node root , int x){
        Node new_node = new Node(x);
        if(root==null){
            root=new_node;
            return root;
        }
        else if(new_node.data< root.data){
            root.left=insertBST(root.left,x);
        }
        else if(new_node.data> root.data) {
            root.right=insertBST(root.right, x);
        }
    return root;
    }
    public void inOrderR(Node root){
        if(root==null){
            return;
        }
        else {
            inOrderR(root.left);
            System.out.print(root.data + " ");
            inOrderR(root.right);
        }
    }



    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(13);
       tree.insert(15);
        tree.insert(11);
        tree.insert(18);
        tree.insert(21);
        tree.insert(1);
        tree.insert(3);
        Node del=new Node(19);
        tree.insert(del.data);

        tree.delete(tree.root,15);
        System.out.print("InOrder :"+ "\t");
        tree.inOrderR(tree.root);

    }
}
