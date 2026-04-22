package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex01 {
	@Test
	public void testPesquisaCliente() {
		//criando alguns clientes - montagem do cenário do teste
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//execução
		Cliente cliente = gerenciadoraClientes.pesquisaCliente(1);
		//verificações
		//assegure que o id do cliente tenha 1
		assertThat(cliente.getId(), is(1));
		//assegure que o e-mail do cliente seja gugafarias@gmail.com
		assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));
	}
}
