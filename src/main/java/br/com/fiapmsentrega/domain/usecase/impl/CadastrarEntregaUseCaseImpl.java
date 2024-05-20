package br.com.fiapmsentrega.domain.usecase.impl;

import br.com.fiapmsentrega.domain.entity.EntregaDomainEntity;
import br.com.fiapmsentrega.domain.repository.PedidoDomainRepository;
import br.com.fiapmsentrega.domain.usecase.CadastrarEntregaUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CadastrarEntregaUseCaseImpl implements CadastrarEntregaUseCase {

    private final PedidoDomainRepository pedidoDomainRepository;

    public CadastrarEntregaUseCaseImpl(
            final PedidoDomainRepository pedidoDomainRepository
    ) {
        this.pedidoDomainRepository = pedidoDomainRepository;
    }

    @Override
    public EntregaDomainEntity execute(
            final EntregaDomainEntity entrega
    ) {
        final var dataEntrega = this.calcularDataEntrega(entrega.getEnderecoEntrega());
        entrega.setDataEntrega(dataEntrega);
        return pedidoDomainRepository.cadastrarEntrega(entrega);
    }

    private LocalDate calcularDataEntrega(
            final String endereco
    ) {
        return LocalDate.now().plusDays(3);
    }
}
