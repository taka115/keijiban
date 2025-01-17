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
	
	

}
