package com.mycompany.lab7_joselobo;

import javax.swing.JOptionPane;

/**
 *
 * @author rinal
 */
public class Lab7_JoseLobo {

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Menu();
            switch (opcion) {
                case 1 -> {
                    int[][] a = crearmatrixdesigual();
                    JOptionPane.showMessageDialog(null, "Matrix Generada \n" + imprimirmatrix(a) + "\n Matrix Rotada \n" + imprimirmatrix(rotar90(a)));
                }//case 1
                case 2 -> {
                    int[][] a = crearmatrix();
                    int[] datos = sumar_multi(a);
                    JOptionPane.showMessageDialog(null, "Matrix Generada \n" + imprimirmatrix(a) + "\n Op. 1: " + datos[0] + "\n Op. 2: " + datos[1]);
                }//case 2
                case 3 -> {
                    String palabra1 = JOptionPane.showInputDialog("Ingrese su la primera Palabra");
                    String palabra2 = JOptionPane.showInputDialog("Ingrese su la segunda Palabra");
                    int[][] respuesta = ejercicio3(palabra1, palabra2);
                    JOptionPane.showMessageDialog(null, "Matrix Resultante \n" + imprimirmatrixcharacter(respuesta));
                }
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                }
            }//opcion
        } while (opcion != 4);
    }

    public static int[][] crearmatrix() {
        int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su tamaño de filas"));
        int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su tamaño de columnas"));
        int[][] temp = new int[fil][col];
        temp = aleatoriomatrix(temp);
        return temp;
    }//crear

    public static int[][] crearmatrixdesigual() {
        int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su tamaño de filas"));
        int col;
        do {
            col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su tamaño de columnas"));
            if (col == fil) {
                JOptionPane.showMessageDialog(null, "Error, tiene que tener filas y columnas diferente");
            }//error
        } while (col == fil);
        int[][] temp = new int[fil][col];
        temp = aleatoriomatrix(temp);
        return temp;
    }//crear

    public static int Menu() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                    Menu
                                    1. Portrait
                                    2. Número mágico
                                    3. Subsecuencia
                                    4. Salir
                                    """));
        return opcion;
    }//menu

    public static int[][] aleatoriomatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * 10);
            }//for j
        }//for i
        return a;
    }//aleatoriomatrix

    public static String imprimirmatrix(int[][] a) {
        String temp = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                temp += "[" + a[i][j] + "]";
            }//for j
            temp += "\n";
        }//for i
        return temp;
    }//imprimirmatrix

    public static String imprimirmatrixcharacter(int[][] a) {
        String temp = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < 40) {
                    temp += "[" + a[i][j] + "]";
                } else {
                    temp += "[" + ((char) a[i][j]) + "]";
                }
            }//for j
            temp += "\n";
        }//for i
        return temp;
    }//imprimirmatrix

    public static int[][] rotar90(int[][] a) {
        int[][] temp = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                temp[j][a.length - i - 1] = a[i][j];
            }//for j

        }//for i
        return temp;
    }//ejericio 1

    public static int[] sumar_multi(int[][] a) {
        int[] temp = new int[2];
        temp[1] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j == 0 || i == 0 || j == a.length - 1 || i == a.length - 1) {
                    temp[0] += a[i][j];
                } else {
                    temp[1] *= a[i][j];
                }//if
            }//for j
        }//for i
        return temp;
    }//Sumar Esquinas

    public static int[][] ejercicio3(String p1, String p2) {
        String palabra1 = "-" + p1;
        String palabra2 = "-" + p2;
        int[][] temp = new int[palabra2.length() + 1][palabra1.length() + 1];
        for (int i = 1; i <= palabra1.length(); i++) {
            temp[0][i] = palabra1.charAt(i - 1);
        }
        for (int i = 1; i <= palabra2.length(); i++) {
            temp[i][0] = palabra2.charAt(i - 1);
        }//letras

        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (temp[0][j] == temp[i][0]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                    if (temp[0][j] == 45) {
                        temp[i][j] = 0;
                    }
                } else {
                    if (temp[i][j - 1] < 40 && temp[i - 1][j] < 40) {
                        temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                    } else {
                        temp[i][j] = 0;
                    }
                }
            }//for j
        }//for i
        return temp;
    }//ejercicio 3
}//class
