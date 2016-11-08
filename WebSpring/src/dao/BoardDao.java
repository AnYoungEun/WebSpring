package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Board;

public class BoardDao {
	
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT COUNT(*) CNT FROM BOARD2 WHERE "+field+" LIKE ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "duddms330");
		// 2. ����
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		
		// 3. ���
		ResultSet rs = st.executeQuery();
		rs.next();
		
		int cnt = rs.getInt("cnt");
		
		rs.close();
		st.close();
		con.close();
		
		return cnt;
	}
	
	public List<Board> getLists(int page, String field, String query) throws ClassNotFoundException, SQLException
	{					
		
		int srow = 1 + (page-1)*15; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		int erow = 15 + (page-1)*15; //15, 30, 45, 60, 75, ...
		
		String sql = "SELECT * FROM";
		sql += "(SELECT ROWNUM NUM, B.* FROM (SELECT * FROM BOARD2 WHERE "+field+" LIKE ? ORDER BY CREA_DTM DESC, IDX DESC) B)";
		sql += "WHERE NUM BETWEEN ? AND ?";
		// 0. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "duddms330");
		// 2. ����
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, srow);
		st.setInt(3, erow);
		// 3. ���
		ResultSet rs = st.executeQuery();
		
		List<Board> list = new ArrayList<Board>();
		
		
		
		while(rs.next()){
			Board b = new Board();
			b.setIdx(rs.getString("idx"));
			b.setTitle(rs.getString("title"));
			b.setCreaId(rs.getString("crea_id"));
			b.setCreaDtm(rs.getDate("crea_dtm"));
			b.setHitCnt(rs.getInt("hit_cnt"));
			b.setContents(rs.getString("contents"));
			b.setFileSrc(rs.getString("fileSrc"));
			
			list.add(b);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	public int delete(String idx) throws ClassNotFoundException, SQLException
	{
		// 2. ������ ���̽� ������ ���� ������ ���� �ڵ� �ۼ�
		String sql = "DELETE BOARD2 WHERE IDX=?";
		// 0. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "duddms330");
		// 2. ����
		PreparedStatement st = con.prepareStatement(sql);	
		st.setString(1, idx);
		
		int af = st.executeUpdate();
		
		return af;
	}
	
	public int update(Board board) throws ClassNotFoundException, SQLException{
		
		// 2. ������ ���̽��� �����ϱ� ���� ������ �����ͺ��̽� ������ ���� �ڵ带 �ۼ�
		String sql = "UPDATE BOARD2 SET TITLE=?, CONTENTS=?, FILESRC=? WHERE IDX=to_number(?)";
		// 0. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "duddms330");
		// 2. ����
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, board.getTitle());
		st.setString(2, board.getContents());
		st.setString(3, board.getFileSrc());
		st.setString(4, board.getIdx());		
		
		int af = st.executeUpdate();
		
		return af;
	}
	
	public Board getDetail(String idx) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * FROM BOARD2 WHERE IDX="+idx;
		// 0. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "duddms330");
		// 2. ����
		Statement st = con.createStatement();
		// 3. ���
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		
		Board b = new Board();
		b.setIdx(rs.getString("idx"));
		b.setTitle(rs.getString("title"));
		b.setCreaId(rs.getString("crea_id"));
		b.setCreaDtm(rs.getDate("crea_dtm"));
		b.setHitCnt(rs.getInt("hit_cnt"));
		b.setContents(rs.getString("contents"));
		b.setFileSrc(rs.getString("fileSrc"));
		
		rs.close();
		st.close();
		con.close();
		
		return b;
	}

	public int insert(Board b) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO BOARD2(IDX, TITLE, CONTENTS, CREA_ID, CREA_DTM, HIT_CNT, FILESRC) VALUES( (SELECT MAX(TO_NUMBER(IDX))+1 FROM BOARD2), ?, ?, '������', SYSDATE, 0, ?)";
		// 0. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "duddms330");
		// 2. ����
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, b.getTitle());
		st.setString(2, b.getContents());
		st.setString(3, b.getFileSrc());
		
		int af = st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;
	}
}
