package com.bosonit.formacion.block11uploaddownloadfiles.application;

import com.bosonit.formacion.block11uploaddownloadfiles.domain.FileB11;
import com.bosonit.formacion.block11uploaddownloadfiles.repository.FileB11Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileB11ServiceImpl implements FileB11Service {

    @Autowired
    FileB11Repository fileB11Repository;

    @Override
    public String fileUpload (MultipartFile multipartFile, String type) throws IOException {

        FileB11 fileB11 =new FileB11();

        fileB11.setName(multipartFile.getOriginalFilename());
        fileB11.setBytes(multipartFile.getBytes());
        fileB11.setType(multipartFile.getContentType());
        fileB11Repository.save(fileB11);

        return "File --> Id: " + fileB11.getId() + " Name: "+fileB11.getName() + " ha sido subido con éxito.";
    }

    @Override
    public List<String> showAllFiles() {
        List<String> fileList = new ArrayList<>();

        List<FileB11> allFilesB11List = fileB11Repository.findAll();
        for (FileB11 f : allFilesB11List) {
            fileList.add("File --> Id: " + f.getId() + " Name: "+f.getName());

        }
        return fileList;
    }

    @Override
    public Object showContentFileById(Integer id) {
        FileB11 fileB11 = fileB11Repository.findById(id).orElseThrow();
        return fileB11.getBytes();
    }

    @Override
    public Object showContentFileByName(String name) {
        FileB11 fileB11 = fileB11Repository.findByName(name);
        return fileB11.getBytes();
    }

    @Override
    public String fileDownloadById (Integer id) throws IOException {
        FileB11 fileB11 = fileB11Repository.findById(id).orElseThrow();

        byte[] file = fileB11.getBytes();
        String fileName = fileB11.getName();
        Path path = Paths.get("src/main/downloads", fileName);
        Files.write(path, file);

        return "Fichero guardado en carpeta downloads";
    }



    @Override
    public String fileDownloadByName (String name) throws IOException {
        FileB11 fileB11 = fileB11Repository.findByName(name);

        byte[] file = fileB11.getBytes();
        String fileName = fileB11.getName();
        Path path = Paths.get("src/main/downloads", fileName);
        Files.write(path, file);


        return "Fichero guardado en carpeta downloads";    }
}
