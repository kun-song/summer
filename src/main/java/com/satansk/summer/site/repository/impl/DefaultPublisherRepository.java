package com.satansk.summer.site.repository.impl;

import org.springframework.stereotype.Repository;

import com.satansk.summer.site.entity.Publisher;
import com.satansk.summer.site.repository.GenericJpaRepository;
import com.satansk.summer.site.repository.PublisherRepository;

@Repository
public class DefaultPublisherRepository extends GenericJpaRepository<Long, Publisher> implements PublisherRepository {

}
