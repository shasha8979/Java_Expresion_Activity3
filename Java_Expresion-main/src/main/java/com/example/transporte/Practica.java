
package com.example.transporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practica {

    public static void main(String[] args) {

        // Registrar los vehículos que forman parte de la flota.
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Bus("BUS101", 40, "Centro-Norte"));
        listaVehiculos.add(new Bus("BUS102", 35, "Sur-Centro"));
        listaVehiculos.add(new Taxi("TAX201", 4, "Taxis Bogotá"));
        listaVehiculos.add(new Taxi("TAX202", 4, "Radio Taxi"));
        listaVehiculos.add(new Vehiculo("VEH301", 8));

        // Mostrar la información y el costo del recorrido.
        double distanciaKm = 10;

        System.out.println("=== INFORMACIÓN DE LA FLOTA ===");

        for (Vehiculo actual : listaVehiculos) {
            System.out.println(actual.descripcion());
            System.out.println(
                    "Costo del recorrido (" + distanciaKm + " km): $"
                    + actual.calcularTarifa(distanciaKm)
            );
            System.out.println();
        }

        System.out.println(
                "Cantidad de vehículos registrados: "
                + listaVehiculos.size()
        );

        // Identificar vehículos cuya capacidad supera los 10 pasajeros.
        int vehiculosAltaCapacidad = 0;

        for (Vehiculo actual : listaVehiculos) {
            if (actual.getCapacidad() > 10) {
                vehiculosAltaCapacidad++;
            }
        }

        System.out.println(
                "Vehículos con capacidad superior a 10 pasajeros: "
                + vehiculosAltaCapacidad
        );

        // Relacionar las placas con sus respectivos conductores.
        Map<String, String> asignacionConductores = new HashMap<>();

        asignacionConductores.put("BUS101", "Carlos");
        asignacionConductores.put("BUS102", "Andrés");
        asignacionConductores.put("TAX201", "Daniela");

        // Consultar el conductor de un vehículo.
        String placaConsulta = "BUS101";
        String conductor = asignacionConductores.get(placaConsulta);

        if (conductor != null) {
            System.out.println(
                    "Conductor asignado a " + placaConsulta + ": "
                    + conductor
            );
        } else {
            System.out.println(
                    "No se encontró conductor para la placa "
                    + placaConsulta
            );
        }

        // Comprobar qué ocurre cuando la placa no está registrada.
        String placaSinRegistro = "XYZ999";
        String conductorNoRegistrado =
                asignacionConductores.get(placaSinRegistro);

        if (conductorNoRegistrado == null) {
            System.out.println(
                    "La placa " + placaSinRegistro
                    + " no tiene un conductor asignado."
            );
        } else {
            System.out.println(
                    "Conductor asignado a " + placaSinRegistro + ": "
                    + conductorNoRegistrado
            );
        }
    }
}
