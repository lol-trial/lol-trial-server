package org.lol.loltrial.dto;

import lombok.Builder;
import lombok.Getter;
import org.lol.loltrial.entity.FeedbackBoard;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResponseDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardResponseDto of(FeedbackBoard feedbackBoard) {
        return BoardResponseDto.builder()
                    .title(feedbackBoard.getTitle())
                    .content(feedbackBoard.getContent())
                    .createdAt(feedbackBoard.getCreatedAt())
                    .updatedAt(feedbackBoard.getUpdatedAt())
                .build();
    }
}
