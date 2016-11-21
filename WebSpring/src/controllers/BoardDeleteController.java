package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Board;
import dao.BoardDao;

public class BoardDeleteController implements Controller{
	
	/*������ �����̳ʿ��� ����� �� �ֵ��� ���� ����*/
	private BoardDao boardDao;
	public void setBoardDao (BoardDao boardDao){
		this.boardDao = boardDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String idx = request.getParameter("idx");
		boardDao.delete(idx);
		
		ModelAndView mv = new ModelAndView("redirect:board.ye");
		return mv;
	}
	
	
}
