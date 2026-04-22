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
 * @date 21/04/2026 
 */
public class GerenciadoraContasTest_Ex04 {

	private GerenciadoraContas gerenciadorasContas;
	
	/**
	 * Teste básico da transferência de um valor da conta de um cliente para outro,
	 * havendo saldo suficiente para tal transferência
	 * ocorrer com sucesso.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	  @date 21/04/2026
	 */
	@Test
	public void testTransfereValor() {
		System.out.println("     Teste básico da transferência de um valor da conta de um cliente para outro, havendo saldo suficiente para tal transferência");
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
	 * quando não há saldo suficiente, mas o saldo é positivo.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testTransfereValor_SaldoInsuficienteComLimite() {
		System.out.println("     Teste básico da tentativa de transferência de um valor da conta de um cliente para outro quando não há saldo suficiente, mas o saldo é positivo");
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
		//assegure que success=true
		assertTrue(sucesso);
		//assegure o que o saldo da conta 1 seja -100
		assertThat(conta01.getSaldo(), is(-100.0));
		//assegure o que o saldo da conta 2 seja 200
		assertThat(conta02.getSaldo(), is(200.0));
	}

	/**
	 * Teste básico da tentativa de transferência de um valor da conta de um cliente para outro
	 * quando não há saldo suficiente o saldo é negativo.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testTransfereValor_SaldoNegativo() {
		System.out.println("     Teste básico da tentativa de transferência de um valor da conta de um cliente para outro quando não há saldo suficiente, o saldo é negativo");
		//montagem do cenário
		//criando algumas contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		//inserindo as contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		boolean sucesso = gerenciadorasContas.transfereValor(idConta01, 200, idConta02, 200);
		
		//verificações
		//assegure que success=true
		assertTrue(sucesso);
		//assegure o que o saldo da conta 1 seja -300
		assertThat(conta01.getSaldo(), is(-300.0));
		//assegure o que o saldo da conta 2 seja 200
		assertThat(conta02.getSaldo(), is(200.0));
	}
	
	/**
	 * Teste básico da tentativa de transferência de um valor da conta de um cliente para outro
	 * quando o saldo do cliente origem é negativo e do cliente destino também é negativo.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testTransfereValor_SaldoNegativoParaNegativo() {
		System.out.println("     Teste básico da tentativa de transferência de um valor da conta de um cliente para outro, quando o saldo do cliente origem é negativo e do cliente destino também é negativo");
		//montagem do cenário
		//criando algumas contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		//inserindo as contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		boolean sucesso = gerenciadorasContas.transfereValor(idConta01, 200, idConta02, 200);
		
		//verificações
		//assegure que success=true
		assertTrue(sucesso);
		//assegure o que o saldo da conta 1 seja -300
		assertThat(conta01.getSaldo(), is(-300.0));
		//assegure o que o saldo da conta 2 seja 100
		assertThat(conta02.getSaldo(), is(100.0));
	}
	
	/**
	 * Teste básico da tentativa de transferência de um valor zerado da conta de um cliente para outro.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testTransfereValor_Nenhum() {
		System.out.println("     Teste básico da tentativa de transferência de um valor zerado da conta de um cliente para outro");
		//montagem do cenário
		//criando algumas contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		//inserindo as contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		boolean sucesso = gerenciadorasContas.transfereValor(idConta01, 0, idConta02, 0);
		
		//verificações
		//assegure que success=true
		assertFalse(sucesso);
		//assegure o que o saldo da conta 1 seja -100
		assertThat(conta01.getSaldo(), is(-100.0));
		//assegure o que o saldo da conta 2 seja -100
		assertThat(conta02.getSaldo(), is(-100.0));
	}
	
	/**
	 * Teste básico da tentativa de transferência de um pequeno valor da conta de um cliente para outro.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	
	@Test
	public void testTransfereValor_Nenhum_02() {
		System.out.println("     Teste básico da tentativa de transferência de um pequeno valor da conta de um cliente para outro");
		//montagem do cenário
		//criando algumas contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		//inserindo as contas criados na lista de contas do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerenciadorasContas = new GerenciadoraContas(contasDoBanco);

		//execução
		boolean sucesso = gerenciadorasContas.transfereValor(idConta01, 2, idConta02, 2);
		
		//verificações
		//assegure que success=true
		assertTrue(sucesso);
		//assegure o que o saldo da conta 1 seja -102
		assertThat(conta01.getSaldo(), is(-102.0));
		//assegure o que o saldo da conta 2 seja -98
		assertThat(conta02.getSaldo(), is(-98.0));
	}
	
}
//Cálculos matemáticos e financeiros