package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;
	
	public static void main(String[] args) {
		
		inicializaSistemaBancario(); //criando algumas contas e clientes fictícios
		
		Scanner sc = new Scanner(System.in);
		boolean continua = true;
		
		while (continua) {
			
			printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
			//Consultar por um cliente
			case 1:
				System.out.print("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = gerClientes.pesquisaCliente(idCliente);
				
				if(cliente != null)
					System.out.println(cliente.toString());
				else
					System.out.println("Cliente não encontrado!");
				
				pulalinha();
				break;

			//Consultar por uma conta corrente
			case 2:
				System.out.print("Digite o ID da conta: ");
				int idConta = sc.nextInt();
				ContaCorrente conta = gerContas.pesquisaConta(idConta);
				
				if(conta != null)
					System.out.println(conta.toString());
				else
					System.out.println("Conta não encontrado!");
				
				pulalinha();
				break;

			//Ativar um cliente
			case 3:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente2 = sc.nextInt();
				Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);
				
				if(cliente2 != null){
					cliente2.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				}
				else
					System.out.println("Cliente não encontrado!");
			
				pulalinha();
				break;
				
			//Desativar um cliente
			case 4:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente3 = sc.nextInt();
				Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);
				
				if(cliente3 != null){
					cliente3.setAtivo(false);
					System.out.println("Cliente desativado com sucesso!");
				}
				else
					System.out.println("Cliente não encontrado!");
				
				pulalinha();
				break;
			
			//Testes
			case 5:
				System.out.println("Todos os testes serão executados");
				testes();
				System.out.print("Testes finalizados\n");
				pulalinha();
				break;
				
			//Sair
			case 6:
				continua = false;
				System.out.println("################# Sistema encerrado #################");
				break;
				
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			} 
		}
		sc.close();
	}

	private static void pulalinha() {
		System.out.println("\n");
	}

	/**
	 * Imprime menu de opções do nosso sistema bancário
	 */
	private static void printMenu() {
		
		System.out.println("O que você deseja fazer? \n");
		System.out.println("1) Consultar por um cliente(Há 2 clientes: id=1 e id=2)");
		System.out.println("2) Consultar por uma conta corrente (Há 2 c/c: id=1 e id=2)");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Executar os testes unitários");
		System.out.println("6) Sair");
		System.out.println();
		
	}

	/**
	 * Método que cria e insere algumas contas e clientes no sistema do banco,
	 * apenas para realização de testes manuais através do método main acima.
	 */
	private static void inicializaSistemaBancario() {
		//criando lista vazia de contas e clientes
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();
		
		//criando e inserindo duas contas na lista de contas correntes do banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		//criando dois clientes e associando as contas criadas acima a eles
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", conta02.getId(), true);
		//inserindo os clientes criados na lista de clientes do banco
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);
		
	}
	
	public static void testes() {
		System.out.println("Iniciando os testes...");
		System.out.println("  Testes para clientes e contas...");

        //classe de test com todos os testes 
        Result result = JUnitCore.runClasses(TodosOsTestes.class);

        //exibe resultados no console
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("  Todos os testes passaram com sucesso!");
        }
        else {
            System.out.println("  Testes falharam: " + result.getFailureCount());
        }
	}
}

