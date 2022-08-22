package jogador;

import clube.Clube;
import jogador.apetite.ApetiteFinanceiro;

public class Atacante extends Jogador{
    public static final double ACRESCIMO_POR_GOL = 0.01;
    public static final double DESCONTO_POR_IDADE = 0.25;

    private int quantidadeDeGolsNoAno;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, double preco, int quantidadeDeGolsNoAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeDeGolsNoAno = quantidadeDeGolsNoAno;
    }

    @Override
    public double valorDeCompra() {

        double salario = super.valorDeCompra() + ((super.valorDeCompra() * quantidadeDeGolsNoAno) * ACRESCIMO_POR_GOL);

        if (getIdade() > 30){

            return salario - ((salario * DESCONTO_POR_IDADE));
        }
        else {
            return salario;
        }
    }

    @Override
    public boolean interesseNoClube(Clube clube) {
        return clube.getReputacaoHistorica() > getReputacaoHistorica();
    }
}
