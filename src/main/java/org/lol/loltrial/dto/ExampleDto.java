package org.lol.loltrial.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.lol.loltrial.entity.Example;

/* Dto Class 예시 */
@Getter
@Builder
public class ExampleDto {
    private String name;
    private int age;

    public static ExampleDto of(Example example) {
        return ExampleDto.builder()
                .name(example.getName())
                .age(example.getAge())
                .build();
    }
}
