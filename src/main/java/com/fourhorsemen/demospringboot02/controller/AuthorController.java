package com.fourhorsemen.demospringboot02.controller;

import com.fourhorsemen.demospringboot02.entity.AuthorEntity;
import com.fourhorsemen.demospringboot02.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(final AuthorService authorService){
        this.authorService = authorService;
    }

    //    2) Dùng phương thức GET để hiển thị danh sách tác giả
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<AuthorEntity> authorEntityList = authorService.getAllAuthor();
        return new ResponseEntity<>(authorEntityList, HttpStatus.OK);
    }

    //    4) Dùng phương thức POST để thêm mới tác giả
    @PostMapping("")
    public ResponseEntity<?> insertEntity(@RequestBody AuthorEntity authorEntity){
        AuthorEntity saveAuthor = authorService.insertAuthor(authorEntity);
        return new ResponseEntity<>(saveAuthor, HttpStatus.OK);
    }

    //    8) Dùng phương thức PUT để cập nhật tác giả.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntity(@RequestBody AuthorEntity authorEntity, @PathVariable int id){
        AuthorEntity updateAuthor = authorService.updateAuthor(authorEntity, id);
        return new ResponseEntity<>(updateAuthor, HttpStatus.OK);
    }

    //    6) Dùng phướng thức DELETE để xóa tác giả
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable int id){
        if (this.authorService.deleteAuthor(id)){
            return new ResponseEntity<>("sucess", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed", HttpStatus.NOT_FOUND);
        }
    }
}
