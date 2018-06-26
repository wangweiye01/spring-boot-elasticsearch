package cc.wangweiye.elasticsearch.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import java.io.Serializable;

@Document(indexName = "elastic_search_project", type = "person", indexStoreType = "fs", shards = 5, replicas = 1, refreshInterval = "-1")
@Data
public class Person implements Serializable {
    @Id
    private int id;

    private String name;

    private String phone;

    /**
     * 地理位置经纬度
     * lat纬度，lon经度 "40.715,-74.011"
     * 如果用数组则相反[-73.983, 40.719]
     */
    @GeoPointField
    private String address;

}
