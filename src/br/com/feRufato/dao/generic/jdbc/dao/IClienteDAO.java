package br.com.feRufato.dao.generic.jdbc.dao;

import br.com.feRufato.domin.Cliente;

import java.util.List;

public interface IClienteDAO {

    Integer cadastrar(Cliente cliente) throws Exception;

    Integer atualizar(Cliente cliente) throws Exception;

    Integer buscar(Cliente cliente) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

    Cliente buscar(String codigo) throws Exception;

    Integer excluir(Cliente cliente) throws Exception;

}