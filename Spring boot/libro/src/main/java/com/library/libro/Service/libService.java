package com.library.libro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.libro.repository.libRepository;
import com.library.libro.entity.book_list;

import java.util.List;


@Service
public class libService {
    @Autowired
    private libRepository libRepository;

    //글 작성 처리
    public void write(book_list list) throws Exception{

        libRepository.save(list);
    }

    //게시물 리스트 처리
    public List<book_list> libList(){

        return libRepository.findAll();
    }

    //특정 게시글 불러오기
    public book_list ListView(Integer id){

        return libRepository.findById(id).get();
    }

    //특정 게시글 삭제

    public void listDelete(Integer id){

        libRepository.deleteById(id);
    }

}