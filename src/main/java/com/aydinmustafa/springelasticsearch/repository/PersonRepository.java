package com.aydinmustafa.springelasticsearch.repository;

import com.aydinmustafa.springelasticsearch.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
}
