package org.example;

import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.function.Consumer;

public class Optionals {
    static String nombre;
    public static void main(String[] args) {
        //Optional<List<String>> optionalNames = getOptionalNames();
        //Consumer<List<String>> fillerTable = Optionals::fillTable;
        //optionalNames.ifPresent(fillerTable);
        /*
        * El optional se debe de usar para información que se RETORNA, solamente será el resultado de una función
        *
        * Esto es una demostración un poco pocha de cómo puede ser utilizado el optional
        * estoy seguro qué tendría que hacer un chingo de cambios, pero de momento esta me parece
        * la manera correcta no estoy muy seguro
        * */

        Optional<String> mostValuablePlayer = optionalValuablePlayer();
        Consumer<String> guardarEnTxt = Optionals::guardar;
        mostValuablePlayer.ifPresent(guardarEnTxt);
        System.out.println(nombre);
        /*
        * Aqui hace
        * */
    }
    static Optional<List<String>> getOptionalNames(){
        List<String> list = new LinkedList<>();
        return Optional.of(list);
    };
    static DefaultTableModel fillTable(List listTable){
        String [] headers = {"Name","Lastname", "Salary"};
        /*
        * Código para llenar una tabla con una lista list chatgpt
        *
        * */
        DefaultTableModel dtm = new DefaultTableModel();
        return dtm;
    };
    static void guardar(String dato){
        nombre = dato;
    }

    static Optional<String> optionalValuablePlayer(){
        try{
            // Acceso a la base de datos
            //String [] co = {"23","123"};
            //String pop = co[2];
            return Optional.of("Slutty Pumpkin");
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
