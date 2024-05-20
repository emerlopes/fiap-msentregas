package br.com.fiapmsentrega.application.entrypoint.rest.dto;


import br.com.fiapmsentrega.domain.entity.EntregaDomainEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntregaRequestDTO {

    @JsonProperty("id_cliente")
    private UUID idCliente;

    @JsonProperty("id_pedido")
    private Long idPedido;

    @JsonProperty("endereco_entrega")
    private String enderecoEntrega;


    public static EntregaDomainEntity paraEntidadeDominio(
            final EntregaRequestDTO entregaRequestDTO
    ) {
        return EntregaDomainEntity.builder()
                .idCliete(entregaRequestDTO.getIdCliente())
                .idPedido(entregaRequestDTO.getIdPedido())
                .enderecoEntrega(entregaRequestDTO.getEnderecoEntrega())
                .build();
    }

}
