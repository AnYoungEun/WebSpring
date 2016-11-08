package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Board;
import dao.BoardDao;

public class BoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*�𵨰� �������� ��� ��ü*/
		
		/*
		//1.setViewName�� ����� ������ ������
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board.jsp");
		*/
		
		//2.�����ڷ� ������ ������
		
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getLists(1, "TITLE", "%%");
		
		ModelAndView mv = new ModelAndView("board.board");
		mv.addObject("list", list);
		return mv;
	}
	
	
}
