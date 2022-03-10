package com.dsapr.dsaprmusic.controller;

import com.dsapr.dsaprmusic.dto.MusicCreateRequest;
import com.dsapr.dsaprmusic.dto.MusicUpdateRequest;
import com.dsapr.dsaprmusic.mapper.MusicMapper;
import com.dsapr.dsaprmusic.service.MusicService;
import com.dsapr.dsaprmusic.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musics")
public class MusicController {

    @Autowired
    MusicService musicService;

    @Autowired
    private MusicMapper musicMapper;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {

        return musicMapper.toVo(musicService.create(musicCreateRequest));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
        return musicMapper.toVo(musicService.update(id, musicUpdateRequest));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<MusicVo> list() {
        return musicService.list().stream().map(musicMapper::toVo).collect(Collectors.toList());
    }

    @PostMapping("/{id}/publish")
    public void publish(@PathVariable String id) {
        musicService.publish(id);
    }

}
