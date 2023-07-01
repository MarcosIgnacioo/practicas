package org.example.Employment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EmployeeRegistration {
    static int idRegistrarEmpleado = 1;
    /*
        Crea un programa que simule un sistema de registro de empleados.
        El programa debe permitir ingresar los datos de un empleado,
        validarlos utilizando Predicate, almacenarlos en una estructura
        de datos adecuada y luego mostrar la información utilizando
        Consumer y Supplier.*/
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        List<Employee> listaEmpleados = new ArrayList<>();

        Predicate<Integer> isEmpleado = empleadoId -> {
            for (Employee empleado : listaEmpleados) {
                if (empleado.getId_de_empleado() == empleadoId){
                    return true;
                }
            }
            return false;
        };
        Supplier<Employee> crearEmpleado = () ->{
            System.out.println("Ingrese su nombre: ");
            String nombre_Nuevo = inputUser.next();
            System.out.println("Ingrese su salario: ");
            float salario_Nuevo = inputUser.nextFloat();
            return new Employee(idRegistrarEmpleado++, nombre_Nuevo, salario_Nuevo);
        };

        Consumer<Integer> showEmployeeData = id ->{
            boolean employeeExists = false;
            for (Employee empleado:
                 listaEmpleados) {
                if (empleado.getId_de_empleado() == id){
                    System.out.println(empleado);
                    employeeExists = true;
                }
            }
            if (!employeeExists) System.out.println("No existe ese id!");
        };


        boolean running = true;
        while(running){
            System.out.println("¿Qué es lo que desea hacer?\n" +
                               "    1.- Registrar empleado nuevo\n" +
                               "    2.- Ver datos de empleado");
            int accion = inputUser.nextInt();
            switch (accion){
                case 1:
                        Employee empleadoNuevo = crearEmpleado.get();
                        listaEmpleados.add(empleadoNuevo);
                        showEmployeeData.accept(empleadoNuevo.getId_de_empleado());
                    break;
                case 2:
                    System.out.println("Ingrese el id del empleado a consultar ");
                    int id = inputUser.nextInt();
                    showEmployeeData.accept(id);
                    break;
            }
        }
    }
    @FunctionalInterface
    interface TriFunction<T, U, V, R>{
        R apply(T t, U u, V v);
    }
}
