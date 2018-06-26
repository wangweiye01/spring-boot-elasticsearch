package cc.wangweiye.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "articles", type = "love")
@Data
public class Article implements Serializable {
    @Id
    private Long id;

    private String content;
}
