package br.com.fiapmsentrega.domain.entity;


import br.com.fiapmsentrega.infrastructure.database.entity.EntregaEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class EntregaDomainEntity {

    private Long idEntrega;
    private UUID idCliete;
    private UUID idPedido;

    @Setter
    private LocalDate dataEntrega;

    private String enderecoEntrega;

    public static EntregaDomainEntity paraEntidadeDominio(
            final EntregaEntity entregaEntity
    ) {
        return EntregaDomainEntity.builder()
                .idEntrega(entregaEntity.getIdEntrega())
                .idCliete(entregaEntity.getIdCliete())
                .idPedido(entregaEntity.getIdPedido())
                .dataEntrega(entregaEntity.getDataEntrega())
                .enderecoEntrega(entregaEntity.getEnderecoEntrega())
                .build();
    }

}
