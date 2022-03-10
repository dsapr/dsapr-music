package com.dsapr.dsaprmusic.repository;

import com.dsapr.dsaprmusic.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, String> {

}
