package br.com.fiapmsentrega.application.entrypoint.rest.dto;

import br.com.fiapmsentrega.domain.entity.EntregaDomainEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntregaResponseDTO {

    @JsonProperty("id_entrega")
    private Long idEntrega;

    @JsonProperty("id_cliente")
    private UUID idCliete;

    @JsonProperty("id_pedido")
    private Long idPedido;

    @JsonProperty("data_entrega")
    private LocalDate dataEntrega;

    @JsonProperty("endereco_entrega")
    private String enderecoEntrega;

    public static EntregaResponseDTO paraResponseDTO(
            final EntregaDomainEntity entregaDomainEntity
    ) {
        return EntregaResponseDTO.builder()
                .idEntrega(entregaDomainEntity.getIdEntrega())
                .idCliete(entregaDomainEntity.getIdCliete())
                .idPedido(entregaDomainEntity.getIdPedido())
                .dataEntrega(entregaDomainEntity.getDataEntrega())
                .enderecoEntrega(entregaDomainEntity.getEnderecoEntrega())
                .build();
    }
}
