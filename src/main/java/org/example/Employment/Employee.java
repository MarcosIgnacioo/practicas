package org.example.Employment;

public class Employee {
    int id_de_empleado;
    String nombre_de_empleado;
    double salario_de_empleado;

    public Employee(int id_de_empleado, String nombre_de_empleado, double salario_de_empleado) {
        this.id_de_empleado = id_de_empleado;
        this.nombre_de_empleado = nombre_de_empleado;
        this.salario_de_empleado = salario_de_empleado;
    }

    public int getId_de_empleado() {
        return id_de_empleado;
    }

    public void setId_de_empleado(int id_de_empleado) {
        this.id_de_empleado = id_de_empleado;
    }

    public String getNombre_de_empleado() {
        return nombre_de_empleado;
    }

    public void setNombre_de_empleado(String nombre_de_empleado) {
        this.nombre_de_empleado = nombre_de_empleado;
    }

    public double getSalario_de_empleado() {
        return salario_de_empleado;
    }

    public void setSalario_de_empleado(double salario_de_empleado) {
        this.salario_de_empleado = salario_de_empleado;
    }

    @Override
    public String toString() {
        return  "------------------------------------------\n" +
                "Empleado \n" +
                "Id: " + id_de_empleado + "\n" +
                "Nombre:" + nombre_de_empleado + "\n" +
                "Salario: " + salario_de_empleado + "\n" +
                "------------------------------------------";
    }
}
