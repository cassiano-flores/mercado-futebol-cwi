package negociacao;

import clube.Clube;
import jogador.Jogador;

public class Negociacao {

    private boolean possuiInteresse(Clube clubeInteressado, Jogador jogadorDeInteresse){
        return jogadorDeInteresse.interesseNoClube(clubeInteressado);
    }

    private boolean clubeTemComoPagar(Clube clubeInteressado, Jogador jogadorDeInteresse){
        return clubeInteressado.getSaldoDisponivelEmCaixa() >= jogadorDeInteresse.valorDeCompra();
    }

    /*
    private void transferencia(Clube clubeInteressado, Jogador jogadorDeInteresse){
        if (possuiInteresse(clubeInteressado, jogadorDeInteresse) && clubeTemComoPagar(clubeInteressado, jogadorDeInteresse)){
            jogadorDeInteresse.transferenciaDeClube(clubeInteressado);
            clubeInteressado.setSaldoDisponivelEmCaixa(clubeInteressado.getSaldoDisponivelEmCaixa() - jogadorDeInteresse.valorDeCompra());
        }
    }

     */

    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse){
        return possuiInteresse(clubeInteressado, jogadorDeInteresse) && clubeTemComoPagar(clubeInteressado, jogadorDeInteresse);
    }
}
