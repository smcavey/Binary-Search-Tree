class Node<T> {
    Node left;
    Node right;
    T data;
    
    public Node() {
        left = null;
        right = null;
    }

    public Node(T n) {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(Node n) { // set left node
        left = n;
    }

    public void setRight(Node n) { // set right node
        right = n;
    }

    public Node getLeft() { // get left node
        return left;
    }

    public Node getRight() { // get right node
        return right;
    }

    public void setData(T d) { // set data
        data = d;
    }

    public T getData() { // get data
        return data;
    }

}
