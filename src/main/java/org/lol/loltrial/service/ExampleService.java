package org.lol.loltrial.service;

import lombok.RequiredArgsConstructor;
import org.lol.loltrial.dto.ExampleDto;
import org.lol.loltrial.entity.Example;
import org.lol.loltrial.repository.ExampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* Service Class 예시
* DI는 생성자 주입을 사용하며, 롬복의 RequiredArgsConstructor 어노테이션을 사용함
* */
@Service
@RequiredArgsConstructor
public class ExampleService {
    private final ExampleRepository exampleRepository;

    public Long save(ExampleDto exampleDto) {
        Example example = new Example();

        example.builder()
                .name(exampleDto.getName())
                .age(exampleDto.getAge())
                .build();

        return exampleRepository.save(example).getId();
    }
}
