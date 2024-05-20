package br.com.fiapmsentrega.domain.shared;

public interface IExecuteArgs<T, J> {
    T execute(J domainObject);
}
