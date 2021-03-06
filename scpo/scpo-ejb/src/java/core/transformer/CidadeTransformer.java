/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.transformer;

import api.dto.CidadeDTO;
import api.dto.DTOTransformer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import core.modelo.Cidade;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author erick.araujo
 */
@ApplicationScoped
public class CidadeTransformer implements DTOTransformer<Cidade, CidadeDTO> {

    @Inject
    private EstadoTransformer estadoTransformer;

    @Override
    public Cidade toEntity(CidadeDTO dto) {
        if (dto == null) {
            return null;
        }

        final Cidade cidade = new Cidade();
        cidade.setId(dto.getId());
        cidade.setLocalidade(dto.getLocalidade());
        cidade.setEstado(estadoTransformer.toEntity(dto.getUf()));
        cidade.setIbge(dto.getIbge());

        return cidade;
    }

    @Override
    public CidadeDTO toDTO(Cidade entity) {
        if (entity == null) {
            return null;
        }

        final CidadeDTO cidade = new CidadeDTO();
        cidade.setId(entity.getId());
        cidade.setLocalidade(entity.getLocalidade());
        cidade.setIbge(entity.getIbge());
        cidade.setUf(estadoTransformer.toDTO(entity.getEstado()));

        return cidade;
    }

    public List<Cidade> toEntityList(List<CidadeDTO> dtos) {
        List<Cidade> cidades = new ArrayList();

        for (CidadeDTO dto : dtos) {
            cidades.add(toEntity(dto));
        }

        return cidades;
    }

    public List<CidadeDTO> toDTOList(List<Cidade> entidades) {
        List<CidadeDTO> dtos = new ArrayList();

        for (Cidade cidade : entidades) {
            dtos.add(toDTO(cidade));
        }

        return dtos;
    }
}
