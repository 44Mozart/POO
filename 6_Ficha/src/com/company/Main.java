package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {

	VeiculoNormal v1 = new VeiculoNormal("61-EE-21", "Skoda", "Fabia", 2006, 76.3, 4.5, 0, 0.0, 0, 12);
	VeiculoNormal v2 = new VeiculoNormal("71-RE-01", "Opel", "Corsa", 2008, 67.7, 5, 0, 0.0, 0, 10);
	VeiculoNormal v3 = new VeiculoNormal("11-FG-16", "Porsche", "Panamera", 2009, 89.1, 3.5,0, 0.0, 0, 1);
	VeiculoNormal v4 = new VeiculoNormal("55-TY-09", "Skoda", "Scala", 2010, 75.6, 4.8, 0,0.0, 0, 20);
    VeiculoOcasiao v5 = new VeiculoOcasiao("56-GG-78", "Fiat", "Punto", 2006, 72.3, 3.7, 0,0.0, 0, 32,true);
    VeiculoOcasiao v6 = new VeiculoOcasiao("05-HJ-72", "Porsche", "Carrera", 2009, 95.3, 5.2, 0,0.0, 0, 43,false);
    VeiculoPremium v9 = new VeiculoPremium("20-FD-12", "Porsche", "Panamera", 2008, 89.1, 4.5,0, 0.0, 0, 0,1.50);
    VeiculoPremium v10 = new VeiculoPremium("44-WM-44", "Ford", "Galaxy", 2000, 60.1, 3.5,0, 0.0, 0, 25,1.30);
    AutocarroInteligente a1 = new AutocarroInteligente("23-EE-10", "Mercedes", "Benz", 2006, 76.3, 4.5, 0, 0.0, 0, 20,45,60);
    AutocarroInteligente a2 = new AutocarroInteligente("33-RT-12", "Mercedes", "Benz", 2003, 66.3, 3.1, 0, 0.0, 0, 30,20,60);

    System.out.println("Carros gerados\n");

    DriveIt drive = new DriveIt();
    System.out.println("DriveIt gerado\n");

    /* 1 */
    /* e) */
        drive.adiciona(v1); drive.adiciona(v2); drive.adiciona(v3); drive.adiciona(v4); drive.adiciona(v5); drive.adiciona(v6); drive.adiciona(v9);drive.adiciona(v10);drive.adiciona(a1);drive.adiciona(a2);
        System.out.println("Carros adicionados ao driveIt\n");
        System.out.println(drive);

    /* a) */
        System.out.println("Existe algum com a matricula 56-GH-78? -> " + drive.existeVeiculo("56-GH-78") + "\n");
        System.out.println("E com a matricula 11-FG-16? -> " + drive.existeVeiculo("11-FG-16")+ "\n");

    /* b) */
        System.out.println("Quantidade de carros na estrutura: " + drive.quantos() + "\n");

    /* c) */
        System.out.println("Quantidade de carros Porsche -> " + drive.quantos("Porsche"));
        System.out.println("Quantidade de carros Fiat -> " + drive.quantos("Fiat"));
        System.out.println("Quantidade de carros Skoda -> " + drive.quantos("Skoda"));

    /* d) */
    Veiculo obtido = drive.getVeiculo("05-HJ-72");
        System.out.println("\nVeiculo obtido");
        System.out.println(obtido);

    /* f) */
        List<Veiculo> listaveiculos = drive.getVeiculosList();
        System.out.println("\nLista de todos os veiculos inseridos na estrutura:");
        System.out.println(listaveiculos);

    /* g) */
        VeiculoNormal v7 = new VeiculoNormal("78-RG-24","Lamborghini", "Aventador", 2005, 103.2, 5.6, 0, 0.0, 0, 0);
        VeiculoNormal v8 = new VeiculoNormal("35-AA-16","Fiat", "500", 2002, 65.8, 5.6, 0, 0.0, 0, 0);
        Set<Veiculo> teste = new HashSet<>();
        teste.add(v7); teste.add(v8);

    /* adicionam-se repetidos para ver se ignora */ teste.add(v2); teste.add(v5);
        drive.adiciona(teste);
        System.out.println("\nConjunto dos veículos adicionado ao HashMap, HashMap atualizado -> "); System.out.println(drive);
        System.out.println(drive.quantos());

    /* h) */
        System.out.println("\nVeiculo antes de registar aluguer: "); System.out.println(drive.getVeiculo("35-AA-16"));
        drive.registarAluguer("35-AA-16", 643);
        System.out.println("\nVeiculo depois de registar aluguer: "); System.out.println(drive.getVeiculo("35-AA-16"));

    /* i) */
        System.out.println("\nVeiculo antes de classificar: "); System.out.println(drive.getVeiculo("78-RG-24"));
        drive.classificarVeiculo("78-RG-24", 9);
        System.out.println("\nVeiculo depois de classificar: "); System.out.println(drive.getVeiculo("78-RG-24"));

    /* j) */
        System.out.println("\nCusto real por km do skoda fabia -> " + drive.custoRealKm("61-EE-21"));
        drive.ordenarVeiculos();
        System.out.println(drive.ordenarVeiculos());

    /* g) Premium */
        System.out.println("Exercicio g) (Premium) :\n" + drive.veiculosOrdenadosCusto());

    /* h) Premium */
        System.out.println("Exercicio h) (Premium) :\nVeiculo mais barato: " + drive.veiculoMaisBarato());

    /* i) Premium */
        System.out.println("Exercicio i) (Premium) :\nVeiculo menos utilizado: " + drive.veiculoMenosUtilizado());

    // ------------ FASE 2 -------------

        /*a) */
        System.out.println("Exercicio a):\n" + drive.ordenarVeiculos());

        /*b) */
        System.out.println("Exercicio b):\n" + drive.ordenarVeiculoList().toString());

        /*c) */
        System.out.println("Exercicio c):\n" + drive.ordenarVeiculos(Veiculo::compareTo));


    }
}
