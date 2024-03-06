package io.github.caiorodriguesmll.imageliteapi.application.images;

import io.github.caiorodriguesmll.imageliteapi.domain.entity.Image;
import io.github.caiorodriguesmll.imageliteapi.domain.enums.ImageExtension;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ImageMapper {

    public Image mapToImage(MultipartFile file, String name, List<String> tags) throws IOException {
       return Image.builder()
                .name(name)
                .tags(String.join(",", tags)) // Converte um array de string em uma unica String para salvar no bd
                .size(file.getSize())
                .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
                .file(file.getBytes())
                .build();
    }
}
