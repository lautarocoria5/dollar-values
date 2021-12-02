package com.example.dolarjubbler.entities;

public class Dollar {
    private String nombre;
    private String compra;
    private String venta;
    private String agencia;
    private String variacion;
    private String ventaCero;
    private String decimales;

    @Override
    public String toString() {
        return nombre + "\n" +"Compra= " + compra + "\t" +"Venta= " + venta + "\n" +
                "Agencia= " + agencia + "\n" +
                "Variacion= " + variacion + "\n" +
                "VentaCero= " + ventaCero + "\n" +
                "Decimales= " + decimales;
    }

    public Dollar(String nombre, String compra, String venta, String agencia, String variacion, String ventaCero, String decimales) {
        this.nombre = nombre;
        this.compra = compra;
        this.venta = venta;
        this.agencia = agencia;
        this.variacion = variacion;
        this.ventaCero = ventaCero;
        this.decimales = decimales;
    }

    public Dollar() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getVariacion() {
        return variacion;
    }

    public void setVariacion(String variacion) {
        this.variacion = variacion;
    }

    public String getVentaCero() {
        return ventaCero;
    }

    public void setVentaCero(String ventaCero) {
        this.ventaCero = ventaCero;
    }

    public String getDecimales() {
        return decimales;
    }

    public void setDecimales(String decimales) {
        this.decimales = decimales;
    }
}
