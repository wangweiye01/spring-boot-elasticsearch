package cc.wangweiye.elasticsearch.repository;

import cc.wangweiye.elasticsearch.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person, Long> {
}
