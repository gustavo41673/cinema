package br.edu.fiec.cinema_project.service;
import br.edu.fiec.cinema_project.model.enty.Ingressos;
import br.edu.fiec.cinema_project.repository.IngressoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.edu.fiec.cinema_project.model.dto.IngressoDTO;

import java.util.stream.Stream;


@Service
@AllArgsConstructor
public class IngressoService {

        private IngressoRepository ingressoRepository;

    public Ingressos create(IngressoDTO dto) {
        Ingressos ingresso = new Ingressos();
        ingresso.setNameCliente(dto.getNameCliente());
        ingresso.setAssento(dto.getAssento());
        ingresso.setValor(dto.getValor());
        // Copie todos os campos relevantes do DTO para a entidade

        return ingressoRepository.save(ingresso);
    }

        public Ingressos getById(Integer id) {
            return ingressoRepository.findById(id).map(ingressos ->
                new Ingressos(
                        ingressos.getId_ingresso(),
                        ingressos.getId_sessao(),
                        ingressos.getNameCliente(),
                        ingressos.getAssento(),
                        ingressos.getTipo_ingresso(),
                        ingressos.getStatus(),
                        ingressos.getValor()
                )
            ).orElse(null);
        }

        public Stream<Object> getByNome(String nome_cliente){
            return ingressoRepository.findByNameCliente(nome_cliente).stream().map(ingressos ->
              new Ingressos(
                      ingressos.getId_ingresso(),
                      ingressos.getId_sessao(),
                      ingressos.getNameCliente(),
                      ingressos.getAssento(),
                      ingressos.getTipo_ingresso(),
                      ingressos.getStatus(),
                      ingressos.getValor()
              )
            );
        }
    }


