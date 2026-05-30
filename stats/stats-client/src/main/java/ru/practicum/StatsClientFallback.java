package ru.practicum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
public class StatsClientFallback implements StatsClient {

    @Override
    public EndpointHitDto hit(NewEndpointHitDto newEndpointHitDto) {
        log.error("Fallback response: stats server is unavailable");
        return null;
    }

    @Override
    public List<ViewStatsDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        log.error("Fallback response: stats server is unavailable");
        return null;
    }
}