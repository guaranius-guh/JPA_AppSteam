package com.guaranius.pooii.jpa.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadImage {
    public static boolean uploading(MultipartFile file) {
        boolean successUpload = false;
        if(!file.isEmpty()) {
            String archiveName = file.getOriginalFilename();
            try {
                String folder = "C:\\Users\\Gustavo\\Documents\\JPA_AppSteam\\src\\main\\resources\\images\\images-game";
                File dir = new File(folder);
                if(!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + archiveName);
                try (BufferedOutputStream stream = new BufferedOutputStream(new  FileOutputStream(serverFile))) {
                    stream.write(file.getBytes());
                }
            } catch (IOException e) {
                System.out.println("Fail");
            }
        } else {
            System.out.println("Empty");
        }
    return successUpload;
    }
}
