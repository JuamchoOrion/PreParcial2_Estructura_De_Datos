package ListaSencillamenteEnlazada;

public class SimpleList<T> {
    Node<T> head;
    int size;

    public SimpleList() {
        head = null;
        size = 0;
    }

    public SimpleList(T data) {
        this.head = new Node<>(data);
        this.size = 1;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    public void display() {
        Node<T> currentNode = head;
        String output = "";
        while (currentNode != null) {
            output += currentNode.data;
            currentNode = currentNode.getNext();
            if (currentNode != null) {
                output += " -> ";
            }
        }
        System.out.println(output);
    }

    public void addAtAfter(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        size++;
    }

    public void addAtBefore(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("El índice no puede ser negativo.");
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> currentNode = head;
            int count = 0;
            while (currentNode != null && count < index - 1) {
                currentNode = currentNode.getNext();
                count++;
            }

            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista.");
            }

            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        size++;
    }

    // ✅ Buscar el dato en una posición i
    public T buscarEnPosicion(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.data;
    }

    // ✅ Eliminar la primera ocurrencia de un dato (por igualdad con equals)
    public void eliminar(T dato) {
        if (head == null) return;

        if (head.data.equals(dato)) {
            head = head.getNext();
            size--;
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().data.equals(dato)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            size--;
        }
    }
    /**
     * Punto 7
     * **/
    // Método público que inicia el proceso
    public void insertarDosDespuesDeSuma() {
        if (!(head.data instanceof Integer)) {
            throw new UnsupportedOperationException("La lista debe contener enteros.");
        }
        insertarRecursivo(head);
    }

    // Método recursivo auxiliar (postorden)
    private int insertarRecursivo(Node<T> actual) {
        if (actual == null) return 0;

        int sumaRestante = insertarRecursivo(actual.getNext());
        int valorActual = (Integer) actual.data;
        int sumaTotal = valorActual + sumaRestante;

        // Si el valor del nodo actual es igual a la suma total de la lista, insertamos 2
        if (valorActual == sumaTotal) {
            Node<T> nuevo = new Node<>((T) Integer.valueOf(2));
            nuevo.setNext(actual.getNext());
            actual.setNext(nuevo);
            size++;
        }

        return sumaTotal;
    }

}
