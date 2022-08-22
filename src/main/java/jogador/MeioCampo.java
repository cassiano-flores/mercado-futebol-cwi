package jogador;

import clube.Clube;
import jogador.apetite.ApetiteFinanceiro;

public class MeioCampo extends Jogador{
    public static final double DESCONTO_POR_IDADE = 0.3;

    public MeioCampo(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, double preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public double valorDeCompra() {
        if (getIdade() > 30){

            return super.valorDeCompra() - ((super.valorDeCompra() * DESCONTO_POR_IDADE));
        }
        else {
            return super.valorDeCompra();
        }
    }

    @Override
    public boolean interesseNoClube(Clube clube) {
        return (getReputacaoHistoricaClubeAtual() - clube.getReputacaoHistorica()) >= 2;
    }
}
