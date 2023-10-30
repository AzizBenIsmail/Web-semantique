package com.example.transport;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.sparql.engine.http.QueryExceptionHTTP;

import org.apache.jena.query.ResultSet;


public class FusekiService {
    private String fusekiEndpoint; // Injectez la valeur depuis votre configuration

    public FusekiService(String fusekiEndpoint) {
        this.fusekiEndpoint = fusekiEndpoint;
    }

    public ResultSet executeSparqlQuery(String sparqlQuery) {
        Query query = QueryFactory.create(sparqlQuery);
        try (QueryExecution qexec = QueryExecutionFactory.sparqlService(fusekiEndpoint, query)) {
            ResultSet results = qexec.execSelect();
            return results;
        } catch (QueryExceptionHTTP e) {
            // Gérez les erreurs liées à la requête SPARQL
            e.printStackTrace();
            return null;
        }
    }
}
