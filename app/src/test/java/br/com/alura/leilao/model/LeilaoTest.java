package br.com.alura.leilao.model;

import static org.junit.Assert.*;


import org.junit.Test;

public class LeilaoTest {

    //PASSOS PARA CRIACAO DE TESTES
    //criar cenario de teste
    //executar acao esperada
    //testar resultado esperado

    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario NAMI = new Usuario("Nami");

    @Test
    public void deve_DevolverDescricao_QuandoRecebeDescricao() {
        String descricaoDevolvida = CONSOLE.getDescricao();
        assertEquals("Console", descricaoDevolvida);
    }

    //NOMEANDO TESTES
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
        assertEquals(100.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente (){
        CONSOLE.propoe(new Lance(NAMI, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Luffy"), 200.0));
        double maiorLanceDevolvido = CONSOLE.getMaiorLance();
        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente () {
        CONSOLE.propoe(new Lance(new Usuario("Luffy"), 10000.0));
        CONSOLE.propoe(new Lance(NAMI, 6000.0));
        double maiorLanceDevolvido = CONSOLE.getMaiorLance();
        assertEquals(10000.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(NAMI, 100.0));
        double menorLanceDevolvido = CONSOLE.getMenorLance();
        assertEquals(100.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente (){
        CONSOLE.propoe(new Lance(NAMI, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Luffy"), 200.0));
        double menorLanceDevolvido = CONSOLE.getMenorLance();
        assertEquals(100.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente () {
        CONSOLE.propoe(new Lance(new Usuario("Luffy"), 10000.0));
        CONSOLE.propoe(new Lance(NAMI, 6000.0));
        double menorLanceDevolvido = CONSOLE.getMenorLance();
        assertEquals(6000.0, menorLanceDevolvido, 0.0001);
    }
}