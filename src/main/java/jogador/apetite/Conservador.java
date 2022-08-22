package jogador.apetite;

public class Conservador extends ApetiteFinanceiro {
    public static final double PORCENTAGEM_CONSERVADOR = 1.4;

    @Override
    public double getPorcentagem(){

        return PORCENTAGEM_CONSERVADOR;
    }
}
