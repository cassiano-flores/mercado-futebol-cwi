package jogador.apetite;

public class Indiferente extends ApetiteFinanceiro {
    public static final double PORCENTAGEM_INDETERMINADO = 1;

    @Override
    public double getPorcentagem(){

        return PORCENTAGEM_INDETERMINADO;
    }
}