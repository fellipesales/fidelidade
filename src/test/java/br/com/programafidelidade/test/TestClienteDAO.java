package br.com.programafidelidade.test;

import br.com.programafidelidade.DAO.ClienteDAO;
import br.com.programafidelidade.model.Cliente;

public class TestClienteDAO {

	public static void main(String[] args) {

		// testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		testeBuscaPorId();
	}

	public static void testeCadastrar() {

		Cliente cliente = new Cliente();

		cliente.setCPF("12250891745");
		cliente.setNome("Fellipe da Silva Sales");
		cliente.setContato("22 9 9963 0582");

		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.cadastrarCliente(cliente);
	}

	public static void testeAlterar() {

		Cliente cliente = new Cliente();

		cliente.setId(1);
		cliente.setCPF("12345678900");
		cliente.setNome("Fellipe Sales");
		cliente.setContato("fellipesales@gmail.com");

		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.alterarCliente(cliente);
	}
	
	public static void testeExcluir(){
		
		Cliente cliente = new Cliente();
		
		cliente.setId(2);
		
		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.excluirClient(cliente);
	}
	
	public static void testeBuscaPorId(){
		
		ClienteDAO cliDAO = new ClienteDAO();
		Cliente cliente = cliDAO.buscaPorID(1);
		System.out.println(cliente);
		
	}
}
