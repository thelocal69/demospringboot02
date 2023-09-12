package com.fourhorsemen.demospringboot02.service;

import com.fourhorsemen.demospringboot02.entity.NewsEntity;
import com.fourhorsemen.demospringboot02.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    @Autowired
    public NewsService(final NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }

    public List<NewsEntity> getAllNews(){
        return newsRepository.findAll();
    }

    public NewsEntity insertNews(NewsEntity newsEntity){
        return newsRepository.save(newsEntity);
    }

    public NewsEntity updateNews(NewsEntity newsEntity ,int id){
        return newsRepository.findById(id).map(
                newsEntity1 -> {
                    newsEntity1.setTitle(newsEntity.getTitle());
                    newsEntity1.setContent(newsEntity.getContent());
                    newsEntity1.setAuthor_id(newsEntity.getAuthor_id());
                    return newsRepository.save(newsEntity1);
                }
        ).orElseGet(() -> {
            newsEntity.setId(id);
            return newsRepository.save(newsEntity);
        });
    }

    public Boolean deleteNews(int id){
        boolean exits = newsRepository.existsById(id);
        if (exits){
            this.newsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
