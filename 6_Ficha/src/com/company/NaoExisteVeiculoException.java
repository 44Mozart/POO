package com.company;

public class NaoExisteVeiculoException extends Exception{
    public NaoExisteVeiculoException(){
        super();
    }
    public NaoExisteVeiculoException(String matricula) {
        super(matricula);
    }
}
