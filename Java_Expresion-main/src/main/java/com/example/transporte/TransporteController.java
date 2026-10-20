
package com.example.transporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransporteController {

    private final List<Vehiculo> flota = new ArrayList<>();
    private final Map<String, String> conductores = new HashMap<>();

    public TransporteController() {
        // Registrar los cinco vehículos
        flota.add(new Bus("BUS101", 40, "Centro-Norte"));
        flota.add(new Bus("BUS102", 35, "Sur-Centro"));
        flota.add(new Taxi("TAX201", 4, "Taxis Bogotá"));
        flota.add(new Taxi("TAX202", 4, "Radio Taxi"));
        flota.add(new Vehiculo("VEH301", 8));

        // Registrar conductores
        conductores.put("BUS101", "Carlos");
        conductores.put("BUS102", "Andres");
        conductores.put("TAX201", "Daniela");
    }

    // 1. Consultar todos los vehículos
    @GetMapping("/vehiculos")
    public List<Vehiculo> obtenerVehiculos() {
        return flota;
    }

    // 2. Buscar un vehículo por su placa
    @GetMapping("/vehiculos/placa/{placa}")
    public String buscarPorPlaca(@PathVariable String placa) {
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo.descripcion();
            }
        }

        return "No se encontró el vehículo " + placa;
    }

    // 3. Consultar las tarifas de los vehículos por kilómetros
    @GetMapping("/vehiculos/tarifa/{km}")
    public List<String> obtenerTarifas(@PathVariable double km) {
        List<String> tarifas = new ArrayList<>();

        for (Vehiculo vehiculo : flota) {
            String resultado = vehiculo.descripcion()
                    + " -> Tarifa para " + km + " km: $"
                    + vehiculo.calcularTarifa(km);

            tarifas.add(resultado);
        }

        return tarifas;
    }

    // 4. Filtrar vehículos por capacidad mínima
    @GetMapping("/vehiculos/capacidad/{minima}")
    public List<Vehiculo> filtrarPorCapacidad(
            @PathVariable int minima) {

        List<Vehiculo> resultado = new ArrayList<>();

        for (Vehiculo vehiculo : flota) {
            if (vehiculo.getCapacidad() >= minima) {
                resultado.add(vehiculo);
            }
        }

        return resultado;
    }

    // 5. Consultar el conductor asignado a una placa
    @GetMapping("/conductor/{placa}")
    public String obtenerConductor(@PathVariable String placa) {
        String placaBuscada = placa.toUpperCase();
        String conductor = conductores.get(placaBuscada);

        if (conductor != null) {
            return "El conductor de " + placaBuscada
                    + " es " + conductor;
        }

        return "Sin conductor asignado";
    }
}
