package teamprj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class LocalMgr {

	private DBConnectionMgr pool;
	
	public LocalMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	// 리스트
	public Vector<localBean> getLocalList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;						// sql문의 결과가 담기는 곳
		String sql = null;
		Vector<localBean> vlist = new Vector<localBean>();				
		try {
			con = pool.getConnection();
			sql = "select local_name from local";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();				// select만 가능한 코드
			while(rs.next()/* 다음 레코드가 있으면 true */) {		// while문을 사용하는 이유는 몇개의 데이터가 들어올지 모르니까
				// 현재 커서가 있는 레코드에 값을 하나씩 가져와서 빈즈에 setter 한다.
				localBean bean = new localBean();
				bean.setLocalName(rs.getString("local_name"));
				vlist.addElement(bean);		// 벡터에 빈즈 담기
			}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			
			System.out.println(vlist.size());   //잘 작동됐는지 확인하는 용도
			return vlist;
	}
		
	public static void main(String[] args) {
		
	}
}
