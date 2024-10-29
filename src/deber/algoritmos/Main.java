/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deber.algoritmos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Cálculo de áreas y perímetros");
            System.out.println("2. Calculadora básica");
            System.out.println("3. Gestión de vehículo");
            System.out.println("4. Cálculo de IVA de producto");
            System.out.println("5. Gestión de empleado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        calculoFiguras(reader);
                        break;
                    case 2:
                        calculadora(reader);
                        break;
                    case 3:
                        gestionVehiculo();
                        break;
                    case 4:
                        calculoIVA(reader);
                        break;
                    case 5:
                        gestionEmpleado(reader);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error en la entrada. Intente nuevamente.");
            }
        }
    }

    
    private static void calculoFiguras(BufferedReader reader) throws IOException {
        System.out.println("Cálculo de Áreas y Perímetros");
        System.out.println("1. Triángulo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Rectángulo");
        System.out.print("Seleccione la figura: ");
        int figura = Integer.parseInt(reader.readLine());

        switch (figura) {
            case 1:
                System.out.print("Ingrese la base del triángulo: ");
                double base = Double.parseDouble(reader.readLine());
                System.out.print("Ingrese la altura del triángulo: ");
                double altura = Double.parseDouble(reader.readLine());
                Triangulo triangulo = new Triangulo(base, altura);
                System.out.println("Área: " + triangulo.calcularArea());
                System.out.println("Perímetro (simplificado): " + triangulo.calcularPerimetro());
                break;
            case 2:
                System.out.print("Ingrese el lado del cuadrado: ");
                double ladoCuadrado = Double.parseDouble(reader.readLine());
                Cuadrado cuadrado = new Cuadrado(ladoCuadrado);
                System.out.println("Área: " + cuadrado.calcularArea());
                System.out.println("Perímetro: " + cuadrado.calcularPerimetro());
                break;
            case 3:
                System.out.print("Ingrese el largo del rectángulo: ");
                double largo = Double.parseDouble(reader.readLine());
                System.out.print("Ingrese el ancho del rectángulo: ");
                double ancho = Double.parseDouble(reader.readLine());
                Rectangulo rectangulo = new Rectangulo(largo, ancho);
                System.out.println("Área: " + rectangulo.calcularArea());
                System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
                break;
            default:
                System.out.println("Figura no válida.");
        }
    }

    
    private static void calculadora(BufferedReader reader) throws IOException {
        Calculadora calculadora = new Calculadora();
        System.out.println("Calculadora Básica");
        System.out.print("Ingrese el primer número: ");
        double num1 = Double.parseDouble(reader.readLine());
        System.out.print("Ingrese el segundo número: ");
        double num2 = Double.parseDouble(reader.readLine());
        System.out.print("Elija la operación (+, -, *, /): ");
        String operacion = reader.readLine();
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = calculadora.sumar(num1, num2);
                break;
            case "-":
                resultado = calculadora.restar(num1, num2);
                break;
            case "*":
                resultado = calculadora.multiplicar(num1, num2);
                break;
            case "/":
                resultado = calculadora.dividir(num1, num2);
                break;
            default:
                System.out.println("Operación no válida.");
                return;
        }

        System.out.println("El resultado es: " + resultado);
    }

    
    private static void gestionVehiculo() {
        String numeroMotor = JOptionPane.showInputDialog("Ingrese el número de motor:");
        String ventanas = JOptionPane.showInputDialog("Ingrese el número de ventanas:");
        String puertas = JOptionPane.showInputDialog("Ingrese la cantidad de puertas:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        double kilometrajeInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el kilometraje inicial:"));
        double kilometrajeFinal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el kilometraje final:"));

        double kilometrosRecorridos = kilometrajeFinal - kilometrajeInicial;

        String mensaje = String.format(
                "Vehículo:\nNúmero de motor: %s\nVentanas: %s\nPuertas: %s\nMarca: %s\nModelo: %s\nKilómetros recorridos: %.2f",
                numeroMotor, ventanas, puertas, marca, modelo, kilometrosRecorridos);

        JOptionPane.showMessageDialog(null, mensaje);
    }

    
    private static void calculoIVA(BufferedReader reader) throws IOException {
        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(reader.readLine());

        double iva;
        if (precio <= 0) {
            iva = 0;
        } else if (precio <= 500) {
            iva = precio * 0.12;
        } else if (precio <= 1500) {
            iva = precio * 0.14;
        } else {
            iva = precio * 0.15;
        }

        System.out.println("El IVA calculado es: " + iva);
        System.out.println("Precio final con IVA: " + (precio + iva));
    }

    
    private static void gestionEmpleado(BufferedReader reader) throws IOException {
        System.out.print("Ingrese la cédula: ");
        String cedula = reader.readLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = reader.readLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = reader.readLine();
        System.out.print("Ingrese el género: ");
        String genero = reader.readLine();
        System.out.print("Ingrese el salario: ");
        double salario = Double.parseDouble(reader.readLine());
        System.out.print("Ingrese los años de antigüedad: ");
        int antiguedad = Integer.parseInt(reader.readLine());

        
        double prestaciones = (antiguedad * salario) / 12;

        System.out.println("Empleado: " + nombre + " " + apellido);
        System.out.println("Prestaciones: " + prestaciones);
    }
}
