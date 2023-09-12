package com.fourhorsemen.demospringboot02.repository;

import com.fourhorsemen.demospringboot02.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
