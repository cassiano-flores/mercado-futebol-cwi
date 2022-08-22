import clube.Clube;
import jogador.*;
import jogador.apetite.Conservador;
import jogador.apetite.Indiferente;
import jogador.apetite.Mercenario;
import negociacao.Negociacao;
import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa(){
        //arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, 100000000);
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, new Indiferente(), 800500, 12);

        //act
        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        //assert
        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void deveSerPossivelNegociarUmAtacanteComUmClubeQueTemSaldoEmCaixa(){
        //arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, 100000000);
        Atacante atacante = new Atacante("Marcelo Grohe", 33, null, 8, new Indiferente(), 800500, 12);

        //act
        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        //assert
        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmMeioCampoPorFaltaDeInteresse(){
        //arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 4, 100000000);
        Clube clube2 = new Clube("Inter", 10, 100000000);
        MeioCampo meioCampo = new MeioCampo("Ronaldo", 33, clube, 8, new Indiferente(), 800500);

        //act
        boolean foiPossivelNegociar = negociacao.negociar(clube2, meioCampo);

        //assert
        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua(){
        //arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, 100000000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, new Conservador(), 800500, 20);

        //act
        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        //assert
        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel(){
        //arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Santos", 6, 5000);
        Zagueiro zagueiro = new Zagueiro("Romario", 22, null, 6, new Indiferente(), 545346);

        //act
        boolean foiPossivelNegociar = negociacao.negociar(clube, zagueiro);

        //assert
        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        //Clube clube = new Clube("Fluminense", 6, 100004);
        MeioCampo meioCampo = new MeioCampo("Ze", 20, null, 6, new Mercenario(), 5453);
        double precoDoMeioCampoEsperado = 9815.4;

        //act
        double precoDoMeioCampoCalculado = meioCampo.valorDeCompra();

        //assert
        Assert.assertEquals(precoDoMeioCampoEsperado, precoDoMeioCampoCalculado, 0);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        //Clube clube = new Clube("Vasco", 8, 534567);
        MeioCampo meioCampo = new MeioCampo("Zoio", 31, null, 8, new Mercenario(), 5453);
        double precoDoMeioCampoEsperado = 6870.78;

        //act
        double precoDoMeioCampoCalculado = meioCampo.valorDeCompra();

        //assert
        Assert.assertEquals(precoDoMeioCampoEsperado, precoDoMeioCampoCalculado, 0);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoLateralComMaisDeVinteEOitoAnos(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Flamengo", 3, 23213);
        Lateral lateral = new Lateral("Zico", 29, clube, 8, new Mercenario(), 500, 15);
        double precoDoLateralEsperado = 819;

        //act
        double precoDoLateralCalculado = lateral.valorDeCompra();

        //assert
        Assert.assertEquals(precoDoLateralEsperado, precoDoLateralCalculado, 0);
    }

    @Test
    public void deveRetornarCorretamenteONomeDeUmJogador(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Botafogo", 3, 23213);
        Lateral lateral = new Lateral("Paulo Silva", 29, clube, 8, new Mercenario(), 500, 15);
        String nomeEsperado = "Paulo Silva";

        //act
        String nomeRetornado = lateral.getNome();

        //assert
        Assert.assertEquals(nomeEsperado, nomeRetornado);
    }

    @Test
    public void deveRetornarCorretamenteOClubeAtualDeUmJogador(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Palmeiras", 10, 2321345);
        Atacante atacante = new Atacante("Robinho", 40, clube, 8, new Mercenario(), 500, 15);
        String clubeEsperado = "Palmeiras";

        //act
        String clubeRetornado = atacante.getClubeAtual();

        //assert
        Assert.assertEquals(clubeEsperado, clubeRetornado);
    }

    @Test
    public void deveRetornarSemClubeQuandoUmJogadorNaoTiverUmClube(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        //Clube clube = new Clube("Palmeiras", 10, 2321345);
        Atacante atacante = new Atacante("Robinho", 40, null, 8, new Mercenario(), 500, 15);
        String clubeEsperado = "Sem Clube";

        //act
        String clubeRetornado = atacante.getClubeAtual();

        //assert
        Assert.assertEquals(clubeEsperado, clubeRetornado);
    }

    @Test
    public void deveRetornarONomeClubeQuandoTiverUmaTransferencia(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Palmeiras", 4, 23456);
        Clube clube2 = new Clube("Internacional", 10, 2321345);
        Zagueiro zagueiro = new Zagueiro("Robinho", 40, clube, 6, new Mercenario(), 500);

        zagueiro.transferenciaDeClube(clube2);
        String clubeEsperado = "Internacional";

        //act
        String clubeRetornado = zagueiro.getClubeAtual();

        //assert
        Assert.assertEquals(clubeEsperado, clubeRetornado);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoZagueiroComMaisDeTrintaAnos(){
        //arrange
        //Negociacao negociacao = new Negociacao();
        //Clube clube = new Clube("Remo", 3, 23213);
        Zagueiro zagueiro = new Zagueiro("Zico", 33, null, 8, new Mercenario(), 5523);
        double precoDoZagueiroEsperado = 7953.12;

        //act
        double precoDoZagueiroCalculado = zagueiro.valorDeCompra();

        //assert
        Assert.assertEquals(precoDoZagueiroEsperado, precoDoZagueiroCalculado, 0);
    }
}
