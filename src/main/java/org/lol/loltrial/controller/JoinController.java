package org.lol.loltrial.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.lol.loltrial.dto.JoinDto;
import org.lol.loltrial.service.JoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    @Operation(
            summary = "해당 멤버가 진행 중인 미션 목록 조회 API",
            description = "특정 멤버가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다."
                    + "query string으로 page 번호를 주세요(size는 선택, 기본 10)"
    )
    public String join(JoinDto joinDto) {
        joinService.join(joinDto);

        return "ok";
    }
}
