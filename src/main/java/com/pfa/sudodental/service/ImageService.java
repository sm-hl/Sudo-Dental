package com.pfa.sudodental.service;

import com.pfa.sudodental.model.Image;
import com.pfa.sudodental.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageService extends AbstractService<Image,Long> {

    @Autowired
    ImageRepository imageRepository;

    @Override
    protected JpaRepository<Image, Long> getRepository() {
        return this.imageRepository;
    }
    public List<Long> listImagesId(Long consultationId) {
        return imageRepository.getImagesId(consultationId);
    }

    public Image saveFile(MultipartFile file, String consultation) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }
            Image image=new Image();
            image.setConsultationId(Long.parseLong(consultation));
            image.setFileName(fileName);
            image.setFileType(file.getContentType());
            image.setData(file.getBytes());
            this.save(image);
            return image;
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
}