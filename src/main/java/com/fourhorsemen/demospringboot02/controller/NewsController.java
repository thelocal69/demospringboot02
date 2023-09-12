package com.fourhorsemen.demospringboot02.controller;

import com.fourhorsemen.demospringboot02.entity.NewsEntity;
import com.fourhorsemen.demospringboot02.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(final NewsService newsService){
        this.newsService = newsService;
    }

    // Dùng phương thức GET để hiển thị danh sách bài viết
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<NewsEntity> newsEntityList = newsService.getAllNews();
        return new ResponseEntity<>(newsEntityList, HttpStatus.OK);
    }

    //Dùng phương thức POST để thêm mới bài viết
    @PostMapping("")
    public ResponseEntity<?> insertEntity(@RequestBody NewsEntity newsEntity){
        NewsEntity insertNews = newsService.insertNews(newsEntity);
        return new ResponseEntity<>(insertNews, HttpStatus.OK);
    }

    //Dùng phương thức PUT để cập nhật bài viết
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntity(@RequestBody NewsEntity newsEntity, @PathVariable int id){
        NewsEntity updateNews = newsService.updateNews(newsEntity, id);
        return new ResponseEntity<>(updateNews, HttpStatus.OK);
    }

    //Dùng phương thức DELETE để xóa bài viết
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable int id){
        if (this.newsService.deleteNews(id)){
            return new ResponseEntity<>("succes", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed", HttpStatus.NOT_FOUND);
        }
    }
}
