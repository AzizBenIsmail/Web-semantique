package com.example.transport;

import org.apache.jena.rdf.model.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.JenaEngine;

@SpringBootApplication
public class TransportApplication {

	/**
	 * @param args
	 * the command line arguments
	 */
	public static void main(String[] args) {
		String NS = "";
// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/hmida.owl");
		if (model != null) {
//lire le Namespace de l’ontologie
			NS = model.getNsPrefixURI("");
// apply our rules on the owlInferencedModel
			Model inferedModel =

					JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
// query on the model after inference
			System.out.println(JenaEngine.executeQueryFile(inferedModel,

					"data/query.txt"));

		} else {
			System.out.println("Error when reading model from ontology");
		}
	}}
