package br.com.alura.leilao.model;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class LeilaoTest {
    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario NAMI = new Usuario("Nami");
    private final Usuario LUFFY = new Usuario("Luffy");

    //PASSOS PARA CRIACAO DE TESTES
    //criar cenario de teste
    //executar acao esperada
    //testar resultado esperado

    @Test
    public void deve_DevolverDescricao_QuandoRecebeDescricao() {
        String descricaoDevolvida = CONSOLE.getDescricao();

        assertEquals("Console", descricaoDevolvida);
    }

    //NOMEANDO TESTES APOS TESTE
    //[nome do metodo][Estado de teste][Resultado esperado] -> uma das formas
    //[getMaiorlance][QuandoRecebeApenasUmLance][DevolveMaiorLance]
    //[deve][Resultado esperado][Estado de teste] -> outra forma
    //[deve][DevolverMaiorLance][QuandoRecebeApenasUmLance]

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeApenasUmLance() {
        //criar cenario de teste
        CONSOLE.propoe(new Lance(NAMI, 100.0));

        //executar acao esperada
        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        //testar resultado esperado
        assertEquals(100.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente (){
        CONSOLE.propoe(new Lance(NAMI, 100.0));
        CONSOLE.propoe(new Lance(LUFFY, 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }
// TESTE DESNECESSARIO APOS NOVA IMPLEMENTACAO DO METODO PROPOE NA CLASSE LEILAO
//    @Test
//    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente () {
//        CONSOLE.propoe(new Lance(LUFFY, 10000.0));
//        CONSOLE.propoe(new Lance(NAMI, 6000.0));
//
//        double maiorLanceDevolvido = CONSOLE.getMaiorLance();
//
//        assertEquals(10000.0, maiorLanceDevolvido, DELTA);
//    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(NAMI, 100.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente (){
        CONSOLE.propoe(new Lance(NAMI, 100.0));
        CONSOLE.propoe(new Lance(LUFFY, 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }
//TESTE NAO MAIS NECESSARIO APOS TESTE naoDeve_AdicionarLance_QuandoForMenorQueMaiorLance
//NOVA REGRA DE NEGOCIO NAO ESPERA MAIS ESSE TIPO DE ACAO (LANCES EM ORDEM DESCRESCENTE)
//    @Test
//    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente () {
//        CONSOLE.propoe(new Lance(LUFFY, 10000.0));
//        CONSOLE.propoe(new Lance(NAMI, 6000.0));
//
//        double menorLanceDevolvido = CONSOLE.getMenorLance();
//
//        assertEquals(6000.0, menorLanceDevolvido, DELTA);
//    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances() {
        CONSOLE.propoe(new Lance(NAMI, 200.0));
        CONSOLE.propoe(new Lance(LUFFY, 300.0));
        CONSOLE.propoe(new Lance(NAMI, 400.0));

        //Test Driven Development
        final List<Lance> tresMaioresLancesDevolvidos =  CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(400.0,
                tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0,
                tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0,
                tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);

    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoNaoReceberLances() {

        final List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(0, tresMaioresLancesDevolvidos.size());
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeApenasUmLance(){
        CONSOLE.propoe(new Lance(NAMI, 200.0));

        final List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(1, tresMaioresLancesDevolvidos.size());
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);

    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeApenasDoisLances() {
        CONSOLE.propoe(new Lance(NAMI, 200.0));
        CONSOLE.propoe(new Lance(LUFFY, 300.0));

        final List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(2, tresMaioresLancesDevolvidos.size());
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);

    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeMaisDeTresLances() {
        CONSOLE.propoe(new Lance(NAMI, 200.0));
        CONSOLE.propoe(new Lance(LUFFY, 300.0));
        CONSOLE.propoe(new Lance(new Usuario("Usopp"), 400.0));
        CONSOLE.propoe(new Lance(new Usuario("Sanji"), 500.0));

        final List<Lance> tresMaioresLancesDevolvidosParaQuatroLances =
                CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidosParaQuatroLances.size());
        assertEquals(500.0,
                tresMaioresLancesDevolvidosParaQuatroLances.get(0).getValor(), DELTA);
        assertEquals(400.0,
                tresMaioresLancesDevolvidosParaQuatroLances.get(1).getValor(), DELTA);
        assertEquals(300.0,
                tresMaioresLancesDevolvidosParaQuatroLances.get(2).getValor(), DELTA);

        CONSOLE.propoe(new Lance(NAMI, 700.0));

        final List<Lance> tresMaioresLancesDevolvidosParaCincoLances =
                CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidosParaCincoLances.size());
        assertEquals(700.0,
                tresMaioresLancesDevolvidosParaCincoLances.get(0).getValor(), DELTA);
        assertEquals(500.0,
                tresMaioresLancesDevolvidosParaCincoLances.get(1).getValor(), DELTA);
        assertEquals(400.0,
                tresMaioresLancesDevolvidosParaCincoLances.get(2).getValor(), DELTA);
    }

    @Test
    public void deve_DevolverValorZeroParaMaiorLance_QuandoNaoTiverLances(){
       double maiorLanceDevolvido = CONSOLE.getMaiorLance();

       assertEquals(0.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverValorZeroParaMenorLance_QuandoNaoTiverLances(){
        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(0.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void naoDeve_AdicionarLance_QuandoForMenorQueMaiorLance() {
        CONSOLE.propoe(new Lance(LUFFY, 500.0));
        try {
            CONSOLE.propoe(new Lance(NAMI, 400.0));
            fail("Era esperada uma RunTimeException");//avisa que caso nao lance excecao, ira falhar
        } catch (RuntimeException exception) {
            assertEquals("Lance foi menor que maior lance", exception.getMessage());
        }

//        int quantidadeLancesDevolvida = CONSOLE.quantidadeLances(); NAO MAIS NECESSARIO, LIDANDO COM EXCECOES
//        assertEquals(1, quantidadeLancesDevolvida);
    }

    @Test
    public void naoDeve_AdicionarLance_QuandoForOMesmoUsuarioDoUltimoLance(){
        CONSOLE.propoe(new Lance(NAMI, 500.0));
        try {
            CONSOLE.propoe(new Lance(NAMI, 600.0));
            fail("Era esperada uma RunTimeException");
        } catch (RuntimeException exception) {
           assertEquals("Mesmo usuario do ultimo lance", exception.getMessage());//validar a mensagem a partir da exception capturada
        }
    }

    @Test
    public void naoDeve_AdicionarLance_QuandoUsuarioDerCincoLances(){
        CONSOLE.propoe(new Lance(NAMI,  100.0));
        CONSOLE.propoe(new Lance(LUFFY,  200.0));
        CONSOLE.propoe(new Lance(NAMI,  300.0));
        CONSOLE.propoe(new Lance(LUFFY,  400.0));
        CONSOLE.propoe(new Lance(NAMI,  500.0));
        CONSOLE.propoe(new Lance(LUFFY,  600.0));
        CONSOLE.propoe(new Lance(NAMI,  700.0));
        CONSOLE.propoe(new Lance(LUFFY,  800.0));
        CONSOLE.propoe(new Lance(NAMI,  900.0));
        CONSOLE.propoe(new Lance(LUFFY,  1000.0));

        try {
            CONSOLE.propoe(new Lance(NAMI,  1100.0));
        }catch (RuntimeException exception) {
            assertEquals("Usuario ja ofertou cinco lances", exception.getMessage());
        }
    }

}
