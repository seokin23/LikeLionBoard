package myproject.likelionboard.domain.repository.board;

import myproject.likelionboard.domain.entity.Board;
import myproject.likelionboard.domain.dto.UpdateDto;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);
    List<Board> findAll();
    Optional<Board> findById(Long id);
    void update(Long id, UpdateDto param);
    void delete(Long id);
}
