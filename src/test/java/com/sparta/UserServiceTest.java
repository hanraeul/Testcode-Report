//package com.sparta;
//
//import com.sparta.lck_news.entity.User;
//import com.sparta.lck_news.entity.UserStatus;
//import com.sparta.lck_news.repository.UserRepository;
//import com.sparta.lck_news.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void findUserById() {
//        // given
//        User user = new User("username", "password", "email", UserStatus.ACTIVE);
//        given(userRepository.findById(1L)).willReturn(Optional.of(user));
//
//        // when
//        Optional<User> foundUser = userService.findUserById(1L);
//
//        // then
//        assertThat(foundUser).isPresent();
//        assertThat(foundUser.get().getUsername()).isEqualTo("username");
//    }
//}
