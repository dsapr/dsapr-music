package com.dsapr.dsaprmusic.service;


import com.dsapr.dsaprmusic.dto.MusicDto;
import com.dsapr.dsaprmusic.entity.Music;

public interface MusicService extends GeneralService<Music, MusicDto> {
    MusicDto create(MusicDto musicDto);

    void publish(String id);

    void close(String id);
}
