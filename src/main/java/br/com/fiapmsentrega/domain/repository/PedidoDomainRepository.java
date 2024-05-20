package br.com.fiapmsentrega.domain.repository;

import br.com.fiapmsentrega.domain.entity.EntregaDomainEntity;

public interface PedidoDomainRepository {

    EntregaDomainEntity cadastrarEntrega(EntregaDomainEntity entregaDomainEntity);
}
