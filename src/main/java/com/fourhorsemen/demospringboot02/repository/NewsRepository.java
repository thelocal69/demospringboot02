package com.fourhorsemen.demospringboot02.repository;

import com.fourhorsemen.demospringboot02.entity.NewsEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {
}
