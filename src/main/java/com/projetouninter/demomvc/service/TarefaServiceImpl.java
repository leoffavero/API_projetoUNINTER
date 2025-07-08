package com.projetouninter.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetouninter.demomvc.dao.TarefaDao;
import com.projetouninter.demomvc.entity.Tarefa;



@Service
@Transactional(readOnly=false)
public class TarefaServiceImpl implements TarefaService {
	
	@Autowired
	private TarefaDao dao;

	@Override
	public Tarefa salvar(Tarefa tarefa) {
		dao.save(tarefa);
		return tarefa;
		

	}

	@Override
	public Tarefa editar(Tarefa tarefa) {
		dao.update(tarefa);
		return tarefa;

	}

	@Override
	public void excluir(Long id) {
	    Tarefa tarefa = dao.findById(id);
	    if (tarefa == null) {
	        throw new RuntimeException("Tarefa não encontrada com id: " + id);
	    }
	    dao.delete(id);
	}



	@Override
	@Transactional(readOnly=true)
	public Tarefa buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Tarefa> buscaTodos() {
		return dao.findAll();
	}

}
