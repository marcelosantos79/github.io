package br.com.tt.petshopmil.dao;

import java.util.List;

public interface Idao <T>{
	
	void salvar(T entity);
	
	T buscar(Long id);
	
	T bucar(T t);
	
	List<T> consultar();

	List<T> consultar(T t);

	void deletar(Long id);
	
	void deletar(T entity);
}
