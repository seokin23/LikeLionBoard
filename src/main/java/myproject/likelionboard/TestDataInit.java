package myproject.likelionboard;

import lombok.RequiredArgsConstructor;
import myproject.likelionboard.domain.entity.Board;
import myproject.likelionboard.domain.entity.Member;
import myproject.likelionboard.domain.repository.board.BoardRepository;
import myproject.likelionboard.domain.repository.member.SpringDataJpaMemberRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class TestDataInit {

    private final BoardRepository boardRepository;
    private final SpringDataJpaMemberRepository memberRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("123");
        //memberRepository.save(member);

        Board board = new Board();
        board.setTitle("문의");
        board.setContent("이거 품절 인가요?");
        board.setName("test");
        board.setPassword("123");
        //board.setCreateDate(LocalDateTime.now());
        boardRepository.save(board);

        Board board2 = new Board();
        board2.setTitle("문의2");
        board2.setContent("이거 얼마 인가요?");
        board2.setName("test2");
        board2.setPassword("456");
        //board2.setCreateDate();
        boardRepository.save(board2);
    }
}
