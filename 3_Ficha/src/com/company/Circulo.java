package com.company;

public class Circulo {
    private double x;
    private double y;
    private double raio;

    public Circulo(){
        x = 0;
        y = 0;
        raio = 0;
    }
    public Circulo(double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void alteraCenttro(double x, double y){
        setX(x);
        setY(y);
    }

    public double calculaArea(){
        double area = Math.PI * Math.pow(raio,2);
        return area;
    }

    public double calculaPerimetro(){
        double perimetro = 2 * Math.PI * this.raio;
        return perimetro;
    }
}
