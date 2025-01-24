package dao;

import java.util.List;

import domain.Keijiban;

public interface KeijibanDao {
	
	List<Keijiban> findAll() throws Exception;
	
	void insert(Keijiban keijiban) throws Exception;
	
	void delete(int id) throws Exception;
	
	List<Keijiban> findByKeyword(String keyword, int page, int limit) throws Exception;
	
	List<Keijiban> findAll(int page, int limit) throws Exception;
	
	int countAll() throws Exception;
	
	int countByKeyword(String keyword) throws Exception;


}
