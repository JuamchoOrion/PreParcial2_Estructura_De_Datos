package cola;

import ListaSencillamenteEnlazada.Node;

public class Cola<T> {
    protected Node<T> inicial;
    protected Node<T> fin;
    protected int tamanio;

    public Cola() {
        inicial = fin = null;
        tamanio = 0;
    }

    // Insertar - Método para agregar un elemento al final de la cola
    public void encolar(T valor) {
        Node<T> newNode = new Node<>(valor);

        if (isVacia()) {
            inicial = newNode;
            fin = newNode;
        } else {
            fin.setNext(newNode);
            fin = newNode;
        }
        tamanio++;
    }

    // Eliminar y retornar el primer elemento de la cola
    public T desencolar() {
        if (isVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        T valor = inicial.getValor();
        inicial = inicial.getNext();
        tamanio--;

        // Si quedó vacía, también actualizamos fin
        if (inicial == null) {
            fin = null;
        }

        return valor;
    }

    // Ver el primer elemento sin eliminarlo
    public T verPrimero() {
        if (isVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        return inicial.getValor();
    }

    // Verifica si la cola está vacía
    public boolean isVacia() {
        return inicial == null;
    }

    public Node<T> getInicial() {
        return inicial;
    }

    public void setInicial(Node<T> inicial) {
        this.inicial = inicial;
    }

    public Node<T> getFin() {
        return fin;
    }

    public void setFin(Node<T> fin) {
        this.fin = fin;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    // Imprimir los elementos de la cola (opcional)
    public void imprimir() {
        Node<T> actual = inicial;
        while (actual != null) {
            System.out.print(actual.getValor() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }

}
