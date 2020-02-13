/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello.storage;

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
import org.mumyoutube.data.VideoRepository;
import org.mumyoutube.model.Video;
import org.mumyoutube.service.VideoService;
import org.mumyoutube.service.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class FileSystemStorageServiceTests {

    public static final String uploadingDir = System.getProperty("user.dir") + "/uploads/";

    @Mock
    private VideoService videoService;
    private MultipartFile videoFile;


    @Before
    public void init() {
        videoService = mock(VideoService.class);
    }

    @Test
    public void loadNonExistent() {
        Video video = new Video();
        assertThat(videoService.getAllVideo()).doesNotContain(video);
    }

    @Test
    public void saveAndLoad() throws IOException {
        Video video = new Video();
        video.setUserId(111l);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("user-file","C:\\Users\\samee\\Desktop\\FinalOne\\135 Introduction",
                "video/mp4", "NewVideo".getBytes());
        videoFile = mockMultipartFile;

        byte[] bytes = videoFile.getBytes();
        Path path = Paths.get(uploadingDir + "\\NewVideo.mp4");
        Files.write(path, bytes);

        video.setVideoPath(path.toString());

        videoService.addVideo(video);
        List<Video> vids = videoService.getAllVideo();

        Assert.assertEquals(video.getVideoPath().toString(), path.toString());
    }

    @Test
    public void checkEmptyFile() throws IOException{
        Video video = new Video();
        video.setUserId(111l);
        videoFile = new MockMultipartFile("foo", "C:\\Users\\samee\\Desktop\\FinalOne\\foo.mp4",
                "video/mp4", "foo".getBytes());
        byte[] bytes = videoFile.getBytes();
        Path path = Paths.get(uploadingDir + "\\foo.mp4");
        Files.write(path, videoFile.getBytes());

        video.setVideoPath(path.toString());
        videoService.addVideo(video);

        Assert.assertEquals(video.getVideoPath().getBytes()[0], path.toString().getBytes()[0]);
    }

//    @Test
//    public void savePermitted() {
//        service.store(new MockMultipartFile("foo", "bar/../foo.txt",
//                MediaType.TEXT_PLAIN_VALUE, "Hello World".getBytes()));
//    }

}
