package Tree.tree;

public class Tree {

    public Node newNode(int data){
        Node node = new Node(data);
        return node;
    }

    public int nodeCount(Node root){
        if(root==null){
            return 0;
        }
        return (1+ nodeCount(root.left) + nodeCount(root.right));
    }


    //number of single child node
    public int nodeSChildCount(Node root){
        if(root==null){
            return 0;
        }
        if((root.right==null && root.left!=null) || ( root.right !=null && root.left == null)){
            return 1;
        }
        return nodeSChildCount(root.left) + nodeSChildCount(root.right);
    }

    public int leafCount(Node root){
        if(root==null)
            return 0;

        if(root.right==null && root.left==null){
            return 1;
        }
        else
            return leafCount(root.left) + leafCount(root.right);
    }

    public boolean full(Node root , int i , int n){
        if(root == null){
            return true;
        }
        if(i>n){
            return false;
        }
        return (full(root.left,2*i,n) && full(root.right , (2*i)+1 , n));
    }

    //Delete  single child node
    public Node deleteNSChild(Node root){
        if(root==null){
            return null;
        }
        root.left= deleteNSChild(root.left);
        root.right= deleteNSChild(root.right);

        if(root.left==null && root.right == null){
            return root;
        }
        if(root.left==null){
            Node newRoot = root.right;
            root.right=null;
            return newRoot;
        }
        if(root.right==null){
            Node newRoot = root.left;
            root.left=null;
            return newRoot;
        }
        return root;
    }

    public Node search(Node root , int x){
        if(root==null){
            return null;
        }
        else if(root.data==x){
            return root;
        }
        else if(root.data<x){
            return search(root.left,x);
        }
        else {
            return search(root.right,x);
        }
    }

    public void postOrderR(Node root){
        if(root==null){
            return;
        }
        postOrderR(root.left);
        postOrderR(root.right);
        System.out.print(root + "\t");

    }
    public void inOrderR(Node root){
        if(root==null){
            return;
        }
        inOrderR(root.left);
        System.out.print(root + "\t");
        inOrderR(root.right);
    }
    public void preOrderR(Node root){
        if(root==null){
            return;
        }
        System.out.print(root + "\t");
        preOrderR(root.left);
        preOrderR(root.right);
    }

    public void preOrder(Node root){

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.newNode(12);
        root.left = tree.newNode(10);
        root.right = tree.newNode(14);
        root.left.left = tree.newNode(16);
        root.left.right = tree.newNode(18);
        root.right.right = tree.newNode(13);
        System.out.println(tree.leafCount(root));
        tree.deleteNSChild(root);
        System.out.println(tree.nodeCount(root));


    }
}
class Node {
    int data;
    Node left , right;
    public Node(int data) {
        this.data = data;
        left=null;
        right=null;
    }
}
