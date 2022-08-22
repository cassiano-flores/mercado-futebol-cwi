package jogador.apetite;

public class Mercenario extends ApetiteFinanceiro {
    public static final double PORCENTAGEM_MERCENARIO = 1.8;

    @Override
    public double getPorcentagem(){

        return PORCENTAGEM_MERCENARIO;
    }
}
