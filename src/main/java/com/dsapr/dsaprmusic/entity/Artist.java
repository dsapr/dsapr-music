package com.dsapr.dsaprmusic.entity;

import com.dsapr.dsaprmusic.enums.ArtistStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Artist extends TraceableBaseEntity {
    private String name;

    private String remark;

    // TODO list 考虑分页
    @ManyToMany
    @JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;

    private ArtistStatus status;
}
