package br.com.fiap.jpa.view;

import java.util.Calendar;

import br.com.fiap.entity.FormaPagamento;
import br.com.fiap.jpa.dao.PagamentoDAO;
import br.com.fiap.jpa.entity.Pagamento;
import br.com.fiap.jpa.exception.FailCommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.impl.PagamentoDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleViewPagamento {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PagamentoDAO dao = new PagamentoDAOImpl(em);
		Pagamento pagamento = new Pagamento(1,Calendar.getInstance(),90.00,FormaPagamento.CREDITO);
		
		try {
			dao.create(pagamento);
			dao.commit();
			System.out.println("Pagamento realizado");
		}catch(FailCommitException e) {
			System.out.println("Falha ao realizar pagamento");
		}
		
		try {
			Pagamento busca = dao.read(1);
			System.out.println(busca.getCodigo());
		}catch(KeyNotFoundException e) {
			System.out.println("Código não localizado");
		}
		
		try {
			pagamento.setValor(95.00);
			dao.update(pagamento);
			dao.commit();
			System.out.println("Valor atualizado");
		}catch(FailCommitException e) {
			System.out.println("Valor não atualizado");
		}
		
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Pagamento removido");
		}catch(KeyNotFoundException e) {
			System.out.println("Não foi possível localizar o pagamento");
		}catch(FailCommitException e) {
			System.out.println("Falha ao remover o pagamento");
		}
		
		em.close();
		fabrica.close();

	}

}
