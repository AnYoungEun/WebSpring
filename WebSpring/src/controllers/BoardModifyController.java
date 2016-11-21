package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Board;
import dao.BoardDao;

public class BoardModifyController implements Controller{
	
	/*스프링 컨테이너에서 사용할 수 있도록 셋터 선언*/
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
