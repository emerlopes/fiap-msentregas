package br.com.fiapmsentrega.infrastructure.database.service;


import br.com.fiapmsentrega.domain.entity.EntregaDomainEntity;
import br.com.fiapmsentrega.domain.repository.PedidoDomainRepository;
import br.com.fiapmsentrega.infrastructure.database.entity.EntregaEntity;
import br.com.fiapmsentrega.infrastructure.database.repository.EntregaRepository;
import org.springframework.stereotype.Service;

@Service
public class EntregaDomainRepositoryImpl implements PedidoDomainRepository {

    private final EntregaRepository entregaRepository;

    public EntregaDomainRepositoryImpl(
            final EntregaRepository entregaRepository
    ) {
        this.entregaRepository = entregaRepository;
    }

    @Override
    public EntregaDomainEntity cadastrarEntrega(
            final EntregaDomainEntity entregaDomainEntity
    ) {
        final var entregaRequestEntity = new EntregaEntity()
                .setIdCliete(entregaDomainEntity.getIdCliete())
                .setIdPedido(entregaDomainEntity.getIdPedido())
                .setEnderecoEntrega(entregaDomainEntity.getEnderecoEntrega())
                .setDataEntrega(entregaDomainEntity.getDataEntrega());

        final var entregaResponseEntity = entregaRepository.save(entregaRequestEntity);

        return EntregaDomainEntity.paraEntidadeDominio(entregaResponseEntity);
    }
}
