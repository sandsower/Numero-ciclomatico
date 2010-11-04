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
            conta=1;
        } else if (!this.comprobarWhitespace(c) && conta == 0) {
            tok = new StringBuilder();
            tok.append(c);
            this.arreglo.add(tok.toString());
            tok = new StringBuilder();
            conta = 1;
        } else if(!this.comprobarWhitespace(c) || c == ' ') {
            this.arreglo.add(tok.toString().trim());
            tok = new StringBuilder();
            if (!this.comprobarWhitespace(c)){
                tok.append(c);
                this.arreglo.add(tok.toString());
                tok = new StringBuilder();
            }
            conta = 0;
        }

        //String token = tok.toString();
        //Console.WriteLine("myString2 = " + myString2);
        //separador = Character.toString(c);
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

    public void imprimirPalabras() {
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

    public boolean comprobarWhitespace(char c){
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

    public void marcar(){
        ArrayList nuevoArreglo = new ArrayList();
        Iterator it = arreglo.iterator();
        boolean encontradoIf = false;
        int pasos = 0;
        int cuenta = 0;
        while (it.hasNext()) {
            pasos++;
            String linea = it.next().toString();
            String conc = "";
            if(linea.contains("if")){
                encontradoIf = true;
            }
            else if(linea.contains("{") && encontradoIf)
            {
                cuenta++;
                conc=" Inicio de ciclo #"+String.valueOf(cuenta);
                nuevoArreglo.add(linea+conc);
            }
            else if(linea.contains("}") && encontradoIf)
            {
                conc=" Fin de ciclo #".concat(String.valueOf(cuenta));
                cuenta--;
                encontradoIf = false;
                nuevoArreglo.add(linea+conc);
            }else {
            nuevoArreglo.add(linea+conc);
            }
        }
        setArreglo(nuevoArreglo);
    }
}
