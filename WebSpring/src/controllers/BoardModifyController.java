package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Board;
import dao.BoardDao;

public class BoardModifyController implements Controller{
	
	/*������ �����̳ʿ��� ����� �� �ֵ��� ���� ����*/
	private BoardDao boardDao;
	public void setBoardDao (BoardDao boardDao){
		this.boardDao = boardDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String idx = request.getParameter("idx");
		Board board = boardDao.getBoard(idx);
		
		ModelAndView mv = new ModelAndView("board.boardDetail");
		
		return mv;
	}
	
	
}
