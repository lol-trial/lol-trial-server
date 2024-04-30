package org.lol.loltrial.config;

import org.lol.loltrial.dto.UploadFileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class FileStoreConfig {

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    public String getFullPath(String filename) {
        return uploadPath + filename;
    }

    public List<UploadFileDto> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFileDto> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }

    public UploadFileDto storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename(); // 사용자가 업로드한 파일이름
        String storeFileName = createStoreFileName(originalFilename); // 서버에 저장하는 파일명(예: uuid_파일명.확장자)

        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        return new UploadFileDto(originalFilename, storeFileName);
    }

    private String createStoreFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        return uuid + "_" + originalFilename;
    }

}
