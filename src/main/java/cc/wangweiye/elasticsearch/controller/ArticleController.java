package cc.wangweiye.elasticsearch.controller;


import cc.wangweiye.elasticsearch.model.Article;
import cc.wangweiye.elasticsearch.model.Person;
import cc.wangweiye.elasticsearch.repository.ArticleRepository;
import cc.wangweiye.elasticsearch.service.PersonService;
import com.google.common.collect.Lists;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @PostMapping("/add")
    public String add() {
        articleRepository.deleteAll();

        Article article = new Article();
        article.setId(1L);
        article.setContent("The quick brown fox");

        Article article1 = new Article();
        article1.setId(2L);
        article1.setContent("The quick brown fox jumps over the lazy dog");

        Article article2 = new Article();
        article2.setId(3L);
        article2.setContent("The quick brown fox jumps over the quick dog");

        articleRepository.save(article);
        articleRepository.save(article1);
        articleRepository.save(article2);

        return "添加数据";
    }

    @GetMapping("/queryByContent")
    public List<Article> queryByContentLike(@RequestParam String content) {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("content", content);

        Iterable<Article> iterable = articleRepository.search(queryBuilder);

        List<Article> list = Lists.newArrayList();

        iterable.forEach(x -> list.add(x));

        return list;
    }
}
