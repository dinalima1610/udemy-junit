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
public class GerenciadoraClientesTest_Ex04 {

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
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//execução
		Cliente cliente = gerenciadoraClientes.pesquisaCliente(1);
		//verificações
		//assegure que o id do cliente tenha 1
		assertThat(cliente.getId(), is(1));
		//assegure que o e-mail do cliente seja gugafarias@gmail.com
		assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));
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
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//execução
		boolean clienteRemovido = gerenciadoraClientes.removeCliente(2);
		//verificações
		//assegure que o id do cliente removido seja true
		assertThat(clienteRemovido, is(true));
		//assegure que o tamanho da lista de clientes é 1
		assertThat(gerenciadoraClientes.getClientesDoBanco().size(), is(1));
		//segure que o retorno para a pesquisa do id =2 seja nulo
		assertNull(gerenciadoraClientes.pesquisaCliente(2));
	}
}

//Documentação e comentários