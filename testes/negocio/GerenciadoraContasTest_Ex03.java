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
public class GerenciadoraContasTest_Ex03 {

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
		//criando algumas contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		//inserindo as contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		boolean sucesso = gerenciadorasContas.transfereValor(idConta01, 100, idConta02, 0);
		
		//verificações
		//assegure que success=true
		assertTrue(sucesso);
		//assegure o que o saldo da conta 2 seja 100
		assertThat(conta02.getSaldo(), is(100.0));
		//assegure o que o saldo da conta 1 seja 100
		assertThat(conta01.getSaldo(), is(100.0));
	}
	
	/**
	 * Teste básico da tentativa de transferência de um valor da conta de um cliente para outro
	 * quando não há saldo suficiente.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 20/04/2026
	 */
	@Test
	public void testTransfereValor_SaldoInsuficiente() {
		//montagem do cenário
		//criando algumas contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		//inserindo as contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		boolean sucesso = gerenciadorasContas.transfereValor(idConta01, 200, idConta02, 0);
		
		//verificações
		//assegure que success=false
		assertFalse(sucesso);
		//assegure o que o saldo da conta 1 seja 100
		assertThat(conta01.getSaldo(), is(100.0));
		//assegure o que o saldo da conta 2 seja 0
		assertThat(conta02.getSaldo(), is(0.0));
	}

	/**
	 * Teste básico da tentativa de transferência de um valor da conta de um cliente para outro
	 * quando não há saldo suficiente, mas tem limite
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 20/04/2026
	 */
	@Test
	public void testTransfereValor_SaldoInsuficienteComLimite() {
		//montagem do cenário
		//criando algumas contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		//inserindo as contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		boolean sucesso = gerenciadorasContas.transfereValor(idConta01, 200, idConta02, 200);
		
		//verificações
		//assegure que sucess=false
		assertTrue(sucesso);
		//assegure o que o saldo da conta 1 seja -100
		assertThat(conta01.getSaldo(), is(-100.0));
		//assegure o que o saldo da conta 2 seja 200
		assertThat(conta02.getSaldo(), is(200.0));
	}
}

//Manutenção de Testes