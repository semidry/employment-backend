package org.excellence.yunnanemploymentbackend.repository;

import org.excellence.yunnanemploymentbackend.entity.ReportedData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportedDataRepository extends MongoRepository<ReportedData, String> {
    
}
