package Reglas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sanders
 */
public class Funciones {

    char a = '(';
    char b = ')';
    char d = '*';
    char e = '+';
    char f = '-';
    char g = '/';
    char h = ' ';
    char i = '{';
    char j = '}';
    char k = ';';
    char l = '[';
    char m = ']';
    char n = '=';
    char o = '\"';
    char p = '\'';
    StringBuilder tok = new StringBuilder();
    private ArrayList arreglo = new ArrayList();
    private int conta = 0;
    //char arrPat[] = new char[10];

    public void misToken(char c)
    {
      //String separador;
       
       if(!this.isDelimitador(c))
       {
           tok.append(c);
            conta++;
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
    }

    public void limpiarCodigo(String linea){
        char c;
        for(int i=0; i< linea.length();i++)
        {
            c = linea.charAt(i);
            this.misToken(c);
        }
    }

    public boolean isDelimitador(char c){
        if(c != a && c != b && c != d && c != e && c != f && c != g && c != h && c!= i && c != j
                && c != k && c != l && c != m && c!=n && c!=o && c!=p)
        {
            return false;
        }
        return true;
    }

    public void imprimirPalabras(){
        Iterator it = arreglo.iterator();
        while(it.hasNext()){
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
