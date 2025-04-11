import ListaSencillamenteEnlazada.SimpleList;
import PilaP.Pila;
import cola.Cola;
import persona.Persona;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**Cree un método que reciba como parámetro una Lista Simple y retorne la misma Lista, pero invertida, use Pilas.
     * **/
    public static void main(String[] args) {
    /**
     * Punto 7
     * **/
        SimpleList<Integer> lista = new SimpleList<>();
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(6);

        lista.display();
        lista.insertarDosDespuesDeSuma();
        lista.display();
    }
    public <T> SimpleList<T> invertir(SimpleList<T> lista) {
        Pila<T> pila = new Pila<>();
        //Recorrer la lista 1 a 1 e ir agregando a la pila despues hacer pop hasta que la pila esté vacía
        for (int i = 0; i < lista.getSize(); i++) {
            pila.push(lista.buscarEnPosicion(i));
            lista.eliminar(lista.buscarEnPosicion(i));
        }
        for (int i = 0; i < pila.getTamano(); i++) {
            lista.addFirst(pila.pop());
        }
        return lista;
    }
    /**
     * Punto 3
     * Dada una cola de Personas eliminar los hombres con endad >30 && <50**/
    public  Cola<Persona> encolar(Cola<Persona> cola) {
        //la cola auxiliar va a contener solo los q no cumplan la condicion
        Cola<Persona> aux = new Cola();
        while(!cola.isVacia()){
            Persona p = cola.desencolar();
            if(!(p.getSexo().equals("M") && p.getEdad()>30 && p.getEdad()<=50))   {
                aux.encolar(p);
            }
        }
        return aux;
    }
    /**
     * Punto 5
     * Dada una cadena de caracteres determinar si la cantidad de parentesis es correcta
     *
     **/
    /***
     * 1. leer valores de entrada
     * 2. por cada parentesis abierto debe existir uno cerrad
     * 3. contador de parentesis abiertos
     * 4. apilar en orden
     * 5.contador de parentesis al cerrar
     * **/
    public boolean verificarCorchetes(String entrada) {

        Pila pila = new Pila();
        int contadorabiertos = 0;
        Map<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < entrada.length(); i++) {
            Character c = entrada.charAt(i);
            if(c.equals('(')||c.equals('[')||c.equals('{')) {
                pila.push(c);
            }
            else if(c.equals(')')||c.equals(']')||c.equals('}')) {
                pila.pop();
            }

        }

        if(pila.getTamano()==0){
            return true;
        }

        return false;

    }
}