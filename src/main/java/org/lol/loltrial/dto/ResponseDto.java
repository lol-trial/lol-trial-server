package org.lol.loltrial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ResponseDto {
    private int statusCode;
    private String result;
    private String msg;
    private Object data;
}
