package com.dsapr.dsaprmusic.service.impl;

import com.dsapr.dsaprmusic.dto.MusicCreateRequest;
import com.dsapr.dsaprmusic.dto.MusicDto;
import com.dsapr.dsaprmusic.dto.MusicUpdateRequest;
import com.dsapr.dsaprmusic.entity.Music;
import com.dsapr.dsaprmusic.enums.MusicStatus;
import com.dsapr.dsaprmusic.exception.BizException;
import com.dsapr.dsaprmusic.exception.ExceptionType;
import com.dsapr.dsaprmusic.mapper.MusicMapper;
import com.dsapr.dsaprmusic.repository.MusicRepository;
import com.dsapr.dsaprmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository repository;

    @Autowired
    private MusicMapper mapper;

    @Override
    public MusicDto create(MusicCreateRequest musicCreateRequest) {

        Music music = mapper.createEntity(musicCreateRequest);
        music.setStatus(MusicStatus.DRAFT);
        return mapper.toDto(repository.save(music));

    }

    @Override
    public MusicDto update(String id, MusicUpdateRequest musicUpdateRequest) {
        Music existMusic = getMusic(id);
        Music music = mapper.updateEntity(existMusic, musicUpdateRequest);
        return mapper.toDto(repository.save(music));
    }

    @Override
    public List<MusicDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void publish(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.CLOSED);
        repository.save(music);
    }

    private Music getMusic(String id) {
        Optional<Music> musicOptional = repository.findById(id);
        if (!musicOptional.isPresent()) {
            throw new BizException(ExceptionType.MUSIC_NOT_FOUND);
        }

        return musicOptional.get();
    }
}
