package br.edu.fiec.cinema_project.service;
import br.edu.fiec.cinema_project.model.enty.Ingressos;
import br.edu.fiec.cinema_project.repository.IngressoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.edu.fiec.cinema_project.model.dto.IngressoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
public class IngressoService {

        private IngressoRepository ingressoRepository;

    public Ingressos create(IngressoDTO dto) {
        float valor = 30F;
        if(dto.getTipo_ingresso().equalsIgnoreCase("Meia")){
            valor = 15;
        }
        Ingressos ingresso = new Ingressos(
                null, // id_ingresso (gerado automaticamente)
                dto.getId_sessao(),
                dto.getNameCliente(),
                dto.getAssento(),
                dto.getTipo_ingresso(),
                "ativo",
                valor

        );
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

    public List<Ingressos> getByNome(String nome_cliente){
        List<Ingressos> ingressosList = new ArrayList<>();
        ingressoRepository.findAll().forEach(ingressos->{
            if(ingressos.getNameCliente().equalsIgnoreCase(nome_cliente)){
                ingressosList.add(new Ingressos(
                    ingressos.getId_ingresso(),
                    ingressos.getId_sessao(),
                    ingressos.getNameCliente(),
                    ingressos.getAssento(),
                    ingressos.getTipo_ingresso(),
                    ingressos.getStatus(),
                    ingressos.getValor()
                ));
            }
        });
        return ingressosList;
    }

    public List<Ingressos> getAll(){
        List<Ingressos> listaDeIngressos = new ArrayList<>();
        ingressoRepository.findAll().forEach(ingressos -> {
            listaDeIngressos.add(new Ingressos(
                    ingressos.getId_ingresso(),
                    ingressos.getId_sessao(),
                    ingressos.getNameCliente(),
                    ingressos.getAssento(),
                    ingressos.getTipo_ingresso(),
                    ingressos.getStatus(),
                    ingressos.getValor()
            ));
        });
        return listaDeIngressos;
    }

    public void delete(Integer id){
        Ingressos ingressosEncontrado = ingressoRepository.findById(id).map(ingressos ->
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
        assert ingressosEncontrado != null: "é nulo";
        ingressoRepository.delete(ingressosEncontrado);
    }

    public void deleteAll(){
        ingressoRepository.deleteAll();
    }
}


