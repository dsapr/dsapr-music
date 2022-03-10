package com.dsapr.dsaprmusic.service;


import com.dsapr.dsaprmusic.dto.MusicCreateRequest;
import com.dsapr.dsaprmusic.dto.MusicDto;
import com.dsapr.dsaprmusic.dto.MusicUpdateRequest;

import java.util.List;

public interface MusicService {

    MusicDto create(MusicCreateRequest musicCreateRequest);

    MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);

    List<MusicDto> list();

    void publish(String id);
}
