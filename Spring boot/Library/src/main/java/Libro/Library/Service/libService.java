package Libro.Library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Libro.Library.repository.libRepository;
import Libro.Library.entity.book_list;

import java.util.List;


@Service
public class libService {

    @Autowired
    private libRepository libRepository;

    //글 작성 처리
    public void write(book_list list){
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

    public void listDelete(Integer id){
        libRepository.deleteById(id);
    }
}
