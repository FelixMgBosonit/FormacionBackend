package com.bosonit.formacion.block11uploaddownloadfiles.controller;

import com.bosonit.formacion.block11uploaddownloadfiles.application.FileB11Service;
import com.bosonit.formacion.block11uploaddownloadfiles.domain.FileB11;
import com.bosonit.formacion.block11uploaddownloadfiles.repository.FileB11Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/fileB11")
public class FileB11Controller {

    @Autowired
    FileB11Service fileB11Service;
    @Autowired
    FileB11Repository fileB11Repository;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFichero (@RequestParam ("file")MultipartFile multipartFile, @RequestParam ("type") String type) throws IOException {//throws Exception eliminado por los ifs de personaServiceImpl
        return ResponseEntity.ok().body((fileB11Service.fileUpload(multipartFile, type)));
    }


    @GetMapping("/showAllFiles")
    public ResponseEntity<List<String>> showAllFiles() {
        return ResponseEntity.ok().body(fileB11Service.showAllFiles());
    }


    @GetMapping("/showContentFileById/{id}")
    public ResponseEntity<Object> showContentFileById(@PathVariable Integer id) {
        FileB11 fileB11= fileB11Repository.findById(id).orElseThrow();
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileB11.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileB11.getName())
                .body(new ByteArrayResource(fileB11.getBytes()));
    }


    @GetMapping("/showContentFileByName/{name}")
    public ResponseEntity<Object> showContentFileByName(@PathVariable String name) {
        FileB11 fileB11= fileB11Repository.findByName(name);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileB11.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileB11.getName())
                .body(new ByteArrayResource(fileB11.getBytes()));
    }


    @GetMapping("/downloadFileById/{id}")
    public ResponseEntity<String> downloadById(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(fileB11Service.fileDownloadById(id));
    }


    @GetMapping("/downloadFileByName/{name}")
    public ResponseEntity<String> downloadByName(@PathVariable String name) throws IOException {
        return ResponseEntity.ok().body(fileB11Service.fileDownloadByName(name));
    }

}
