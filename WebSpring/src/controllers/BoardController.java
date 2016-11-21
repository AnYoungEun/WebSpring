package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Board;
import dao.BoardDao;

public class BoardController implements Controller{
	
	/*������ �����̳ʿ��� ����� �� �ֵ��� ���� ����*/
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
		
		
		/*�� ��ü�� ���⼭ ������ �ʰ� ������ �����̳ʿ��� ���鵵�� ��*/
		//BoardDao dao = new BoardDao();
		List<Board> list = boardDao.getLists(page, field, query);
		
		ModelAndView mv = new ModelAndView("board.board");
		mv.addObject("list", list);
		return mv;
	}
	
	
}
