package com.leo.mystarter;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * tree
 *
 * @author hou
 * @date 2020-01-05 11:05 上午
 */
public class TreeTest {

    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public static TreeNode BuderTree() {
            TreeNode head = new TreeNode("A");
            head.left = new TreeNode("B");
            head.right = new TreeNode("C");
            head.left.left = new TreeNode("D");
            head.left.right = new TreeNode("E");
            head.right.left = new TreeNode("F");
            head.right.right = new TreeNode("G");
            return head;
        }
    }


    public static void main(String[] args) {
        TreeNode tree = TreeNode.BuderTree();
        preOrder(tree);
        System.out.println();
        System.out.println(JSON.toJSONString(preOrder2(tree)));
        System.out.println(JSON.toJSONString(inOrder(tree)));
    }

    public static void preOrder(TreeNode root){
        if(null == root){
            return;
        }
        System.out.print(root.val+",");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * tree
     *        A
     *     B    C
     *   D  E  F  G
     *
     */
    public static List<String> preOrder2(TreeNode root){
        List<String> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(null == root){
            return list;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;
    }

    public static List<String> inOrder(TreeNode root){
        List<String> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(null == root){
            return list;
        }
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

}
