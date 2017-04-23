package com.satansk.summer.site.repository.impl;

import org.springframework.stereotype.Repository;

import com.satansk.summer.site.entity.Author;
import com.satansk.summer.site.repository.AuthorRepository;
import com.satansk.summer.site.repository.GenericJpaRepository;

@Repository
public class DefaultAuthorRepository extends GenericJpaRepository<Long, Author> implements AuthorRepository {
	
}