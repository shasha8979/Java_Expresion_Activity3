
package com.example.transporte;

public class Bus extends Vehiculo {

    private String nombreRuta;

    public Bus(String placa, int capacidad, String nombreRuta) {
        super(placa, capacidad);
        this.nombreRuta = nombreRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    @Override
    public double calcularTarifa(double kilometros) {
        return kilometros * 900;
    }

    @Override
    public String descripcion() {
        return "Bus | " + super.descripcion()
                + " | Ruta: " + nombreRuta;
    }
}
