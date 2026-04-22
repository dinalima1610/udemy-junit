package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Gustavo Farias
 * @author Diná Lima
 * @date 20/04/2026
 */
public class GerenciadoraClientesTest_Ex05 {

	private GerenciadoraClientes gerenciadoraClientes;

	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 20/04/2026
	 */
	@Test
	public void testPesquisaCliente() {
		//criando alguns clientes - montagem do cenário do teste
		int idCliente01 = 1;
		int idCliente02 = 2;
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", idCliente01, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", idCliente02, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//execução
		Cliente cliente = gerenciadoraClientes.pesquisaCliente(idCliente01);
		
		//verificações
		//assegure que o id do cliente tenha 1
		assertThat(cliente.getId(), is(idCliente01));
	}
	
	/**
	 * Teste básico da remoção de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @author Diná Lima
	 * @date 20/04/2026
	 */
	@Test
	public void testRemoveCliente() {
		//criando alguns clientes - montagem do cenário do teste
		int idCliente01 = 1;
		int idCliente02 = 2;
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", idCliente01, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", idCliente02, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//execução
		boolean clienteRemovido = gerenciadoraClientes.removeCliente(idCliente02);
		//verificações
		//assegure que o id do cliente removido seja true
		assertThat(clienteRemovido, is(true));
		//assegure que o tamanho da lista de clientes é 1
		assertThat(gerenciadoraClientes.getClientesDoBanco().size(), is(1));
		//segure que o retorno para a pesquisa do id =2 seja nulo
		assertNull(gerenciadoraClientes.pesquisaCliente(idCliente02));
	}
	
}
