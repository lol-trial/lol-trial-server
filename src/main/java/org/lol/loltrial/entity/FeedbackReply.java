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
public class FeedbackReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private FeedbackBoard boardId;

    private Long parent;
    private Long depth;

    @Lob
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public FeedbackReply(Long parent, Long depth, String content) {
        this.parent = parent;
        this.depth = depth;
        this.content = content;
    }
}
