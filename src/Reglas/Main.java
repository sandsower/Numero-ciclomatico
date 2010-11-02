package Reglas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Raúl Valadez Romo
 */
public class Main {
                
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
            Funciones funciones=new Funciones();
            File f = new File( "e:/IS/src/reglas/Funciones.java" );
            System.out.println(f.length());
            BufferedReader entrada = null;
            try
            {
                entrada = new BufferedReader( new FileReader( f ) );
                String linea;
                char c;
                while(entrada.ready())
                {
                    linea = entrada.readLine();
                    //System.out.println(linea);
                    funciones.limpiarCodigo(linea);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                ArrayList palabras = funciones.getArreglo();
                funciones.imprimirPalabras();
            try
            {
                entrada.close();
            }
            catch(IOException e1){}
            }
   }


}
