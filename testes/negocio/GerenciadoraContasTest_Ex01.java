package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest_Ex01 {

	private GerenciadoraContas gerenciadorasContas;
	
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
		gerenciadorasContas.transfereValor(1, 100, 2, 0);
		
		//verificações
		//assegure o que o saldo da conta 2 seja 100
		assertThat(conta02.getSaldo(), is(100.0));
		//assegure o que o saldo da conta 1 seja 100
		assertThat(conta01.getSaldo(), is(100.0));
	}
}
