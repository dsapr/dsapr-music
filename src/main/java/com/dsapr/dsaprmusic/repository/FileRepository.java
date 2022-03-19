package com.dsapr.dsaprmusic.repository;

import com.dsapr.dsaprmusic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
