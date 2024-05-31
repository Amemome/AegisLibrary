package Libro.Library.Service;


import Libro.Library.UserCreateForm;
import Libro.Library.UserNotFoundException;
import Libro.Library.entity.siteuser;
import Libro.Library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public siteuser create(UserCreateForm userCreateForm) throws DataIntegrityViolationException{

        if(userRepository.existsByStudentID(userCreateForm.getStudentID()))
            throw new DataIntegrityViolationException("이미 사용중인 학번입니다.");

        if(userRepository.existsByUsname(userCreateForm.getName()))
            throw new DataIntegrityViolationException("이미 사용중인 아이디입니다.");

        siteuser user = new siteuser();
        user.setUsname(userCreateForm.getName());
        user.setStudentID(userCreateForm.getStudentID());
        user.setPasswd(passwordEncoder.encode(userCreateForm.getPassword()));
        user.setRole("USER");

        return userRepository.save(user);


    }

    public boolean login(UserCreateForm userCreateForm) throws DataIntegrityViolationException{

        Optional<siteuser> OptloginUser = userRepository.findByStudentID(userCreateForm.getStudentID());

        if(OptloginUser.isEmpty()){
            throw new UserNotFoundException("사용자를 찾을 수 없습니다.");
        }

        siteuser loginUser = OptloginUser.get();

        if(!passwordEncoder.matches(userCreateForm.getPassword(),loginUser.getPassword()))
            throw new DataIntegrityViolationException("정보가 일치하지 않습니다.");

        return true;


    }
}
