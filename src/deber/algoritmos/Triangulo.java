/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber.algoritmos;

public class Triangulo extends Figura {
    private double base, altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    
    public double calcularArea() {
        return (base * altura) / 2;
    }

    
    public double calcularPerimetro() {
        return base * 3; // Para simplificar, se asume un triángulo equilátero
    }
}

