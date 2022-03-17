package com.dsapr.dsaprmusic.service;

import com.dsapr.dsaprmusic.dto.MusicDto;
import com.dsapr.dsaprmusic.enums.MusicStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dsapr
 * @data 2022/3/17
 */
@SpringBootTest
@Slf4j
class MusicServiceTest {

    @Autowired
    MusicService musicService;

    @Test
    void create() {
        MusicDto musicDto = new MusicDto();
        musicDto.setName("测试音乐");
        musicDto.setDescription("测试音乐描述");
        MusicDto savedMusicDto = musicService.create(musicDto);
        Assertions.assertEquals(musicDto.getName(), savedMusicDto.getName());
        Assertions.assertEquals(musicDto.getDescription(), savedMusicDto.getDescription());
        Assertions.assertEquals(MusicStatus.DRAFT, savedMusicDto.getStatus());
        log.info(savedMusicDto.toString());
    }

    @Test
    void publish() {

    }

    @Test
    void close() {

    }

}