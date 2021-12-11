package linkedlist.lruCache146;


import linkedlist.ListNode;

import java.util.HashMap;

/**
 * Medium
 */
public class LRUCache {

    private int size;
    private int maxSize;
    private final HashMap<Integer, DListNode> nodeMap;
    private final DListNode head;
    private final DListNode tail;

    private static class DListNode{
        int key;
        int val;
        DListNode pre;
        DListNode next;

        public DListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }



    public LRUCache(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity can not negative");
        this.maxSize = capacity;
        nodeMap = new HashMap<>(capacity * 2);
        head = new DListNode(-1, -1);
        tail = new DListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DListNode node = nodeMap.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {

       DListNode node = nodeMap.get(key);
       if (node == null){

           DListNode newNode = new DListNode(key, value);
           nodeMap.put(key, newNode);
           addToHead(newNode);
           size++;
           if (size > maxSize){

               DListNode tail = removeTail();
               nodeMap.remove(tail.key);
               size--;
           }

       }else {
           node.val = value;
           moveToHead(node);
       }
    }

    private void addToHead(DListNode node){
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DListNode node){
        removeNode(node);
        addToHead(node);
    }
    private DListNode removeTail(){
        DListNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void removeNode(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}
