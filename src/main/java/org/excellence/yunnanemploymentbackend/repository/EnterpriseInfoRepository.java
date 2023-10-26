package org.excellence.yunnanemploymentbackend.repository;

import org.excellence.yunnanemploymentbackend.entity.EnterpriseInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnterpriseInfoRepository extends MongoRepository<EnterpriseInfo, String> {

}
