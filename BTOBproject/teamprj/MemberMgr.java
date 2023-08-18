package teamprj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberMgr {
	
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	// ����
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {					// Pooling ����̶� �̸� �����ͺ��̽� Connection�� ���� �� ���� Ư�� ������ ������ ����, 
									//���� ����ڰ� �ʿ��� �� ���� �ϳ��� ������ ����ϰ� �ٽ� ���� �ִ� ���
			con = pool.getConnection();	// connection ��ü�� ������
			sql = "insert user_asd ()values(null, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1/*  ù��° ����ǥ */, bean.getName());
			pstmt.setString(2/*  �ι�° ����ǥ */, bean.getPhone());
			pstmt.setString(3/*  ����° ����ǥ */, bean.getAddress());
//			pstmt.setregisterDate(4/*  �׹�° ����ǥ */, bean.getregisterDate());
			int cnt = pstmt.executeUpdate();		// SQL�� ���� �ڵ�
			if (cnt==1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con/* �����ϵ� ���ϵ� �����°� �ݳ�*/, pstmt);
		}
		return flag;
	}
	
	// ����Ʈ
	public Vector<MemberBean> getMemberList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;						// sql���� ����� ���� ��
		String sql = null;
		Vector<MemberBean> vlist = new Vector<MemberBean>();				
		try {
			con = pool.getConnection();
			sql = "select * from tblMember";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();				// select�� ������ �ڵ�
			while(rs.next()/* ���� ���ڵ尡 ������ true */) {								// while���� ����ϴ� ������ ��� �����Ͱ� ������ �𸣴ϱ�
				// ���� Ŀ���� �ִ� ���ڵ忡 ���� �ϳ��� �����ͼ� ��� setter �Ѵ�.
				MemberBean bean = new MemberBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setAddress(rs.getString("address"));
//				bean.setTeam(rs.getString("team"));
				vlist.addElement(bean);		// ���Ϳ� ���� ���
			}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			// System.out.println(vlist.size());   �� �۵��ƴ��� Ȯ���ϴ� �뵵
			return vlist;
	}
	
	// �Ѱ��� ���ڵ�
	public MemberBean getMember(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblMember where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setAddress(rs.getString("address"));
	//			bean.setTeam(rs.getString("team"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		// System.out.println(bean.getNum() + " : " + bean.getName());  // ����Ǵ��� Ȯ�ο�
		return bean;
	}
	
	// ����
	public boolean updateMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {						
			con = pool.getConnection();	
			sql = "update tblMember set name = ?, phone = ?," + "address = ?, team = ? where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getAddress());
//			pstmt.setString(4, bean.getTeam());
			pstmt.setInt(5, bean.getNum());
			int cnt = pstmt.executeUpdate();	
			if (cnt==1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con/* �����ϵ� ���ϵ� �����°� �ݳ�*/, pstmt);
		}
		return flag;
	}
	
	// ����
	public void deleteMember(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "delete from tblMember where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	// �ּ� �˻�
	// return�� �����µ� ��� ������ �� ��� vector ���(�迭�� ��� ũ��('�����')�� �˾ƾ��� ),�׸��� Vector�� ����ȭ�� ����
	public Vector<ZipcodeBean> searchZipcode(String area3) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblZipcode where area3 like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + area3 + "%");			//'%�������%'
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipcodeBean bean = new ZipcodeBean();
				bean.setZipcode(rs.getString(1));
				bean.setArea1(rs.getString(2));
				bean.setArea2(rs.getString(3));
				bean.setArea3(rs.getString(4));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	public static void main(String[] args) {
		MemberMgr mgr = new MemberMgr();
		MemberBean bean = new MemberBean();
		bean.setName("��ȣ��2");
		bean.setPhone("010-5555-2323");
		bean.setAddress("�λ�� ������");
//		bean.setTeam("���Ǵ�");
		// boolean result = mgr.insertMember(bean);
		// System.out.println(result);
		// mgr.getMemberList();
		// mgr.getMember(1);
		 mgr.updateMember(bean);
	}
}
