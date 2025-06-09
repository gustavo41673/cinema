package br.edu.fiec.cinema_project.service;
import br.edu.fiec.cinema_project.model.enty.Ingressos;
import br.edu.fiec.cinema_project.repository.IngressoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


    @Service
    @AllArgsConstructor
    public class IngressoService {

        private IngressoRepository ingressoRepository;


        public Ingressos getById(Integer id) {
            return ingressoRepository.findById(id).map(ingressos ->
                new Ingressos(
                        ingressos.getId_ingresso(),
                        ingressos.getId_sessao(),
                        ingressos.getNome_cliente(),
                        ingressos.getAssento(),
                        ingressos.getTipo_ingresso(),
                        ingressos.getStatus(),
                        ingressos.getValor()
                )
            ).orElse(null);
        }
    }


