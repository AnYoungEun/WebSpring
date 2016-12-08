package controllers.board1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import dao.BoardDao;
import vo.Board;

@SuppressWarnings("deprecation")
public class BoardUpdateController extends AbstractCommandController{
	
	/*������ �����̳ʿ��� ����� �� �ֵ��� ���� ����*/
	private BoardDao boardDao;
	public void setBoardDao (BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		Board board = (Board)command;
		
		boardDao.update(board);
		ModelAndView mv = new ModelAndView("redirect:boardDetail.ye?idx="+board.getIdx());
		
		return mv;
	}
	
	
}
