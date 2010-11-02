package Reglas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sanders
 */
public class Funciones {

    StringBuilder tok = new StringBuilder();
    private ArrayList arreglo = new ArrayList();
    private int conta = 0;
    //char arrPat[] = new char[10];

    public void misToken(char c) {
        //String separador;

        if (!this.isDelimitador(c)) {
            tok.append(c);
            conta++;
<<<<<<< HEAD
       } else if(conta > 0) {
            this.arreglo.add(tok.toString());
            if(c != h){
                tok = new StringBuilder();
                tok.append(c);
                this.arreglo.add(tok.toString());
                c = ' ';
            }
            tok = new StringBuilder();
            conta = 0;
       } 
       
       if(c != h) {
            tok = new StringBuilder();
            tok.append(c);
            this.arreglo.add(tok.toString());
       }

       //String token = tok.toString();
       //Console.WriteLine("myString2 = " + myString2);
       //separador = Character.toString(c);
=======
        } else {
            if (conta > 0) {
                this.arreglo.add(tok.toString());
                tok = new StringBuilder();
                conta = 0;
            }
        }

        //String token = tok.toString();
        //Console.WriteLine("myString2 = " + myString2);
        //separador = Character.toString(c);
>>>>>>> ciclomatico/master
    }

    public void limpiarCodigo(String linea) {
        char c;
        for (int i = 0; i < linea.length(); i++) {
            c = linea.charAt(i);
            this.misToken(c);
        }
    }

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

            case '\"':
                return true;

            case '\'':
                return true;

            default:
                return false;
        }
    }

    public void imprimirPalabras() {
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
}
