package ru.practicum.controller.internal;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.client.internal.CommentClientInternal;
import ru.practicum.service.CommentService;
import ru.practicum.dto.comment.CommentDto;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/internal/comments")
public class InternalCommentController implements CommentClientInternal {
    private final CommentService commentService;

    @GetMapping("/map")
    public Map<Long, List<CommentDto>> getEventIdToCommentsDtoMap(@RequestBody Set<Long> eventIds) {
        log.info("Получен запрос на формирование словаря комментариев по событиям" + eventIds);
        return commentService.getEventIdToCommentsDtoMap(eventIds);
    }
}
