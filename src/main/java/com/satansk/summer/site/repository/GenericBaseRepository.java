package com.satansk.summer.site.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericBaseRepository<I extends Serializable, E extends Serializable> implements GenericRepository<I, E> {
	
	protected final Class<I> idClass;
	protected final Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericBaseRepository() {
		
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		
		while (! (genericSuperclass instanceof Class)) {
			
			if (! (genericSuperclass instanceof Class)) {
				throw new IllegalStateException();
			}
			
			if (genericSuperclass == GenericBaseRepository.class) {
				throw new IllegalStateException();
			}
			
			genericSuperclass = ((Class)genericSuperclass).getGenericSuperclass();
		}
		
		ParameterizedType type = (ParameterizedType) genericSuperclass;
		
		Type[] arguments = type.getActualTypeArguments();
		
		this.idClass = (Class<I>) arguments[0];
		this.entityClass = (Class<E>) arguments[1];
	}
}
