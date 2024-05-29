package Libro.Library.Service;


import Libro.Library.UserCreateForm;
import Libro.Library.entity.siteuser;
import Libro.Library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public siteuser create(UserCreateForm userCreateForm){

        if(userRepository.existsByStudentID(userCreateForm.getStudentID()))
            throw new DataIntegrityViolationException("이미 사용중인 학번입니다.");

        if(userRepository.existsByUsname(userCreateForm.getUsname()))
            throw new DataIntegrityViolationException("이미 사용중인 아이디입니다.");

        siteuser user = new siteuser();
        user.setUsname(userCreateForm.getUsname()   );
        user.setStudentID(userCreateForm.getStudentID());
        user.setPasswd(passwordEncoder.encode(userCreateForm.getPassword()));

        return userRepository.save(user);

    }
}
