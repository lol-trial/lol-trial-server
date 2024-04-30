package org.lol.loltrial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFileDto {

    private String uploadFileName; // 사용자가 업로드한 파일명
    private String storeFileName; // 서버에 저장되는 파일명
}
