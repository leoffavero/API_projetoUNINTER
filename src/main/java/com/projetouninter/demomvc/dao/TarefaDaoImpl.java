package com.projetouninter.demomvc.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.projetouninter.demomvc.entity.Tarefa;

@Repository
public class TarefaDaoImpl extends AbstractDao<Tarefa, Long> implements TarefaDao {

    @Override
    public void save(Tarefa tarefa) {
        super.save(tarefa);
    }

    @Override
    public void update(Tarefa tarefa) {
        super.update(tarefa);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public Tarefa findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Tarefa> findAll() {
        return super.findAll();
    }
}
