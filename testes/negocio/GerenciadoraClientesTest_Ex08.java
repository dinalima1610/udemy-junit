package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Gustavo Farias
 * @author Diná Lima
 * @date 21/04/2026
 */
public class GerenciadoraClientesTest_Ex08 {

	private GerenciadoraClientes gerenciadoraClientes;
	private int idCLiente01 = 1;
	private	int idCLiente02 = 2;
	
	@Before
	public void setUp() {
		//montagem do cenário do teste
		//criando alguns clientes
		Cliente cliente01 = new Cliente(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerenciadoraClientes.limpa();
	}
	
	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testPesquisaCliente() {
		System.out.println("     Teste básico da pesquisa de um cliente a partir do seu ID");
		//execução
		Cliente cliente = gerenciadoraClientes.pesquisaCliente(idCLiente01);
		
		//verificações
		//assegure que o id do cliente é 1
		assertThat(cliente.getId(), is(idCLiente01));
		
	}
	
	/**
	 * Teste básico da pesquisa por um cliente que não existe.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testPesquisaClienteInexistente() {
		System.out.println("     Teste básico da pesquisa por um cliente que não existe");
		//execução
		Cliente cliente = gerenciadoraClientes.pesquisaCliente(1001);
		
		//verificações
		assertNull(cliente);
	}
	
	/**
	 * Teste básico da remoção de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testRemoveCliente() {
		System.out.println("     Teste básico da remoção de um cliente a partir do seu ID");
		//execução
		boolean clienteRemovido = gerenciadoraClientes.removeCliente(idCLiente02);
		
		//verificações
		//assegure que clienteRemovido=true
		assertThat(clienteRemovido, is(true));
		//assegure que o tamanho da lista é 1
		assertThat(gerenciadoraClientes.getClientesDoBanco().size(), is(1));
		//assegure que o retorno da pesquisa do id=2 seja nulo
		assertNull(gerenciadoraClientes.pesquisaCliente(idCLiente02));
	}
	
	/**
	 * Teste da tentativa de remoção de um cliente inexistente.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 21/04/2026
	 */
	@Test
	public void testRemoveClienteInexistente() {
		System.out.println("     Teste da tentativa de remoção de um cliente inexistente");
		//execução
		boolean clienteRemovido = gerenciadoraClientes.removeCliente(1001);
		
		//verificações
		//assegure que clienteRemovido=false
		assertThat(clienteRemovido, is(false));
		//assegure que o tamanho da lista é 2
		assertThat(gerenciadoraClientes.getClientesDoBanco().size(), is(2));
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/04/2026
	 */
	@Test
	public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {
		System.out.println("     Validação da idade de um cliente quando a mesma está no intervalo permitido para a abertura de conta");
		//montagem do cenário do teste		
		Cliente cliente = new Cliente(1, "Gustavo", 25, "guga@gmail.com", 1, true);
		
		//execução
		boolean idadeValida = gerenciadoraClientes.validaIdade(cliente.getIdade());
		
		//verificações
		//assegure que idadeValida=true
		assertTrue(idadeValida);	
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/04/2026
	 */
	@Test
	public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {
		System.out.println("     Validação da idade mínima de um cliente quando a mesma está no intervalo permitido para a abertura de conta");
		//montagem do cenário do teste
		Cliente cliente = new Cliente(1, "Gustavo", 18, "guga@gmail.com", 1, true);
		
		//execução
		boolean idadeValida = gerenciadoraClientes.validaIdade(cliente.getIdade());
		
		//verificações
		//assegure que idadeValida=true
		assertTrue(idadeValida);	
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/04/2026
	 */
	@Test
	public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {
		System.out.println("     Validação da idade máxima de um cliente quando a mesma está no intervalo permitido para a abertura de conta");
		//montagem do cenário do teste		
		Cliente cliente = new Cliente(1, "Gustavo", 65, "guga@gmail.com", 1, true);
		
		//execução
		boolean idadeValida = gerenciadoraClientes.validaIdade(cliente.getIdade());
		
		//verificações
		//assegure que idadeValida=true
		assertTrue(idadeValida);	
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está abaixo intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/04/2026
	 */
	@Test
	public void testClienteIdadeAceitavel_04() throws IdadeNaoPermitidaException {
		System.out.println("     Validação da idade de um cliente quando a mesma está abaixo da mínima permitida permitido para a abertura de conta");
		//montagem do cenário do teste		
		Cliente cliente = new Cliente(1, "Gustavo", 17, "guga@gmail.com", 1, true);

		//execução
		try {
			gerenciadoraClientes.validaIdade(cliente.getIdade());
			fail();
		}
		catch (Exception e) {
			//verificações
			//assegure que foi lançada a exceção correta
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}	
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está acima intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/04/2026
	 */
	@Test
	public void testClienteIdadeAceitavel_05() throws IdadeNaoPermitidaException {
		System.out.println("     Validação da idade de um cliente quando a mesma está acima da mínima permitida permitido para a abertura de conta");
		//montagem do cenário do teste
		Cliente cliente = new Cliente(1, "Gustavo", 66, "guga@gmail.com", 1, true);
		//execução
		try {
			gerenciadoraClientes.validaIdade(cliente.getIdade());
			fail();
		}
		catch (Exception e) {
			//verificações
			//assegure que foi lançada a exceção correta
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}	
	}
}

// Valores Limites