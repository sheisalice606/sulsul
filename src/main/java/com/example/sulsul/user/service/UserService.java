package com.example.sulsul.user.service;

import com.example.sulsul.common.type.EType;
import com.example.sulsul.common.type.UType;
import com.example.sulsul.user.dto.request.SignUpRequest;
import com.example.sulsul.user.entity.Role;
import com.example.sulsul.user.entity.User;
import com.example.sulsul.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    /**
     * 초기 데이터는 Name, Email, ProfileImage.
     * 유저의 타입과 분야에 대한 추가정보를 받아서 추가 회원가입을 진행한다.
     * @param user 추가정보를 입력할 user 정보.
     * @param signUpRequest 추가 회원가입 정보 :  [ 유저 타입, 논술 분야 ].
     */
    public void signUp(User user, SignUpRequest signUpRequest) {

        user.updateEType(EType.valueOf(signUpRequest.getEssayType()));
        user.updateUType(UType.valueOf(signUpRequest.getUserType()));
        user.updateUserRole(Role.USER);

        userRepository.save(user);
    }
}
