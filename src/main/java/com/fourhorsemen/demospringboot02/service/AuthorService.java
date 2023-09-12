package com.fourhorsemen.demospringboot02.service;

import com.fourhorsemen.demospringboot02.entity.AuthorEntity;
import com.fourhorsemen.demospringboot02.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(final AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAllAuthor(){
        return authorRepository.findAll();
    }

    public AuthorEntity insertAuthor(AuthorEntity authorEntity){
        return authorRepository.save(authorEntity);
    }

    public AuthorEntity updateAuthor(AuthorEntity authorEntity, int id){
        return authorRepository.findById(id).map(
                authorEntity1 -> {
                    authorEntity1.setAuthorName(authorEntity.getAuthorName());
                    authorEntity1.setFullName(authorEntity.getFullName());
                    authorEntity1.setGender(authorEntity.getGender());
                    return authorRepository.save(authorEntity1);
                }
        ).orElseGet(() -> {
            authorEntity.setId(id);
            return authorRepository.save(authorEntity);
        });
    }

    public Boolean deleteAuthor(int id){
        boolean exists = authorRepository.existsById(id);
        if (exists){
            this.authorRepository.deleteById(id);
        }
        return exists;
    }
}
