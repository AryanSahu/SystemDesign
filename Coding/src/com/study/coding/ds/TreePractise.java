package com.study.coding.ds;

import java.util.*;

public class TreePractise {



    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public Node prepareDataSet(){

        Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        return root;

    }


    public static void main(String[] args) {

        TreePractise obj=new TreePractise();
        Node root1= obj.prepareDataSet();
        Node root2= obj.prepareDataSet();

        //root2.right.right.data=88;


        System.out.println(isSame(root1,root2));

    }


    // K Smallest Elemnt
    public void KSmallestElementBST(Node root,List<Integer> list)
    {
     if(root==null)
     return ;

     KSmallestElementBST(root.left,list);
     list.add(root.data);
     KSmallestElementBST(root.right,list);


    }

    public static boolean isBST(Node root, int min, int max)
    {
        if (root == null)
            return true;

        return ( root.data>min && root.data<max &&
                isBST(root.left,min,root.data) && isBST(root.right,root.data,max));
    }

    public int countGoodNodes(Node root,int max)
    {
        if(root==null)
            return 0;

       int count= root.data>max?1:0;
       count=count+countGoodNodes(root.left,Math.max(root.data,max));
        count=count+countGoodNodes(root.right,Math.max(root.data,max));

    return count;

    }


// O (N)
    public void rightSideView(Node node)
    {
        if(node==null)
            return;

        Queue<Node> queue=new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty())
        {

            int size=queue.size();

            for(int i=0;i<size;i++)
            {
                Node element=queue.poll();

                if(i==size-1)
                {
                    System.out.println(element.data);
                }
            }



        }

    }


    // the Level Order Traversal algorithm has a runtime complexity of O(n).
    public void LOT(Node root)
    {

        if(root==null)
            return;

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            Node element=queue.poll();

            System.out.println(element.data);

            if(element.left!=null)
            {
                queue.add(element.left);
            }

            if(element.right!=null)
            {
                queue.add(element.right);
            }


        }


    }


    // LCA of a Binary tree

    // Conditions
    //1. Root may be equal to N1, or N2
    //2. N1,N2 may be present in either one side of the subtrees
    //3. N1,N2 may be present in both the sides of the subtree


    public Node LCA_Binary_Tree(Node root,int n1,int n2)
    {
        if(root==null)
            return null;


        //condition 1
        if(root.data==n1 || root.data==n2)
            return root;

        Node left=LCA_Binary_Tree(root.left,n1,n2);
        Node right=LCA_Binary_Tree(root.right,n1,n2);


        // condition 2
        if(left==null)
            return right;

        if(right==null)
            return left;


        //condition 3
        return root;

    }

//The time complexity of the provided algorithm to find the Lowest Common Ancestor (LCA) in a Binary Search Tree (BST) is O(h), where "h" is the height of the tree.
//In case the tree is skewed , the TC is O (N)
public Node LCA_BST(Node root,Node n1,Node n2) {
    if (root == null)
        return null;

    if (n1.data < root.data && n2.data < root.data) {
        return LCA_BST(root.left, n1, n2);
    }


    if (n1.data > root.data && n2.data > root.data) {
        return LCA_BST(root.right, n1, n2);
    }

    return root;

}



    public boolean isSubTree(Node root,Node subtree)
    {
        if(root==null)
        {
            return false;
        }

        if(subtree==null || isSame(root,subtree))
            return true;


        return isSubTree(root.left,subtree) || isSubTree(root.right,subtree);



    }


    public static boolean isBalanced(Node root)
    {
        if(root==null)
            return true;

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        if((Math.abs(leftHeight-rightHeight)<=1)&& isBalanced(root.left) && isBalanced(root.right))
            return true;

        return false;
    }



    /*

   The time complexity of the provided code for calculating the diameter of a binary tree is O(n^2), where "n" is the number of nodes in the binary tree. Let's break down the reasons for this complexity:

Each node is being visited multiple times: In the code, for each node, the height function is called, which in turn traverses the subtree rooted at that node to calculate the height. This results in a traversal of the entire subtree rooted at each node.

Recursive calls: The code has recursive calls to calculate the diameter of the left and right subtrees, as well as recursive calls for the height calculations. This leads to repeated work for many nodes.

Due to these factors, the overall complexity becomes O(n^2), as the work done for each node can potentially be proportional to the number of nodes in the tree, resulting in a quadratic time complexity.
    */
    public int diameterOfBinaryTree(Node root) {

        if(root==null)
            return 0;

        int left=height(root.left);
        int right=height(root.right);

        int leftdiameter=diameterOfBinaryTree(root.left);
        int rightdiameter=diameterOfBinaryTree(root.right);

        int maxDiameter=Math.max(left+right+1,Math.max(leftdiameter,rightdiameter));

        return maxDiameter;

    }



    // O(N)
    public static boolean isSame(Node root1,Node root2)
    {
        if(root1==null && root2==null)
            return true;


        if(root1==null || root2==null)
            return false;

        if(root1.data!=root2.data)
            return false;



        return isSame(root1.left,root2.left)&& isSame(root1.right,root2.right);


    }




    // TC is O(N)

    //SC O(H) / O(Log(n))
    public static int maxDepth(Node root)
    {
        if(root==null)
            return 0;

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return Math.max(left,right)+1;
    }


    // TC O(N)  The overall time complexity can be expressed as O(n), where "n" is the number of nodes in the tree.

    //In a balanced binary tree, the height is typically closer to log(n), resulting in a space complexity of O(log n).

    //SC The space complexity of this function is also O(n), as the maximum space required by the call stack during the recursive calls is proportional to the height of the tree, which can be at most "n" in a skewed tree.
    public Node invertTree(Node root)
    {
        if(root==null)
            return null;

        Node newNode=new Node(-1);
        newNode.left=invertTree(root.right);
        newNode.data=root.data;
        newNode.right=invertTree(root.left);

        return newNode;
    }






    // find max node in BT
    public static int getMax(Node root){
        if(root==null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.data,Math.max(getMax(root.left),getMax(root.right)));
    }



    public static void zigZag(Node root)
    {
        int levelCounter=1;
        Queue<Node> queue=new LinkedList<>();
        Stack<Node> stack=new Stack<>();

        // presuming we are starting from queue
        queue.add(root);

        boolean isReverse=true;

        List<Integer> list=new ArrayList<>();
        list.add(queue.peek().data);



        while (!queue.isEmpty())
        {

            Node node=queue.poll();

                  if (isReverse) {
                      if (node.right != null) {
                          list.add(node.right.data);
                      }

                      if (node.left != null) {
                          list.add(node.left.data);
                      }


                  } else {

                      if (node.left != null) {
                          list.add(node.left.data);
                      }
                      if (node.right != null) {
                          list.add(node.right.data);
                      }


                  }


                  if (node.left != null) {
                      queue.add(node.left);
                  }
                  if (node.right != null) {
                      queue.add(node.right);
                  }



                      isReverse = !isReverse;





        }

        System.out.println(list);



    }


    public static void printLeftView(Node root)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size=queue.size();

            for(int i=0;i<size;i++)
            {
                Node node=queue.poll();
                if(i==0)
                {
                    System.out.println(node.data);
                }

                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }

            }

           }


    }










    private static void rightViewOfTree() {
        TreePractise obj=new TreePractise();
        Node root= obj.prepareDataSet();

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size= queue.size();

            for(int i=0;i<size;i++)
            {
                Node element=queue.poll();
                if(i==size-1)
                {
                    System.out.println(element.data);
                }
                if(element.left!=null)
                {
                    queue.add(element.left);
                }

                if(element.right!=null)
                {
                    queue.add(element.right);
                }

            }



        }
    }

    public boolean isSubtree(Node root, Node subRoot) {

        if(subRoot==null ||isSameTree(root,subRoot) )
            return true;

        if(root==null)
            return false;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }


    public boolean isSameTree(Node p, Node q) {

        if(p==null && q==null)
            return true;

        if(p==null || q==null)
            return false;

        if(p.data!=q.data)
            return false;

        return isSameTree(p.left,q.left) && isSameTree(q.right,p.right);

    }



    //maximum depth
    public static int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }

        return Math.max(height(root.left),height(root.right))+1;

    }

    // Inorder (Left | Root | Right)
    public static void  traverseTreeInorder(Node root)
    {
        if(root!=null)
        {
            traverseTreeInorder(root.left);
            System.out.println(root.data);
            traverseTreeInorder(root.right);

        }

    }


    // Level Order Traversal
    public static void  traverseTreeLevelOrder(Node root)
    {

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            Node element=queue.poll();
            System.out.println(element.data);
            if(element.left!=null)
            {
                queue.add(element.left);
            }

            if(element.right!=null)
            {
                queue.add(element.right);
            }

        }


    }


}
