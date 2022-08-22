package jogador;

import clube.Clube;
import jogador.apetite.ApetiteFinanceiro;

public class Jogador {

    private String nome;
    private int idade;
    private Clube clubeAtual;
    private int reputacaoHistorica;
    private ApetiteFinanceiro apetiteFinanceiro;
    private double preco;

    public Jogador(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, double preco) {
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        this.reputacaoHistorica = reputacaoHistorica;
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }


    public String getNome() {
        return nome;
    }

    /*

    public void setNome(String nome) {
        this.nome = nome;
    }
     */

    public int getIdade() {
        return idade;
    }
/*
    public void setIdade(int idade) {
        this.idade = idade;
    }

 */

    public String getClubeAtual() {
        if (clubeAtual == null){
            return "Sem Clube";
        }
        else {
            return clubeAtual.getNome();
        }
    }

    /*
    public void setClubeAtual(Clube clubeAtual) {
        this.clubeAtual = clubeAtual;
    }

     */

    public int getReputacaoHistorica() {
        if (reputacaoHistorica < 0){
            reputacaoHistorica = 0;
        }
        if (reputacaoHistorica > 10){
            reputacaoHistorica = 10;
        }

        return reputacaoHistorica;
    }

    public int getReputacaoHistoricaClubeAtual(){
        return clubeAtual.getReputacaoHistorica();
    }

    /*
    public void setReputacaoHistorica(int reputacaoHistorica) {
        this.reputacaoHistorica = reputacaoHistorica;
    }

    public ApetiteFinanceiro getApetiteFinanceiro() {
        return apetiteFinanceiro;
    }

    public void setApetiteFinanceiro(ApetiteFinanceiro apetiteFinanceiro) {
        this.apetiteFinanceiro = apetiteFinanceiro;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

     */

    public boolean interesseNoClube(Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }

    public double valorDeCompra(){

        return preco * apetiteFinanceiro.getPorcentagem();
    }

    public void transferenciaDeClube(Clube clube){

        clubeAtual = clube;
    }
}
