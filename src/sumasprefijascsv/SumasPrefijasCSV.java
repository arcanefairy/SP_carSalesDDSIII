package sumasprefijascsv;

import java.io.*;
import java.util.*;

public class SumasPrefijasCSV {
    public static void main(String[] args) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("car_sales.csv"));
            String linea;
            List<Double> ventas = new ArrayList<>();

            lector.readLine(); // Con esto se leerá las primeras
            // lineas de las columnas y se van a omitir los encabezados

            while ((linea = lector.readLine()) != null) {
                String[] valores = linea.split(",");
                ventas.add(Double.parseDouble(valores[4])); // Con esto indicamos el lugar de la columna de ventas
                //la cual es la quinta columna
            }
            lector.close();

            List<Double> sumasPrefijas = new ArrayList<>();
            double suma = 0.0;
            for (double venta : ventas) {
                suma += venta;
                sumasPrefijas.add(suma);
            } //En esta parte se realiza la suma prefija de la columna de ventas.

            BufferedWriter crearCSV = new BufferedWriter(new FileWriter("tabla_sumas.csv")); //con este buffer creamos un
            //nuevo archivo donde almacenaremos la suma prefija
            for (double sumaPrefija : sumasPrefijas) {
                crearCSV.write(sumaPrefija + "\n"); //Con esto ordenamos las sumas para que estas se guarden solo
                //una por fila, y que no sean continuas
            }
            crearCSV.close();

            System.out.println("Tabla de sumas prefijas guardada en tabla_sumas.csv");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
