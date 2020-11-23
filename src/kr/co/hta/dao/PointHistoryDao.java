package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.PointHistory;

public class PointHistoryDao {
	private static final String INSERT_POINT_HISTORY_SQL = 
			"INSERT INTO SAMPLE_USER_POINT_HISTORIES (HISTORY_NO, USER_ID, HISTORY_CONTENT, HISTORY_POINT) "
			+ "VALUES(SAMPLE_POINT_HISTORY_SEQ.NEXTVAL, ?, ?, ?)";
	private static final String GET_POINT_HISTORIES_BY_USER_ID_SQL = 
			"SELECT * FROM SAMPLE_USER_POINT_HISTORIES WHERE  = ? ORDER BY HISTORY_NO DESC";
	
	// 싱글턴 객체로 만든기(생성자 은닉화, 정적변수에 객체담기, 객체를 제공하는 정적메소드 정의하기)
	private PointHistoryDao() {}
	private static PointHistoryDao pointHistoryDao = new PointHistoryDao();
	public static PointHistoryDao getInstance( ) {
		return pointHistoryDao;
	}

	/**
	 * 포인트 변경이력을 저장한다.
	 * @param pointHistory
	 * @throws SQLException
	 */
	public void insertPointHistory(PointHistory pointHistory) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_POINT_HISTORY_SQL);
		//pstmt.setLong(1, pointHistory.getNo());
		pstmt.setString(1, pointHistory.getUserId());
		pstmt.setString(2, pointHistory.getContent());
		pstmt.setLong(3, pointHistory.getPoint());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}

	public List<PointHistory> getPointHistoriesByUserId(String userId) throws SQLException {
		List<PointHistory> pointHistoryList = new ArrayList<PointHistory>();
		PointHistory ph = new PointHistory();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_POINT_HISTORIES_BY_USER_ID_SQL);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
				ph.setUserId(rs.getString("USER_ID"));
				ph.setContent(rs.getString("HISTORY_CONTENT"));
				ph.setPoint(rs.getInt("HISTORY_POINT"));
				pointHistoryList.add(ph);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return pointHistoryList;
	}
}
