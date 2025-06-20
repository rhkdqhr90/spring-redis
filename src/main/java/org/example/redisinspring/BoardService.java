package org.example.redisinspring;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CacheManager cacheManager;

    @Cacheable(
            cacheNames = "getBoards",
            key = "'boards:page:' + #page + ':size:' + #size",
            cacheManager = "boardCacheManager"
    )
    public List<Board> getBoard(int page,int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Board> pageOfBoards = boardRepository.findAllByOrderByCreatedDateDesc(pageable);
        return pageOfBoards.getContent();
    }
}
