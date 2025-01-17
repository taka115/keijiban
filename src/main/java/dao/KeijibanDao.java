package dao;

import java.util.List;

import domain.Keijiban;

public interface KeijibanDao {
	
	List<Keijiban> findAll() throws Exception;
	
	void insert(Keijiban keijiban) throws Exception;
	
	void delete(int id) throws Exception;

}
