package jogador;

import clube.Clube;
import jogador.apetite.ApetiteFinanceiro;

public class Lateral extends Jogador{
    public static final double ACRESCIMO_POR_CRUZAMENTO_CERTEIRO = 0.02;
    public static final double DESCONTO_POR_IDADE = 0.3;

    private int cruzamentosCerteirosNoAno;

    public Lateral(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, double preco, int cruzamentosCerteirosNoAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.cruzamentosCerteirosNoAno = cruzamentosCerteirosNoAno;
    }

    @Override
    public double valorDeCompra() {

        double salario = super.valorDeCompra() + ((super.valorDeCompra() * cruzamentosCerteirosNoAno) * ACRESCIMO_POR_CRUZAMENTO_CERTEIRO);

        if (getIdade() > 28){

            return salario - ((salario * DESCONTO_POR_IDADE));
        }
        else {
            return salario;
        }
    }
}
