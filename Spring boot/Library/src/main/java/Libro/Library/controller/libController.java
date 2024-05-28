package Libro.Library.controller;

import Libro.Library.entity.book_list;
import Libro.Library.Service.libService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api")
public class libController {

    @GetMapping("/api/index")
    public String getMessage(Model model) {
        model.addAttribute("message","요청이 완료됨");
        return "Message";
    }
}

//@Controller
//public class libController {
//
//    @Autowired
//    private libService libService;
//
//    @GetMapping("/library/write") // localhost:8080/library/write
//    // 윗 주석의 주소로 접속하면 아래에 반환되는 html 문서를 보여주겠다는 뜻
//    public String libWriteForm(){
//
//        return "libraryWrite"; // return 이후의 쌍따옴표 안에는 어떤 HTML 파일로 보낼거냐에 대한  정보를 넣음
//    }
//
//    @PostMapping("/library/written")
//    public String libWrite(book_list list,Model model) throws Exception{
//        libService.write(list);
//
//        model.addAttribute("message","글 작성이 완료됨");
//        model.addAttribute("searchUrl","/library/list");
//
//        return "Message";
//    }
//
//    @GetMapping("/library/list")
//    public String libList(Model model){
//
//        model.addAttribute("list",libService.libList());
//        return "libList";
//    }
//
//    @GetMapping("/library/view") // localhost:8080/library/view?id=1
//    public String listView(Model model,@RequestParam("id") Integer id){
//
//        model.addAttribute("book_list", libService.ListView(id));
//        return "listView";
//    }
//
//    @GetMapping("/library/delete")
//    public String listDelete(@RequestParam("id") Integer id){
//
//        libService.listDelete(id);
//
//        return "redirect:/library/list";
//    }
//
//    @GetMapping("/library/modify/{id}")
//    public String listModify(@PathVariable("id") Integer id, Model model){
//
//        model.addAttribute("book_list", libService.ListView(id));
//
//        return "listModify";
//    }
//
//    @PostMapping("/library/update/{id}")
//    public String listUpdate(@PathVariable("id") Integer id, book_list list) throws Exception{
//
//        book_list listTemp = libService.ListView(id);
//        listTemp.setTitle(list.getTitle());
//        listTemp.setContent(list.getContent());
//
//        libService.write(listTemp);
//
//        return "redirect:/library/list";
//    }

//    @GetMapping("/")
//    public String libMain(){
//
//        return "index";
//    }
//}
