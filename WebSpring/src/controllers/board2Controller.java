package controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.Board;
import dao.BoardDao;

@Controller
public class board2Controller {
	
	private BoardDao boardDao;
	
	//자동으로 연결해줌 (BoardDao 객체를 담을 수 있는 것이면 다 담아줌)
	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	//컴파일러를 거쳐도 남아있는 주석
	@RequestMapping("/board/board.ye")
	public String board2(String pg, String f, String q, Model model) throws ClassNotFoundException, SQLException{
		//매개변수는 뷰에서 오는 파라미터면 자동으로 담아져서 이 함수에서 쓸 수 있음
		//Model 객체도 자동으로 생성됨
		
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		
		if (pg != null && !pg.equals("")) {
			page = Integer.parseInt(pg);
		}
		
		if (f != null && !f.equals("")) {
			field = f;
		}
		
		if (q != null && !q.equals("")) {
			query = q;
		}
		
		/*이 객체를 여기서 만들지 않고 스프링 컨테이너에서 만들도록 함*/
		//BoardDao dao = new BoardDao();
		List<Board> list = boardDao.getLists(page, field, query);
		
		//뷰정보는 리턴값으로 넘길것임
		//ModelAndView mv = new ModelAndView("board.board");
		model.addAttribute("list", list);
		
		return "board.board";
	}
	
	@RequestMapping("/board/boardDetail.ye")
	public String board2Detail(String idx, Model model) throws ClassNotFoundException, SQLException{
		
		//String idx = request.getParameter("idx");
		Board board = boardDao.getBoard(idx);
		
		ModelAndView mv = new ModelAndView("board.boardDetail");
		model.addAttribute("board", board);
		
		return "board.boardDetail";
	}
	
	@RequestMapping(value={"/board/boardReg.ye"}, method=RequestMethod.GET)
	public String board2Reg(){
		
		return "board.boardReg";
	}
	
	//파라미터를 하나하나 받아서 매개변수로 넘겨줌
	/*
	@RequestMapping(value={"/board/boardReg.ye"}, method=RequestMethod.POST)
	public String board2Reg(String title, String contents) throws ClassNotFoundException, SQLException{
		
		Board b = new Board();
		b.setTitle(title);
		b.setContents(contents);
		
		boardDao.insert(b);
		//ModelAndView mv = new ModelAndView("redirect:board.ye");
		
		return "redirect:board.ye";
	}
	*/
	//객체에 set함수가 있는지 확인하여 이름이 같으면 set을 자동으로 해줌
	@RequestMapping(value={"/board/boardReg.ye"}, method=RequestMethod.POST)
	public String board2Reg(Board b) throws ClassNotFoundException, SQLException{
		
		boardDao.insert(b);
		//ModelAndView mv = new ModelAndView("redirect:board.ye");
		
		return "redirect:board.ye";
	}

	@RequestMapping(value={"/board/boardModify.ye"}, method=RequestMethod.GET)
	public String Board2Edit(Board b, Model model) throws ClassNotFoundException, SQLException{
		
		Board board = boardDao.getBoard(b.getIdx());
		model.addAttribute("board",board);
		
		return "board.boardModify";
	}
	
	@RequestMapping(value={"/board/boardModify.ye"}, method=RequestMethod.POST)
	public String NoticeEdit(Board b) throws ClassNotFoundException, SQLException{
		
		boardDao.update(b);
		
		return "redirect:boardDetail.ye?idx="+b.getIdx();
	}
	
	@RequestMapping("/board/boardDelete.ye")
	public String Board2Del (String idx) throws ClassNotFoundException, SQLException{
		boardDao.delete(idx);
		
		return "redirect:board.ye";
	}
}
