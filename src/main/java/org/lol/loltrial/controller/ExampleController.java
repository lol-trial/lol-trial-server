package org.lol.loltrial.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.lol.loltrial.dto.ExampleDto;
import org.lol.loltrial.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Controller Class 예시
*
* Restful API 구현을 위해 RestController 어노테이션을 사용함
* DI는 생성자 주입을 사용하며, 롬복의 RequiredArgsConstructor 어노테이션을 사용함
* */
@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final ExampleService exampleService;

    @GetMapping("/save")
    @Operation(
            summary = "컨트롤러 예시 API",
            description = "컨트롤러 예시 API이며, 사용하지 않는 API입니다."
                    + "줄바꿈 예시입니다."
    )
    public Long example(ExampleDto exampleDto) {
        return exampleService.save(exampleDto);
    }

}
