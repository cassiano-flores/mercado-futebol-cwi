package jogador;

import clube.Clube;
import jogador.apetite.ApetiteFinanceiro;

public class Goleiro extends Jogador {
    public static final double ACRESCIMO_POR_PENALTI_DEFENDIDO = 0.04;

    private int penaltisDefendidosNoAno;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, double preco, int penaltisDefendidosNoAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.penaltisDefendidosNoAno = penaltisDefendidosNoAno;
    }

    @Override
    public double valorDeCompra() {

        return super.valorDeCompra() + ((super.valorDeCompra() * penaltisDefendidosNoAno) * ACRESCIMO_POR_PENALTI_DEFENDIDO);
    }
}
