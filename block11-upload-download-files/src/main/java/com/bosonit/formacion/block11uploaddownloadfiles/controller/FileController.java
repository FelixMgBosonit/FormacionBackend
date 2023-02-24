package com.bosonit.formacion.block11uploaddownloadfiles.controller;

import com.bosonit.formacion.block11uploaddownloadfiles.application.FileService;
import com.bosonit.formacion.block11uploaddownloadfiles.domain.File;
import com.bosonit.formacion.block11uploaddownloadfiles.exception.EntityNotFoundException;
import com.bosonit.formacion.block11uploaddownloadfiles.repository.FileRepository;
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
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;
    @Autowired
    FileRepository fileRepository;


    @PostMapping("/upload")
    public ResponseEntity<String> upload (@RequestParam ("file")MultipartFile multipartFile, @RequestParam ("type") String type) throws IOException {//throws Exception eliminado por los ifs de personaServiceImpl
        return ResponseEntity.ok().body((fileService.upload(multipartFile, type)));
    }


    @GetMapping("/showAllFiles")
    public ResponseEntity<List<File>> showAllFiles() {
        return ResponseEntity.ok().body(fileService.showAllFiles());
    }


    @GetMapping("/showContentFileById/{id}")
    public ResponseEntity<Object> showContentFileById(@PathVariable Integer id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("File no encontrado."));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .body(new ByteArrayResource(file.getBytes()));
    }


    @GetMapping("/showContentFileByName/{name}")
    public ResponseEntity<Object> showContentFileByName(@PathVariable String name) {
        File file = fileRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("File no encontrado."));;
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .body(new ByteArrayResource(file.getBytes()));
    }


    @GetMapping("/downloadFileById/{id}")
    public ResponseEntity<String> downloadById(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(fileService.fileDownloadById(id));
    }


    @GetMapping("/downloadFileByName/{name}")
    public ResponseEntity<String> downloadByName(@PathVariable String name) throws IOException {
        return ResponseEntity.ok().body(fileService.fileDownloadByName(name));
    }

}
