package org.lol.loltrial.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.lol.loltrial.config.FileStoreConfig;
import org.lol.loltrial.dto.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FileController {
    private final FileStoreConfig fileStoreConfig;

    @PostMapping("/multipart-videos")
    @Operation(
            summary = "피드백 게시판 전체 게시글 조회 API",
            description = "피드백 게시판의 게시글 전체 목록을 조회하는 API이며, 페이징을 포함합니다."
                    + "query string으로 page 번호를 주세요(size는 선택, 기본 10)"
    )
    public ResponseDto uploadFileList(@RequestPart("videos") List<MultipartFile> multipartVideos) throws IOException {

        return new ResponseDto(200, "성공", "동영상저장 성공!", fileStoreConfig.storeFiles(multipartVideos));

    }
}
