package com.company;

public class ExisteVeiculoException extends Exception {
    public ExisteVeiculoException(){
        super();
    }
    public ExisteVeiculoException(String matricula) {
        super(matricula);
    }
}
