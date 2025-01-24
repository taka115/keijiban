package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Keijiban;

public class KeijibanDaoImpl implements KeijibanDao {
	
	DataSource ds;
	
	public KeijibanDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Keijiban> findAll() throws Exception {
		List<Keijiban> keijibanList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM keijiban ORDER BY created_at ASC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			    Integer id = (Integer) rs.getObject("id"); 
				String name = rs.getString("name");
				String comment = rs.getString("comment"); 
				Timestamp created_at= rs.getTimestamp("created_at");
				Keijiban keijiban = new Keijiban(id, name, comment, created_at);
				keijibanList.add(keijiban);
			}
		} catch (Exception e) {
			throw e;
		}
		System.out.println("データベースから取得したリスト：" + keijibanList);
		return keijibanList;
	}

	@Override
	public void insert(Keijiban keijiban) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO keijiban (name, comment) VALUES (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, keijiban.getName());
			stmt.setString(2, keijiban.getComment());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void delete(int id) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM keijiban WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public List<Keijiban> findByKeyword(String keyword,int page, int limit) throws Exception {
		List<Keijiban> keijibanList = new ArrayList<>();
		int offset = (page - 1) * limit; //オフセット計算
		
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM keijiban WHERE name LIKE ? OR comment LIKE ? "
					 + "ORDER BY created_at DESC LIMT ? OFFSET ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			String searchKeyword = "%" + keyword + "%"; // 部分一致のためのワイルドカード
			stmt.setString(1, searchKeyword);
			stmt.setString(2, searchKeyword);
			stmt.setInt(3, limit);
			stmt.setInt(4, offset);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = (Integer)rs.getObject("id");
				String name = rs.getString("name");
				String comment = rs.getString("comment");
				Timestamp created_at = rs.getTimestamp("created_at");
				Keijiban keijiban = new Keijiban(id, name, comment, created_at);
				keijibanList.add(keijiban);
			}
			
		} catch (Exception e) {
			throw e;
		}
		System.out.println("検査結果:" + keijibanList);
		return keijibanList;
	}

	@Override
	public List<Keijiban> findAll(int page, int limit) throws Exception {
		int ofset = (page -1) * limit;
		List<Keijiban> keijibanList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM keijiban ORDER BY created_at DESC LIMIT ? OFFSET ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, limit);
			stmt.setInt(2, ofset);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = (Integer) rs.getObject("id");
				String name = rs.getString("name");
				String comment = rs.getString("comment");
				Timestamp created_at = rs.getTimestamp("created_at");
				Keijiban keijiban = new Keijiban(id, name, comment, created_at);
				keijibanList.add(keijiban);
			}
		} catch (Exception e) {
			throw e;
		}
		return keijibanList;
	}

	@Override
	public int countAll() throws Exception {
		int count = 0;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT COUNT(*) FROM keijiban";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); // 結果の1列目に総レコード数が格納される
			}
		} catch (Exception e) {
			throw e;
		}
		return count;
	}

	@Override
	public int countByKeyword(String keyword) throws Exception {
		int count = 0;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT COUNT(*) FROM keijiban WHERE name LIKE ? OR comment LIKE ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			String searchKeyword = "%" + keyword + "%";
	        stmt.setString(1, searchKeyword);
	        stmt.setString(2, searchKeyword);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	count = rs.getInt(1);
	        }
		} catch (Exception e) {
			throw e;
		}
		return count;
	}
	
	

}
