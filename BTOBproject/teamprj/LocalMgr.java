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
	
	// ����Ʈ
	public Vector<localBean> getLocalList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;						// sql���� ����� ���� ��
		String sql = null;
		Vector<localBean> vlist = new Vector<localBean>();				
		try {
			con = pool.getConnection();
			sql = "select local_name from local";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();				// select�� ������ �ڵ�
			while(rs.next()/* ���� ���ڵ尡 ������ true */) {		// while���� ����ϴ� ������ ��� �����Ͱ� ������ �𸣴ϱ�
				// ���� Ŀ���� �ִ� ���ڵ忡 ���� �ϳ��� �����ͼ� ��� setter �Ѵ�.
				localBean bean = new localBean();
				bean.setLocalName(rs.getString("local_name"));
				vlist.addElement(bean);		// ���Ϳ� ���� ���
			}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			
			System.out.println(vlist.size());   //�� �۵��ƴ��� Ȯ���ϴ� �뵵
			return vlist;
	}
		
	public static void main(String[] args) {
		
	}
}
