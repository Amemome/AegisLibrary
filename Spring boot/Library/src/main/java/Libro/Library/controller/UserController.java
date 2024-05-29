package Libro.Library.controller;

import Libro.Library.Service.UserService;
import Libro.Library.UserCreateForm;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.dao.DataIntegrityViolationException;


@RestController
@Data
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    @PostMapping("/registerplease")
    public ResponseEntity<String> register(@RequestBody UserCreateForm userCreateForm, BindingResult bindingResult) {


        //사용자 생성 로직.
        // 예를 들어, 데이터베이스에 사용자를 저장하는 로직
    try {
        userService.create(userCreateForm);

        System.out.println("Student ID: " + userCreateForm.getStudentID());
        System.out.println("Name: " + userCreateForm.getName());
        System.out.println("Password: " + userCreateForm.getPassword());

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    } catch(DataIntegrityViolationException e){
        e.printStackTrace();
        bindingResult.reject("signupFailed","이미 등록된 학번 혹은 아이디입니다.");
        return new ResponseEntity<>("Student ID or Name already exists",HttpStatus.CONFLICT);
    }catch(Exception e){
        e.printStackTrace();
        bindingResult.reject("signupFailed", e.getMessage());
        return new ResponseEntity<>("Student ID or Name already exists",HttpStatus.CONFLICT);
    }

    }
}
