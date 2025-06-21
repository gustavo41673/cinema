package br.edu.fiec.cinema_project.service;

import br.edu.fiec.cinema_project.model.dto.SalasDTO;
import br.edu.fiec.cinema_project.model.entity.Ingressos;
import br.edu.fiec.cinema_project.model.entity.Salas;
import br.edu.fiec.cinema_project.repository.SalaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class SalasService {

    private SalaRepository salaRepository;

    public Salas create(SalasDTO dto) {
        Salas salas = new Salas();
        salas.setNome(dto.getNome());
        salas.setCapacidade(dto.getCapacidade());
        salas.setId_sala(dto.getId_sala());
        salas.setTipo_sala(dto.getTipo_sala());

        return salaRepository.save(salas);
    }

    public Salas getById(Integer id) {
        return salaRepository.findById(id).map(salas ->
                 new Salas(
                         salas.getId_sala(),
                         salas.getNome(),
                         salas.getCapacidade(),
                         salas.getTipo_sala()
                 )
                ).orElse(null);
    }

    public Stream<Object> getByNome(String nome){
        return salaRepository.findByNome(nome).stream().map(salas ->
                new Salas(
                        salas.getId_sala(),
                        salas.getNome(),
                        salas.getCapacidade(),
                        salas.getTipo_sala()
                )
        );
    }

    public Salas createSala(Salas sala) {
        sala.setId_sala(null); // evita conflito de ID
        return salaRepository.save(sala);
    }

    public List<Salas> buscarPorCapacidadeMinima(int capacidade) {
        List<Salas> resultado = new ArrayList<>();
        for (Salas sala : salaRepository.findByCapacidade(capacidade)) {
            resultado.add(new Salas(
                    sala.getId_sala(),
                    sala.getNome(),
                    sala.getCapacidade()
            ));
        }
        return resultado;
    }
    public void delete(Integer id){
        Salas salaEncontrada = salaRepository.findById(id).map(salas ->
                new Salas(
                        salas.getId_sala(),
                        salas.getNome(),
                        salas.getCapacidade(),
                        salas.getTipo_sala()
                )
        ).orElse(null);

        assert salaEncontrada != null: "é nulo";
        salaRepository.delete(salaEncontrada);
    }

    public void deleteAll(){
        salaRepository.deleteAll();
    }
}



