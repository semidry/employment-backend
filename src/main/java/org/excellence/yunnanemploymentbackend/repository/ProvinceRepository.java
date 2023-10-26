package org.excellence.yunnanemploymentbackend.repository;

import org.excellence.yunnanemploymentbackend.entity.Province;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinceRepository extends MongoRepository<Province, String> {
    
}
