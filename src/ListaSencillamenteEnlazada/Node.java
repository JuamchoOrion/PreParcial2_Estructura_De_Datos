package ListaSencillamenteEnlazada;

public class Node <T>{
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public T getValor() {
        return data;
    }
}

