package br.com.programafidelidade.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.programafidelidade.model.Cliente;

public class ClienteDAO {

	private Connection con = ConexaoFactory.getConection();

	/**
	 * Cadastra clientes no banco de dados
	 * 
	 * @param cliente
	 *            Objeto usuário passado como parâmetro para ser salvo no banco
	 */
	public void cadastrarCliente(Cliente cliente) {
		String sql = "insert into cliente (cpf, nome, contato) values (?,?,?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setString(1, cliente.getCPF());
			preparador.setString(2, cliente.getNome());
			preparador.setString(3, cliente.getContato());

			preparador.execute();

			System.out.println("Cadastrado com sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Altera os dados de um Cliente no banco de dados
	 * 
	 * @param cliente
	 *            ID do cliente usado como parametro para modificação no banco
	 */
	public void alterarCliente(Cliente cliente) {
		String sql = "update cliente set cpf=?, nome=?, contato=? where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setString(1, cliente.getCPF());
			preparador.setString(2, cliente.getNome());
			preparador.setString(3, cliente.getContato());
			preparador.setInt(4, cliente.getId());

			preparador.execute();

			System.out.println("Alterado com Sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirClient(Cliente cliente) {
		String sql = "delete from cliente where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setInt(1, cliente.getId());
			preparador.execute();
			System.out.println("Excluido com sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cliente buscaPorID(int id) {
		String sql = "select * from cliente where id="+id;
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			ResultSet rs = preparador.executeQuery(sql);
			
			if(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setContato(rs.getString("contato"));
				return cliente;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
