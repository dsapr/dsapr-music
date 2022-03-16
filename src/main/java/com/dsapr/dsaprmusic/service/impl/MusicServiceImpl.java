package com.dsapr.dsaprmusic.service.impl;

import com.dsapr.dsaprmusic.dto.MusicDto;
import com.dsapr.dsaprmusic.entity.Music;
import com.dsapr.dsaprmusic.enums.MusicStatus;
import com.dsapr.dsaprmusic.exception.ExceptionType;
import com.dsapr.dsaprmusic.mapper.MapperInterface;
import com.dsapr.dsaprmusic.mapper.MusicMapper;
import com.dsapr.dsaprmusic.repository.MusicRepository;
import com.dsapr.dsaprmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl extends GeneralServiceImpl<Music, MusicDto> implements MusicService {

    @Autowired
    private MusicRepository repository;

    @Autowired
    private MusicMapper mapper;

    @Override
    public void publish(String id) {
        Music music = getEntity(id);
        music.setStatus(MusicStatus.CLOSED);
        repository.save(music);
    }

    @Override
    public void close(String id) {
        Music music = getEntity(id);
        music.setStatus(MusicStatus.PUBLISED);
        repository.save(music);
    }

    @Override
    public JpaRepository<Music, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Music, MusicDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.MUSIC_NOT_FOUND;
    }

}
