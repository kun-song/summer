package com.satansk.summer.site.repository;

import java.io.Serializable;

public interface GenericRepository<I extends Serializable, E extends Serializable> {
	
	Iterable<E> getAll();
	
	E get(I id);
	
	void add(E entity);
	
	void update(E entity);
	
	void delete(E entity);
	
	void deleteById(I id);
}
