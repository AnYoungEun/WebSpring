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
		
		/*모델과 뷰정보를 담는 객체*/
		
		/*
		//1.setViewName을 사용해 뷰정보 돌려줌
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board.jsp");
		*/
		
		//2.생성자로 뷰정보 돌려줌
		
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getLists(1, "TITLE", "%%");
		
		ModelAndView mv = new ModelAndView("board.board");
		mv.addObject("list", list);
		return mv;
	}
	
	
}
