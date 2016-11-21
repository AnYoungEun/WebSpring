package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Board;
import dao.BoardDao;

public class BoardController implements Controller{
	
	/*스프링 컨테이너에서 사용할 수 있도록 셋터 선언*/
	private BoardDao boardDao;
	public void setBoardDao (BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("q");
		
		if (_page != null && !_page.equals("")) {
			page = Integer.parseInt(_page);
		}
		
		if (_field != null && !_field.equals("")) {
			field = _field;
		}
		
		if (_query != null && !_query.equals("")) {
			query = _query;
		}
		
		
		/*이 객체를 여기서 만들지 않고 스프링 컨테이너에서 만들도록 함*/
		//BoardDao dao = new BoardDao();
		List<Board> list = boardDao.getLists(page, field, query);
		
		ModelAndView mv = new ModelAndView("board.board");
		mv.addObject("list", list);
		return mv;
	}
	
	
}
