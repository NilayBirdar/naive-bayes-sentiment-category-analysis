package com.naive.bayes.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naive.bayes.app.chart.CategoryChart;
import com.naive.bayes.app.chart.SentimentChart;
import com.naive.bayes.app.chart.SentimentChartCategory0;
import com.naive.bayes.app.chart.SentimentChartCategory1;
import com.naive.bayes.app.chart.SentimentChartCategory2;
import com.naive.bayes.app.chart.SentimentChartCategory3;
import com.naive.bayes.app.chart.SentimentChartCategory4;
import com.naive.bayes.app.chart.SentimentChartCategory5;
import com.naive.bayes.app.chart.SentimentChartCategory6;
import com.naive.bayes.app.chart.SentimentChartCategory7;
import com.naive.bayes.app.chart.SentimentChartCategory8;
import com.naive.bayes.app.dao.TwitterDao;
import com.naive.bayes.app.entities.TweetSearch;

@RestController
public class ChartController {

	@Autowired
	TwitterDao twitterDao;
	
	 @GetMapping(value= {"/sentimentChart"})
	 public SentimentChart getSentimentChart(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguId();
		 List<String> sentimentLabels = new ArrayList<>();
		 List<String> sentimentColors = new ArrayList<>();
		 List<Long> sentimentValues = new ArrayList<>();
		 SentimentChart sentimentChart = new SentimentChart();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  sentimentColors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  sentimentColors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  sentimentColors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  sentimentLabels.add(object[0].toString());
	        	  sentimentValues.add((Long)object[1]);
	          }
	          
	          sentimentChart.setSentimentLabels(sentimentLabels);
	          sentimentChart.setSentimentValues(sentimentValues);
	          sentimentChart.setSentimentColors(sentimentColors);
	          
	       }
	       
	    return sentimentChart ;
	}
	 
	 @GetMapping(value= {"/categoryChart"})
	 public CategoryChart getCategoryChart(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByKategoriId();
		 List<String> categoryLabels = new ArrayList<>();
		 List<String> categoryColors = new ArrayList<>();
		 List<Long> categoryValues = new ArrayList<>();
		 CategoryChart categoryChart = new CategoryChart();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("0")) {
	        		  object[0]="kapsam dışı";
	        		  categoryColors.add("grey");
	        	  }else if(object[0].toString().equals("1")) {
	        		  object[0]="ekonomi";
	        		  categoryColors.add("green");
	        	  }else if(object[0].toString().equals("2") ){
	        		  object[0]="spor";
	        		  categoryColors.add("yellow");
	        	  }else if(object[0].toString().equals("3") ){
	        		  object[0]="eğlence";
	        		  categoryColors.add("pink");
	        	  }else if(object[0].toString().equals("4") ){
	        		  object[0]="siyaset";
	        		  categoryColors.add("brown");
	        	  }else if(object[0].toString().equals("5") ){
	        		  object[0]="sanat";
	        		  categoryColors.add("purple");
	        	  }else if(object[0].toString().equals("6") ){
	        		  object[0]="eğitim";
	        		  categoryColors.add("blue");
	        	  }else if(object[0].toString().equals("7") ){
	        		  object[0]="eleştiri";
	        		  categoryColors.add("red");
	        	  } else if(object[0].toString().equals("8") ){
	        		  object[0]="bilim";
	        		  categoryColors.add("orange");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " kategori =" + object[0].toString());
	        	  categoryLabels.add(object[0].toString());
	        	  categoryValues.add((Long)object[1]);
	          }
	          
	          categoryChart.setCategoryLabels(categoryLabels);
	          categoryChart.setCategoryValues(categoryValues);
	          categoryChart.setCategoryColors(categoryColors);
	          
	       }
	       
	    return categoryChart ;
	}
	 
	 @GetMapping(value= {"/sentimentChartCategory1"})
	 public SentimentChartCategory1 getSentimentChartCategory1(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId1();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory1 sentimentChartCategory1 = new SentimentChartCategory1();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory1.setLabels(labels);
	          sentimentChartCategory1.setValues(values);
	          sentimentChartCategory1.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory1 ;
	}
	 
	 @GetMapping(value= {"/sentimentChartCategory2"})
	 public SentimentChartCategory2 getSentimentChartCategory2(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId2();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory2 sentimentChartCategory2 = new SentimentChartCategory2();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory2.setLabels(labels);
	          sentimentChartCategory2.setValues(values);
	          sentimentChartCategory2.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory2 ;
	}
	 
	 @GetMapping(value= {"/sentimentChartCategory3"})
	 public SentimentChartCategory3 getSentimentChartCategory3(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId3();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory3 sentimentChartCategory3 = new SentimentChartCategory3();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory3.setLabels(labels);
	          sentimentChartCategory3.setValues(values);
	          sentimentChartCategory3.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory3 ;
	}
	 
	 @GetMapping(value= {"/sentimentChartCategory4"})
	 public SentimentChartCategory4 getSentimentChartCategory4(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId4();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory4 sentimentChartCategory4 = new SentimentChartCategory4();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory4.setLabels(labels);
	          sentimentChartCategory4.setValues(values);
	          sentimentChartCategory4.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory4 ;
	}
	 
	 @GetMapping(value= {"/sentimentChartCategory5"})
	 public SentimentChartCategory5 getSentimentChartCategory5(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId5();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory5 sentimentChartCategory5 = new SentimentChartCategory5();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory5.setLabels(labels);
	          sentimentChartCategory5.setValues(values);
	          sentimentChartCategory5.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory5 ;
	}
	 
	 @GetMapping(value= {"/sentimentChartCategory6"})
	 public SentimentChartCategory6 getSentimentChartCategory6(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId6();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory6 sentimentChartCategory6 = new SentimentChartCategory6();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory6.setLabels(labels);
	          sentimentChartCategory6.setValues(values);
	          sentimentChartCategory6.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory6 ;
	}
	 @GetMapping(value= {"/sentimentChartCategory7"})
	 public SentimentChartCategory7 getSentimentChartCategory7(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId7();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory7 sentimentChartCategory7 = new SentimentChartCategory7();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory7.setLabels(labels);
	          sentimentChartCategory7.setValues(values);
	          sentimentChartCategory7.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory7 ;
	}
	 @GetMapping(value= {"/sentimentChartCategory8"})
	 public SentimentChartCategory8 getSentimentChartCategory8(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId8();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory8 sentimentChartCategory8 = new SentimentChartCategory8();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory8.setLabels(labels);
	          sentimentChartCategory8.setValues(values);
	          sentimentChartCategory8.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory8 ;
	}
	 @GetMapping(value= {"/sentimentChartCategory0"})
	 public SentimentChartCategory0 getSentimentChartCategory0(Model model) {
		 
		 List<Object[]> results = twitterDao.findTweetCountByDuyguIdWhereKategoriId0();
		 List<String> labels = new ArrayList<>();
		 List<String> colors = new ArrayList<>();
		 List<Long>  values = new ArrayList<>();
		 SentimentChartCategory0 sentimentChartCategory0 = new SentimentChartCategory0();
	       if(results != null && !results.isEmpty()){
	          for (Object[] object : results) {
	        	  if(object[0].toString().equals("1")) {
	        		  object[0]="olumlu";
	        		  colors.add("#24a58e");
	        	  }else if(object[0].toString().equals("0")) {
	        		  object[0]="nötr";
	        		  colors.add("#efd458");
	        	  }else if(object[0].toString().equals("-1") ){
	        		  object[0]="olumsuz";
	        		  colors.add("#ba2560");
	        	  }
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	        	  labels.add(object[0].toString());
	        	  values.add((Long)object[1]);
	          }
	          
	          sentimentChartCategory0.setLabels(labels);
	          sentimentChartCategory0.setValues(values);
	          sentimentChartCategory0.setColors(colors);
	          
	       }
	       
	    return sentimentChartCategory0 ;
	}
	 

}
