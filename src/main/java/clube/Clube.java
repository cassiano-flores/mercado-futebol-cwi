package clube;

public class Clube {

    private String nome;
    private int reputacaoHistorica;
    private double saldoDisponivelEmCaixa;

    public Clube(String nome, int reputacaoHistorica, double saldoDisponivelEmCaixa) {
        this.nome = nome;
        this.reputacaoHistorica = reputacaoHistorica;
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }

    public String getNome() {
        return nome;
    }

    /*public void setNome(String nome) {
        this.nome = nome;
    }*/

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    /*
    public void setReputacaoHistorica(int reputacaoHistorica) {
        this.reputacaoHistorica = reputacaoHistorica;
    }
    */

    public double getSaldoDisponivelEmCaixa() {
        return saldoDisponivelEmCaixa;
    }

    public void setSaldoDisponivelEmCaixa(double saldoDisponivelEmCaixa) {
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }
}