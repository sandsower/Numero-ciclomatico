package Reglas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sanders
 * @nota
 * Profesor, los archivos tambien estan almacenados en un repositorio en linea.
 * Para descargarlos puede entrar a la pagina https://github.com/sandsower/Numero-ciclomatico
 * Tambien se ve ahi cada cambio que se le hizo, por si quiere comprobar el procedimiento que usamos
 *
 * Atte: Victor y Carlos
 */
public class Funciones {

    StringBuilder tok = new StringBuilder();
    private ArrayList arreglo = new ArrayList();
    private int conta = 0;
    //char arrPat[] = new char[10];

    public void misToken(char c) {
        //String separador;

        if (!this.isDelimitador(c)) {
            //Va agregando caracteres cuando no sea delimitador
            tok.append(c);
            //Activamos la cuenta para saber que esta llenando una palabra
            conta = 1;
        } else //De ser un delimitador
        //Comprobamos que no sea whitespace y de que la cuenta sea 0
        if (!this.comprobarWhitespace(c) && conta == 0) {
            //Entonces agregamos el caracter a la lista de strings
            tok = new StringBuilder();
            tok.append(c);
            this.arreglo.add(tok.toString());
            //Reseteamos el acumulador de palabras
            tok = new StringBuilder();
        } else //De haber sido una palabra antes de encontrar el delimitador O
        //Si el espacio es el delimitador...
        if (!this.comprobarWhitespace(c) || c == ' ' && conta == 1) {
            //Agregamos lo que llevamos acumulado a la lista
            this.arreglo.add(tok.toString().trim());
            //Reseteamos el acumulador de palabras
            tok = new StringBuilder();
            //Comprobamos que no sea whitespace
            if (!this.comprobarWhitespace(c)) {
                //Agregamos tambien el delimitador a la lista
                tok.append(c);
                this.arreglo.add(tok.toString());
                //Reseteamos el acumulador de palabras
                tok = new StringBuilder();
            }
            //Reseteamos el indicador de palabras
            conta = 0;
        }
    }

    //Ciclo para limpiar cada linea de codigo
    public void limpiarCodigo(String linea) {
        char c;
        for (int i = 0; i < linea.length(); i++) {
            c = linea.charAt(i);
            this.misToken(c);
        }
    }

    //Iterador para imprimir las palabras
    public void imprimirPalabras() {
        //Marcamos inicios y finales de ciclo
        this.marcar();
        Iterator it = arreglo.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    /**
     * @return the arreglo
     */
    public ArrayList getArreglo() {
        return arreglo;
    }

    /**
     * @param arreglo the arreglo to set
     */
    public void setArreglo(ArrayList arreglo) {
        this.arreglo = arreglo;
    }

    //Funcion para comprobar si el char es igual a whitespace
    public boolean comprobarWhitespace(char c) {
        switch (c) {
            case '\t':
                return true;
            case '\n':
                return true;
            case ' ':
                return true;
            default:
                return false;
        }
    }

    //Funcion para marcar inicios y finales de ciclos
    public void marcar() {
        //Creamos un nuevo arreglo
        ArrayList nuevoArreglo = new ArrayList();
        //Creamos un iterador para el arreglo con el codigo limpiado
        Iterator it = arreglo.iterator();
        //Inicializamos las variables para contar secciones clave
        int cuentaIf = 0;
        int cuentaElse = 0;
        int pasos = 0;
        int cuenta = 0;
        while (it.hasNext()) {
            //Guardamos la linea a evaluar
            String linea = it.next().toString();
            //Inicializamos o reseteamos el String de concatenacion
            String conc = "";
            //Si la linea contiene else, aumentamos la cuenta de else
            if (linea.contains("else")) {
                cuentaElse++;
            }
            //Si la linea contiene if...
            if (linea.contains("if")) {
                //Agregamos el if a la linea, para evitar que se pierda mas adelante
                nuevoArreglo.add(linea + conc);
                //Aumentamos por 1 la cuenta de ifs
                cuentaIf++;
            } else //Si encontramos que la linea contiene una llave { , que la cuenta de Ifs sea mayor a 0
                //Y que la cuenta de else sea menor a la de ifs...
                if (linea.contains("{") && cuentaIf > 0 && cuentaElse < cuentaIf) {
                //Aumentamos en 1 la cuenta de ciclos
                cuenta++;
                //Asignamos al String el marcador de inicio de ciclo
                conc = " //Inicio de ciclo #" + String.valueOf(cuenta);
                //Agregamos al nuevo arreglo la linea con la concatenacion
                nuevoArreglo.add(linea + conc);
            } else //De no ser asi, comprobamos si la linea contiene una llave que cierra }
                //Y si la cuenta de ifs es mayor a 0
                //Y ademas comprobamos que el siguiente valor NO sea else
                if (linea.contains("}") && cuentaIf > 0 && !arreglo.get(pasos + 1).toString().contains("else")) {
                //Creamos el String de concatenacion con el que marcamos como final de ciclo esa linea
                conc = " //Fin de ciclo #".concat(String.valueOf(cuenta));
                //Disminuimos en 1 la cuenta de ciclos
                cuenta--;
                //Disminuimos en 1 la cuenta de ifs
                cuentaIf--;
                //Si la cuenta de else es diferente de 0 (mayor)...
                if (cuentaElse != 0) {
                    //Disminuimos en 1 la cuenta de else
                    cuentaElse--;
                }
                //Y agregamos la linea con su String concatenado
                nuevoArreglo.add(linea + conc);
            } else //Si no se cumple ninguna de las clausulas anteriores...
            {
                //Simplemente agregamos la linea al nuevo arreglo
                nuevoArreglo.add(linea + conc);
            }
            //Aumentamos el numero de pasos en 1
            pasos++;
        }
        //Al finalizar el ciclo, sobreescribimos el arreglo antiguo con el nuevo (marcado)
        this.setArreglo(nuevoArreglo);
    }

    //Comprobamos si el valor es delimitador
    public boolean isDelimitador(char c) {

        switch (c) {
            case '(':
                return true;

            case ')':
                return true;

            case '*':
                return true;

            case '+':
                return true;

            case '-':
                return true;

            case '/':
                return true;

            case ' ':
                return true;

            case '{':
                return true;

            case '}':
                return true;

            case ';':
                return true;

            case '[':
                return true;

            case ']':
                return true;

            case '=':
                return true;

            case '#':
                return true;

            case '<':
                return true;

            case '>':
                return true;

            default:
                return false;
        }
    }
}
