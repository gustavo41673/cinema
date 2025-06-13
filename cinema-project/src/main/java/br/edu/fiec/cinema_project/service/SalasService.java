package br.edu.fiec.cinema_project.service;

import br.edu.fiec.cinema_project.model.dto.SalasDTO;
import br.edu.fiec.cinema_project.model.enty.Salas;
import br.edu.fiec.cinema_project.repository.SalaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
