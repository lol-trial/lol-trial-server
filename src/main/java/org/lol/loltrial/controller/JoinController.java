package org.lol.loltrial.controller;

import lombok.RequiredArgsConstructor;
import org.lol.loltrial.dto.JoinDto;
import org.lol.loltrial.service.JoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public String join(JoinDto joinDto) {
        joinService.join(joinDto);

        return "ok";
    }
}
