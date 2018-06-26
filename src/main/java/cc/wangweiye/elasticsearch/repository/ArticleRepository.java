package cc.wangweiye.elasticsearch.repository;

import cc.wangweiye.elasticsearch.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
    List<Article> findByContentLike(String content);
}
