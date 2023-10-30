package com.example.transport;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.JenaEngine;

@SpringBootApplication
public class TransportApplication {

	//	/**
//	 * @param args
//	 * the command line arguments
//	 */
	public static void main(String[] args) {
//		String NS = "";
//		Model model = JenaEngine.readModel("data/hmida.owl");
//		if (model != null) {
//			NS = model.getNsPrefixURI("");
//			Model inferedModel =JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
//			System.out.println(JenaEngine.executeQueryFile(inferedModel,"data/query.txt"));
//		} else {
//			System.out.println("Error when reading model from ontology");
//		}
//
//	}

		FusekiService fusekiService = new FusekiService("http://localhost:3030/Transport/query");

		// Specify the path to your SPARQL query file
		String sparqlQueryFilePath = "data/query2.txt";

		// Execute the SPARQL query from the file
		ResultSet resultSet = fusekiService.executeSparqlQueryFromFile(sparqlQueryFilePath);

	}
}
