package board.board.controller;

import java.io.File;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import board.board.service.BoardService;
import board.board.dto.BoardDto;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController //해당 클래스를 컨트롤러로 동작학게 한다.
public class RestBoardController {
	
	
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("rest/board")
	public List<BoardDto> openBoardList() throws Exception{
		return  boardService.selectBoardList();
	}
	
	
	@PostMapping("rest/board/write")
	public void insertBoard(@RequestBody BoardDto board) throws Exception{
		boardService.insertBoard(board, null);
	}
	
	@GetMapping("rest/board/{boardIdx}")
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		return boardService.selectBoardDetail(boardIdx);
	}
	
	@PutMapping("rest/board/{boardIdx}")
	public void updateBoard(@RequestBody BoardDto board, @PathVariable int boardIdx) throws Exception{
		board.setBoardIdx(boardIdx);
		boardService.updateBoard(board);
	}
	
	@DeleteMapping("rest/board/{boardIdx}")
	public void deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
	}
	
}