package org.lol.loltrial.service;

import lombok.RequiredArgsConstructor;
import org.lol.loltrial.dto.BoardResponseDto;
import org.lol.loltrial.repository.FeedbackBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/*
* Service Class 예시
* DI는 생성자 주입을 사용하며, 롬복의 RequiredArgsConstructor 어노테이션을 사용함
* */
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class FeedbackBoardService {
    private final FeedbackBoardRepository feedbackBoardRepository;

    public List<BoardResponseDto> getBoardList() {

        return feedbackBoardRepository.findAll()
                .stream()
                .map(BoardResponseDto::of)
                .collect(Collectors.toList());
    }
}
