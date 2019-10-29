public class Map<K extends Comparable<K>, V> implements MapInterface<K, V>{

    private Node root;

    public Map() {
        root = null;
    }

    public void setValue(K key, V value) {
        if(getNode(key) != null)
            return;

        insert(key, value);

        Node current = getNode(key);
        Node uncle;

        while(current != root && current.parent.color) {
            if(current.parent == current.parent.parent.left) {
                uncle = current.parent.parent.right;
                if(uncle != null && uncle.color) {
                    current.parent.color = false;
                    uncle.color = false;
                    current.parent.parent.color = true;
                    current = current.parent.parent;
                }
                else if(current == current.parent.right) {
                    current = current.parent;
                    leftRotate(current);
                }
                else {
                    current.parent.color = false;
                    current.parent.parent.color = true;
                    rightRotate(current.parent.parent);
                }
            }
            else {
                uncle = current.parent.parent.left;
                if(uncle != null && uncle.color) {
                    current.parent.color = false;
                    uncle.color = false;
                    current.parent.parent.color = true;
                    current = current.parent.parent;
                }
                else if(current == current.parent.left) {
                    current = current.parent;
                    rightRotate(current);
                }
                else {
                    current.parent.color = false;
                    current.parent.parent.color = true;
                    leftRotate(current.parent.parent);
                }
            }
        }

        root = getNode(key);

        while(getParent(root) != null)
            root = getParent(root);

        root.color = false;
    }

    public V getValue(K key) {
        Node current = root;
        while(current != null) {
                if (key.compareTo(current.key) < 0)
                    current = current.left;
                else if(key.compareTo(current.key) > 0)
                    current = current.right;
                else
                    return current.value;
        }
        return null;
    }

    public void clear() {
        root = null;
    }

    private Node getParent(Node x) {
        return x == null ? null : x.parent;
    }

    public Node getNode(K key) {
        Node current = root;
        while(current != null && key != current.key) {
            if(key.compareTo(current.key) < 0)
                current = current.left;
            else
                current = current.right;
        }
        return current;
    }

    private void insert(K key, V value) {
        Node newbie = new Node(key, value);

        Node parent = null;
        Node current = root;

        while(current != null) {
            parent = current;
            if(key.compareTo(current.key) < 0)
                current = current.left;
            else if(key.compareTo(current.key) > 0)
                current = current.right;
            else
                return;
        }
        newbie.parent = parent;

        if(parent == null)
            root = newbie;
        else if(newbie.key.compareTo(parent.key) < 0)
            parent.left = newbie;
        else
            parent.right = newbie;
    }

    private void leftRotate(Node x) {
        Node father = x;

        if(father.right == null)
            return;

        Node son = father.right;
        father.right = son.left;

        if(son.left != null)
            son.left.parent = father;

        son.parent = father.parent;

        if(father.parent == null)
            root = son;
        else if(father == father.parent.left)
            father.parent.left = son;
        else
            father.parent.right = son;

        son.left = father;
        father.parent = son;
    }

    private void rightRotate(Node x) {
        Node father = x;

        if(father.left == null)
            return;

        Node son = father.left;
        father.left = son.right;

        if(son.right != null)
            son.right.parent = father;

        son.parent = father.parent;

        if(father.parent == null)
            root = son;
        else if(father == father.parent.right)
            father.parent.right = son;
        else
            father.parent.left = son;

        son.right = father;
        father.parent = son;
    }

    class Node {
        private K key;
        private V value;
        private boolean color; //true == red, false == black
        private Node left;
        private Node right;
        private Node parent;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            color = true;
            left = null;
            right = null;
            parent = null;
        }

        boolean getColor() {
            return color;
        }

    }
}
