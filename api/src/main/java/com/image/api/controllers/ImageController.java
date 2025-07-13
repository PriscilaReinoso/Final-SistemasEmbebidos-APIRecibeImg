package com.image.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/image")
public class ImageController {
	
    @PostMapping("/upload")
    public ResponseEntity<String> imageUpload(@RequestParam("image") MultipartFile file) {
        try {
            File dir = new File("../uploads");
            if (!dir.exists()) dir.mkdirs();

            String fileName = LocalDateTime.now().toString().replace(":", "-") + ".jpg";
            Path filepath = Paths.get("../uploads", fileName);
            Files.write(filepath, file.getBytes());

            return ResponseEntity.ok("Imagen recibida y guardada como " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen");
        }
    }


}
