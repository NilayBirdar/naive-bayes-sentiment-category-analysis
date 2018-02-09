package com.naive.bayes.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.naive.bayes.app.entities.Tweet;


public interface TwitterDao extends CrudRepository<Tweet, Integer>{
	
	List<Tweet> findByDuyguId(Integer duyguId);
	Tweet findByTwitterId(Long id);
	List<Tweet> findByDuyguIdAndSentimentProgrammatic(Integer duyguId, Integer programmatic);
	List<Tweet> findBySentimentProgrammatic(Integer sentimentProgrammatic);
	List<Tweet> findByDuyguIdOrKategoriId(Integer duyguId, Integer kategoriId);
    List<Tweet> findByKategoriIdAndSentimentProgrammatic(Integer kategoriId, Integer programmatic);
	List<Tweet> findByKategoriIdAndCategoryProgrammatic(Integer kategoriId, Integer categoryProgrammatic);
	List<Tweet> findBySentimentProgrammaticAndCategoryProgrammatic(Integer sentimentProgrammatic, Integer categoryProgrammatic);
	List<Tweet> findByKategoriId(Integer kategoriId);
	List<Tweet> findBySentimentProgrammaticOrCategoryProgrammatic(Integer sentimentProgrammatic,Integer categoryProgrammatic);
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguId();
	
	@Query("select v.kategoriId as kategori ,count(v) as cnt from Tweet v where categoryProgrammatic=1 group by v.kategoriId")
	public  List<Object[]> findTweetCountByKategoriId();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=0 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId0();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=1 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId1();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=2 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId2();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=3 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId3();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=4 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId4();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=5 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId5();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=6 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId6();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=7 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId7();
	
	@Query("select v.duyguId as duygu ,count(v) as cnt from Tweet v where sentimentProgrammatic=1 and kategoriId=8 and categoryProgrammatic=1  group by v.duyguId")
	public  List<Object[]> findTweetCountByDuyguIdWhereKategoriId8();
	
	

}
