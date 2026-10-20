
package com.example.transporte;

public class Taxi extends Vehiculo {

    private String nombreEmpresa;

    public Taxi(String placa, int capacidad, String nombreEmpresa) {
        super(placa, capacidad);
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    @Override
    public double calcularTarifa(double kilometros) {
        return super.calcularTarifa(kilometros) + 4000;
    }

    @Override
    public String descripcion() {
        return "Taxi | " + super.descripcion()
                + " | Empresa: " + nombreEmpresa;
    }
}
