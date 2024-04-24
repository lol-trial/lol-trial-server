package org.lol.loltrial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

/*
 * Entity class 예시
 *
 * 1. @Setter를 사용하지 않고 Builder 패턴 사용
 * 2. 클래스명에 Entity를 사용하지 않음
 *    ex) ExampleEntity -> X
 *        Example -> O
 * */
@Entity
@Getter
public class Example {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Builder
    public void updateExample(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


