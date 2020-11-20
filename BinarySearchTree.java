import java.util.*;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;
    static final int COUNT = 12;

    private Comparator<T> comparator;

    public BinarySearchTree() {
        root = null;
        size = 0;
        comparator = null;
    }

    public int Size() {
        return size;
    }

    private int compare(T x, T y) {
        if (comparator == null) {
            return x.compareTo(y);
        }
        return comparator.compare(x, y);

    }

    public boolean insert(T data) {
        if (this.search(data)) {
            return false;
        }
        root = insert_util(root, data);
        size++;
        return true;
    }

    private Node insert_util(Node<T> node, T data) {
        //   if(node != null)
        // System.out.println(compare(node.getData(), data));
        // if tree is empty
        if (node == null) // create a new node
        {
            node = new Node<T>(data);
        } // if the dat lies in the right subtree
        else if (compare(node.getData(), data) < 0) {
            node.setRight(insert_util(node.getRight(), data));
        } // if the dat lies in the left subtree
        else {
            node.setLeft(insert_util(node.getLeft(), data));
        }
        return node;
    }

    public boolean search(T val) {
        return search_util(this.root, val);
    }

    // search an element in the tree
    private boolean search_util(Node<T> r, T val) {
        if (r == null) {
            return false;
        } else if (compare(val, r.data) == 0) {
            return true;
        } else if (compare(val, r.data) < 0) {
            return search_util(r.left, val);
        } else {
            return search_util(r.right, val);
        }
    }

    // get the node with minimum value
    public Node<T> getMin(Node<T> x) {
        // moke trav point to the root of the tree
        Node trav = x;
        // go tp the node at the extreme left
        while (trav.getLeft() != null) // move to the left child
        {
            trav = trav.getLeft();
        }
        return trav;
    }

    public boolean delete(T data) { // returns true if node is deleted, else false
        boolean found = search_util(root, data);
        // if data is not present in the tree
        if (found == false) {
            return found;
        }
        Node temp = root;
        root = delete_util(temp, data);
        size--;
        return true;
    }

    // delete the given node
    Node<T> delete_util(Node<T> x, T key) {
        // if the tree is empty
        if (x == null) {
            return null;
        }
        // if the required node lies in the left subtree
        //if (key < x.getData())
        if (compare(key, x.getData()) < 0) // recursively call the function on the left subtree
        {
            x.setLeft(delete_util(x.getLeft(), key));
        } // if the required node lies in the right subtree
        //else if (key > x.getData())
        else if (compare(key, x.getData()) > 0) // recursively call the function on the right subtree
        {
            x.setRight(delete_util(x.getRight(), key));
        } // if the node to be deleted is found
        else {
            // left child is not present
            if (x.getLeft() == null) {
                return x.getRight();
            } // right child is not present
            else if (x.getRight() == null) {
                return x.getLeft();
            }
            // no child is present
            // get the node with the minimum value
            Node<T> trav = getMin(x.getRight());
            // content of inorder successor is set to this node
            x.setData(trav.getData());
            // inorder successor is removed
            x.setRight(delete_util(x.getRight(), trav.getData()));
        }
        return x;
    }

    public void reset() {
        root = null;
        size = 0;
    }

    public int height() {
        return getHeight(root);
    }

    // get the height of the tree
    public int getHeight(Node<T> x) {
        // if tree is empty
        if (x == null) {
            return 0;
        } else {
            // calculate height of right subtree
            int r = getHeight(x.getRight());
            // calculate height of left subtree
            int l = getHeight(x.getLeft());
            // if the height of left subtree is larger
            if (l > r) {
                return (l += 1);
            }
            // if the height of right subtree is larger
            return (r += 1);
        }
    }

    public void convertArrayToBinarySearchTree(int[] array) {
        this.root = this.convertArrayToBinarySearchTreeUtil(array, 0, array.length - 1);
    }

    // p is the left bound index
    // r is the right bound index
    public Node convertArrayToBinarySearchTreeUtil(int[] array, int l, int r) {
        if (l <= r) {
            // calculate the index of middle element
            int mid = (l + r) / 2;
            // create a new node with the middle element as the value
            Node x = new Node(array[mid]);
            // recursively build the left subtree
            x.setLeft(this.convertArrayToBinarySearchTreeUtil(array, l, mid - 1));
            // recursively build the right subtree
            x.setRight(this.convertArrayToBinarySearchTreeUtil(array, mid + 1, r));
            return x;
        } else {
            return null;
        }
    }
  
}
