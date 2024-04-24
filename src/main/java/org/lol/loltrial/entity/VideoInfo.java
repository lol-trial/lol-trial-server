package org.lol.loltrial.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class VideoInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VIDEO_ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private FeedbackBoard boardId;

    private String name;
    private String path;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();
}
