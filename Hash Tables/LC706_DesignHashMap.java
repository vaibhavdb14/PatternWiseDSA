class LC706_DesignHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    Node[] buckets;

    public LC706_DesignHashMap() {
        buckets = new Node[1000];

    }

    public void put(int key, int value) {
        int index = key % 1000;
        if(buckets[index] == null){
           buckets[index] = new Node(key, value);
           return;
        }

        Node current = buckets[index];
        while(true){
            if(current.key == key){
                current.value = value;
                return;
            }

            if(current.next == null){
                current.next = new Node(key, value);
                return;
            }

            current = current.next;
        }
    }

    public int get(int key) {
        int index = key % 1000;

        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;

    }

    public void remove(int key) {
        int index = key % 1000;
        if (buckets[index] == null) {
            return;
        }

        if (buckets[index].key == key) {
            buckets[index] = buckets[index].next;
            return;
        }

        Node current = buckets[index];

        while (current.next != null) {
            if (current.next.key == key){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LC706_DesignHashMap hashMap = new LC706_DesignHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));  // returns 1 
        System.out.println(hashMap.get(3));  // returns -1 (not found)
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));  // returns 1
        hashMap.remove(2);
        System.out.println(hashMap.get(2));  // returns -1 (not found)
    }
}

/**
 * Leetcode Problem 706: Design HashMap
 * link: https://leetcode.com/problems/design-hashmap/
 * 
 * Time Complexity: O(1) average case, O(n) worst case
 * Space Complexity: O(n)
 * 
 * Approach:
 * 1. Create a Node class to represent each key-value pair in the HashMap.
 * 2. Use an array of Node objects as buckets to store the key-value pairs.
 * 3. Implement the put, get, and remove methods to handle key-value pairs in the HashMap.
 * 
 * put() :
 *   - Calculate the index of the bucket using the key modulo the number of buckets.
 *  - If the bucket is empty, create a new Node and assign it to the bucket.
 * - If the bucket is not empty, traverse the linked list to find the key. If found, update the value; if not found, add a new Node at the end of the list.
 * 
 * get() :
 *  - Calculate the index of the bucket using the key modulo the number of buckets.
 * - Traverse the linked list in the bucket to find the key. If found, return the value; if not found, return -1.
 * 
 * remove() :
 *  - Calculate the index of the bucket using the key modulo the number of buckets.
 * - If the bucket is empty, return.
 * - If the key is found at the head of the linked list, update the head to the next node.
 * - If the key is found in the linked list, update the next pointer of the previous node to skip the node with the key.
 */