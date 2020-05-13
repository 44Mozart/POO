package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // --------------- 1 ----------------
        System.out.println("------------- EXERCICIO 1 -------------");
        Circulo c1 = new Circulo(0,0,3);

        //e
        c1.alteraCenttro(1,1);
        System.out.println("Exercicio 1e): Centro alterado para: x = " + c1.getX() + " y = " + c1.getY());

        //f
        double area = c1.calculaArea();
        System.out.println("Exercicio 1f): Area: " + area);

        //g
        double perimetro = c1.calculaPerimetro();
        System.out.println("Exercicio 1g): Perimetro: " + perimetro);

        // --------------- 3 ----------------
        System.out.println("------------- EXERCICIO 3 -------------");
        String[] s1 = {"Lindo","Incrivel","Otimo"};
        Youtube y = new Youtube("Impratical Bestas",0, LocalDate.now(),720,5.5,330,3,s1,50,0);

        y.insereComentario("Adoro");
        System.out.println("Exercicio 3a): Comentarios :" + y.getComentarios());

    }
}
