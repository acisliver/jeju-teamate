package kr.ac.jejunu.jejuteamate.service;

import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public User signUp(User user){
        //비밀번호 인코딩
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList("ROLE_USER"));  //최초 가입시 권한 설정
        System.out.println(user.getPassword());
        System.out.println(user.getRoles());
        userRepository.save(user);
        return user;
    }

//    @Transactional
//    public String login(User user){
//        User member = userRepository.findByEmail(user.getUsername())
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 email입니다"));
//        if(!)
//    }
}
