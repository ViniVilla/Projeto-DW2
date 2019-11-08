package br.edu.ifsp.eol.osservice.modelo;

public enum Plano {

    MONO("Monofasico"),
    BI("Bifasico"),
    TRI("Trifasico");

    private String nome;

    Plano(String nome){
        this.nome = nome;
    }

    public String nome(){
        return nome;
    }
}