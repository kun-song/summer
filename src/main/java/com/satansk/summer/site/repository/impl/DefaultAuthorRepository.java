package com.satansk.summer.site.repository.impl;

import com.satansk.summer.site.entity.Author;
import com.satansk.summer.site.repository.AuthorRepository;
import com.satansk.summer.site.repository.GenericJpaRepository;

public class DefaultAuthorRepository extends GenericJpaRepository<Long, Author> implements AuthorRepository {
	
}