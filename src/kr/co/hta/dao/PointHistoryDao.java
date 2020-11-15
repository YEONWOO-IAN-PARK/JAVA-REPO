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

	public void insertPointHistory(PointHistory pointHistory) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_POINT_HISTORY_SQL);
		//pstmt.setLong(1, pointHistory.getNo());
		pstmt.setString(2, pointHistory.getUserId());
		pstmt.setString(3, pointHistory.getContent());
		pstmt.setLong(4, pointHistory.getPoint());
		
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
			if(userId.equals(rs.getString(1))) {
				long no = rs.getLong("HISTORY_NO");
				String userid = rs.getString("USER_ID");
				String content = rs.getString("HISTORY_CONTENT");

				ph.setNo(no);
				ph.setUserId(userid);
				ph.setContent(content);

				pointHistoryList.add(ph);

			}
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return pointHistoryList;
	}
}
