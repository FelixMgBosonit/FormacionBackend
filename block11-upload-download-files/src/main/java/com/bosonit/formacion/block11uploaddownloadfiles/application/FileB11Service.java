package com.bosonit.formacion.block11uploaddownloadfiles.application;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileB11Service {

    String fileUpload (MultipartFile multipartFile, String type) throws IOException;

    List<String> showAllFiles();

    Object showContentFileById(Integer id);

    Object showContentFileByName(String name);
    String fileDownloadById (Integer id) throws IOException;

    String fileDownloadByName (String name) throws IOException;
}
