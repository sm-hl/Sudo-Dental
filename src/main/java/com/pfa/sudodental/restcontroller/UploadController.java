package com.pfa.sudodental.restcontroller;

import com.pfa.sudodental.model.Image;
import com.pfa.sudodental.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class UploadController {
    @Autowired
    ImageService imageService;

        @PostMapping("/uploadimage")
        public void uploadFile(@RequestParam("file")MultipartFile file,@RequestParam("consultation") String consultation) throws Exception {
            imageService.saveFile(file,consultation);
        }
    @GetMapping("/images/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) throws Exception {
        Image image = imageService.get(fileId);

        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + image.getFileName()
                                + "\"")
                .body(new ByteArrayResource(image.getData()));
    }
    @PostMapping("/getimages")
    List<Long> getImagesid(@RequestBody Long consultationId){
         return imageService.listImagesId(consultationId);
    }
        }

