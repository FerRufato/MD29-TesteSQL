package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import br.com.feRufato.dao.generic.jdbc.dao.ClienteDAO;
import br.com.feRufato.dao.generic.jdbc.dao.IClienteDAO;
import br.com.feRufato.domin.Cliente;
import org.junit.Before;
import org.junit.Test;



public class ClienteTest {//classe ClienteTest


    private IClienteDAO clienteDAO; //declarando a interface IClienteDAO


    @Test
    public void cadastrarTest() throws Exception {//
        clienteDAO = new ClienteDAO();//instanciando a classe ClienteDAO

        Cliente cliente = new Cliente();//instanciando a classe Cliente
        cliente.setCodigo("10");//setando o código do cliente
        cliente.setNome("Fernanda Rufato");//setando o nome do cliente
        Integer countCad = clienteDAO.cadastrar(cliente);//cadastrando o cliente
        assertTrue(countCad == 1);//verificando se o cliente foi cadastrado

        Cliente clienteBD = clienteDAO.buscar("10");//buscando o cliente
        assertNotNull(clienteBD);//verificando se o cliente foi encontrado
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());//verificando se o código do cliente é igual ao código do cliente encontrado
        assertEquals(cliente.getNome(), clienteBD.getNome());//verificando se o nome do cliente é igual ao nome do cliente encontrado

        Integer countDel = clienteDAO.excluir(clienteBD);//excluindo o cliente
        assertTrue(countDel == 1);//verificando se o cliente foi excluído
    }

    @Test
    public void buscarTest() throws Exception {//método buscarTest
        clienteDAO = new ClienteDAO();//instanciando a classe ClienteDAO

        Cliente cliente = new Cliente();//instanciando a classe Cliente
        cliente.setCodigo("10");//setando o código do cliente
        cliente.setNome("Fernanda Rufato");//setando o nome do cliente
        Integer countCad = clienteDAO.cadastrar(cliente);//cadastrando o cliente
        assertTrue(countCad == 1);//verificando se o cliente foi cadastrado

        Cliente clienteBD = clienteDAO.buscar("10");//buscando o cliente
        assertNotNull(clienteBD);//verificando se o cliente foi encontrado
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());//verificando se o código do cliente é igual ao código do cliente encontrado
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Fernanda Rufato");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Fernanda Rufato");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clientes = new Cliente();
        clientes.setCodigo("20");
        clientes.setNome("Teste");
        Integer countCad2 = clienteDAO.cadastrar(clientes);
        assertTrue(countCad2 == 1);

        List<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = clienteDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Fernanda Rufato");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("Outro nome");
        Integer countUpdate = clienteDAO.atualizar(clienteBD);
        assertTrue(countUpdate == 1);

        Cliente clienteBD1 = clienteDAO.buscar("10");
        assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDAO.buscar("20");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
        }
    }
}