package hello.authentication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mumyoutube.controller.UserLoginController;
import org.mumyoutube.data.UserRepository;
import org.mumyoutube.data.VideoRepository;
import org.mumyoutube.model.User;
import org.mumyoutube.model.Video;
import org.mumyoutube.service.UserService;
import org.mumyoutube.service.VideoService;
import org.mumyoutube.service.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationTests {

    @Autowired
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    private User user;

    @Before
    public void init() {
        userRepository = mock(UserRepository.class);
    }

}
