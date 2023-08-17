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
	
	// 저장
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {					// Pooling 기법이란 미리 데이터베이스 Connection을 여러 개 만들어서 특정 공간에 저장해 놓고, 
									//여러 사용자가 필요할 때 마다 하나씩 꺼내서 사용하고 다시 집어 넣는 방식
			con = pool.getConnection();	// connection 객체를 빌려옴
			sql = "insert user_asd ()values(null, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1/*  첫번째 물음표 */, bean.getName());
			pstmt.setString(2/*  두번째 물음표 */, bean.getPhone());
			pstmt.setString(3/*  세번째 물음표 */, bean.getAddress());
//			pstmt.setregisterDate(4/*  네번째 물음표 */, bean.getregisterDate());
			int cnt = pstmt.executeUpdate();		// SQL문 실행 코드
			if (cnt==1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con/* 실행하든 안하든 빌려온거 반납*/, pstmt);
		}
		return flag;
	}
	
	// 리스트
	public Vector<MemberBean> getMemberList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;						// sql문의 결과가 담기는 곳
		String sql = null;
		Vector<MemberBean> vlist = new Vector<MemberBean>();				
		try {
			con = pool.getConnection();
			sql = "select * from tblMember";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();				// select만 가능한 코드
			while(rs.next()/* 다음 레코드가 있으면 true */) {								// while문을 사용하는 이유는 몇개의 데이터가 들어올지 모르니까
				// 현재 커서가 있는 레코드에 값을 하나씩 가져와서 빈즈에 setter 한다.
				MemberBean bean = new MemberBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setAddress(rs.getString("address"));
//				bean.setTeam(rs.getString("team"));
				vlist.addElement(bean);		// 벡터에 빈즈 담기
			}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			// System.out.println(vlist.size());   잘 작동됐는지 확인하는 용도
			return vlist;
	}
	
	// 한개의 레코드
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
		// System.out.println(bean.getNum() + " : " + bean.getName());  // 실행되는지 확인용
		return bean;
	}
	
	// 수정
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
			pool.freeConnection(con/* 실행하든 안하든 빌려온거 반납*/, pstmt);
		}
		return flag;
	}
	
	// 삭제
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
	// 주소 검색
	// return을 던졌는데 몇개가 들어올지 모를 경우 vector 사용(배열의 경우 크기('몇개인지')를 알아야함 ),그리고 Vector는 동기화가 가능
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
			pstmt.setString(1, "%" + area3 + "%");			//'%강남대로%'
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
		bean.setName("강호동2");
		bean.setPhone("010-5555-2323");
		bean.setAddress("부산시 연제구");
//		bean.setTeam("동의대");
		// boolean result = mgr.insertMember(bean);
		// System.out.println(result);
		// mgr.getMemberList();
		// mgr.getMember(1);
		 mgr.updateMember(bean);
	}
}
