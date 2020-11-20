public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(); // initialize new bst
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // sorted array
        bst.convertArrayToBinarySearchTree(arr); // convert array to bst
        System.out.println(bst.search(4)); // search for 4, true if found
        System.out.println(bst.insert(11)); // insert 11, true if inserted
        System.out.println(bst.search(15)); // search for 15, true if found
        System.out.println(bst.delete(19)); // delete 19, true if deleted
        System.out.println(bst.insert(11)); // insert 11, true if inserted
        System.out.println(bst.insert(12)); // insert 12, true if inserted

    }
}
