package dao;

import java.util.List;

import domain.Keijiban;

public interface KeijibanDao {
	
	// ページネーションなしの全件取得
	List<Keijiban> findAll() throws Exception;
	
	// ページベーション付きの全件取得
    List<Keijiban> findAllPaged(int page, int limit) throws Exception;
    
	// キーワード検索(ページベーション付き)
	List<Keijiban> findByKeyword(String keyword, int page, int limit) throws Exception;
	
	// コメントの挿入
	void insert(Keijiban keijiban) throws Exception;
	
	// コメントの削除
	void delete(int id) throws Exception;
	
	// 全コメント数をカウント
	int countAll() throws Exception;
	
	// キーワード検索結果の総数をカウント
	int countByKeyword(String keyword) throws Exception;


}
