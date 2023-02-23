package com.bosonit.formacion.block11uploaddownloadfiles.repository;

import com.bosonit.formacion.block11uploaddownloadfiles.domain.FileB11;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface FileB11Repository extends JpaRepository<FileB11, Integer> {
    FileB11 findByName (String name);

}
