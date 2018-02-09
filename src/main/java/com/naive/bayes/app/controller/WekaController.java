package com.naive.bayes.app.controller;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.experiment.InstanceQuery;

@RestController
@RequestMapping(value= {"/weka"})
public class WekaController {
	
	 @RequestMapping(value= {"/"})
	 public String getHomePage() throws Exception {
//		 ArffLoader loader = new ArffLoader();
//		    loader.setFile(new File("aa"));
		 System.out.println("Request!!!!");
		 InstanceQuery query = new InstanceQuery();
		 query.setUsername("nilaybirdar");
		 query.setPassword("15052010");
		 query.setQuery("select email,passenger_name from springbootdb.ticket");
		 System.out.println("Query!!!!");
		    Instances structure = query.retrieveInstances();
		    structure.setClassIndex(structure.numAttributes() - 1);
		    System.out.println("structure is OK!!!!");
		    
		    // train NaiveBayes
		    NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
		    nb.buildClassifier(structure);
		    System.out.println("nb OK!!!!");
		    Instance current;
		   // while ((current = loader.getNextInstance(structure)) != null)
		    while ((current = structure.iterator().next()) != null)
		        nb.updateClassifier(current);

		    System.out.println("updateClassifier is OK!!!!");
		    // output generated model
		    System.out.println(nb);
	    return "home";
	}

}
