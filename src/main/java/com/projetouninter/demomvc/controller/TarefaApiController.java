package com.projetouninter.demomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetouninter.demomvc.service.TarefaService;
import com.projetouninter.demomvc.entity.Tarefa;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaApiController {

    @Autowired
    private TarefaService service;

    @GetMapping
    public List<Tarefa> listar() {
        return service.buscaTodos();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa tarefa) {
        return service.salvar(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> editar(@PathVariable("id") Long id, @RequestBody Tarefa tarefa) {
        Tarefa existente = service.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        existente.setNome(tarefa.getNome());
        existente.setDataEntrega(tarefa.getDataEntrega());
        existente.setResponsavel(tarefa.getResponsavel());
        Tarefa atualizado = service.editar(existente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        service.excluir(id);
    }
}
