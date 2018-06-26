package cc.wangweiye.elasticsearch.repository;

import cc.wangweiye.elasticsearch.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PersonRepository extends ElasticsearchRepository<Person, Long> {
    Page<Person> findByName(String name, Pageable pageable);

    Page<Person> findByPhoneLike(String phone, Pageable pageable);
}
