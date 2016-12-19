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
	
	//�ڵ����� �������� (BoardDao ��ü�� ���� �� �ִ� ���̸� �� �����)
	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	//�����Ϸ��� ���ĵ� �����ִ� �ּ�
	@RequestMapping("/board/board.ye")
	public String board2(String pg, String f, String q, Model model) throws ClassNotFoundException, SQLException{
		//�Ű������� �信�� ���� �Ķ���͸� �ڵ����� ������� �� �Լ����� �� �� ����
		//Model ��ü�� �ڵ����� ������
		
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
		
		/*�� ��ü�� ���⼭ ������ �ʰ� ������ �����̳ʿ��� ���鵵�� ��*/
		//BoardDao dao = new BoardDao();
		List<Board> list = boardDao.getLists(page, field, query);
		
		//�������� ���ϰ����� �ѱ����
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
	
	//�Ķ���͸� �ϳ��ϳ� �޾Ƽ� �Ű������� �Ѱ���
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
	//��ü�� set�Լ��� �ִ��� Ȯ���Ͽ� �̸��� ������ set�� �ڵ����� ����
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
