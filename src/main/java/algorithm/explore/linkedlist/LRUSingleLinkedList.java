package algorithm.explore.linkedlist;
/**
 * 
 */
class LRUSingleLinkedList<E extends Comparable<E>>{

    private int n = 5;
    private int size = 0;
    Node<E> headNode = new Node<E>();
    Node<E> tailNode = headNode;

    public void add(Node<E> node){
        if(!findAndDelNode(node)){
            if(size<n){
                size++;
            }else{
                headNode = headNode.next;
            } 
        }
        tailNode.next = node;
        tailNode = node;
    }

    public E getRecent(){
        return tailNode.e;
    }

    private boolean findAndDelNode(Node<E> node){
        Node<E> cur = headNode;

        while(cur.next!=null){
            if(cur.next.e==node.e){
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }



    

}