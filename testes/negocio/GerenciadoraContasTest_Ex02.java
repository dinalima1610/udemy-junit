package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre contas, realizadas pela classe {@link GerenciadoraContas}.
 * 
 * @author Gustavo Farias
 * @author Diná Lima
 * @date 20/04/2026
 */
public class GerenciadoraContasTest_Ex02 {

	private GerenciadoraContas gerenciadorasContas;
	
	/**
	 * Teste básico da transferência de um valor da conta de um cliente para outro,
	 * estando ambos os clientes ativos e havendo saldo suficiente para tal transferência
	 * ocorrer com sucesso.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 20/04/2026
	 */
	@Test
	public void testTransfereValor() {

		//montagem do cenário
		//criando alguns contas
		ContaCorrente conta01 = new ContaCorrente(1, 200, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		
		//inserindo os contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		//deve ser deduzido 100 da conta 1 e acrescido na conta 2
		boolean sucesso = gerenciadorasContas.transfereValor(1, 100, 2, 0);
		
		//verificações
		//assegure o que o sucesso=true
		assertTrue(sucesso);
		//assegure o que o saldo da conta 2 seja 100
		assertThat(conta02.getSaldo(), is(100.0));
	}
}

// Documentação e comentários