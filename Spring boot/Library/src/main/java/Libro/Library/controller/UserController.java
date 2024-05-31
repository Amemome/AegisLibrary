package Libro.Library.controller;

import Libro.Library.Service.UserService;
import Libro.Library.UserCreateForm;
import Libro.Library.UserNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;

import org.springframework.dao.DataIntegrityViolationException;

@RequiredArgsConstructor
@RestController
@Data
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    @PostMapping("/registerplease")
    public ResponseEntity<String> register(@RequestBody UserCreateForm userCreateForm, BindingResult bindingResult) {


        //사용자 생성 로직.
        try {
            userService.create(userCreateForm);

            System.out.println("Student ID: " + userCreateForm.getStudentID());
            System.out.println("Name: " + userCreateForm.getName());
            System.out.println("Password: " + userCreateForm.getPassword());

            return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 학번 혹은 아이디입니다.");
            return new ResponseEntity<>("Student ID or Name already exists", HttpStatus.CONFLICT);
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return new ResponseEntity<>("Student ID or Name already exists", HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/loginplease")
    public ResponseEntity<String> login(@RequestBody UserCreateForm userCreateForm, BindingResult bindingResult) {
        try {
            if (userService.login(userCreateForm)) {
                return new ResponseEntity<>("Login successful!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Login failed!", HttpStatus.UNAUTHORIZED);
            }
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("loginFailed", "입력된 정보가 일치하지 않습니다.");
            return new ResponseEntity<>("Input does not match our data", HttpStatus.CONFLICT);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            bindingResult.reject("loginFailed", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("loginFailed", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
