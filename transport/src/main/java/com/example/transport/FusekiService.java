package com.example.transport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.sparql.engine.http.QueryExceptionHTTP;
import org.apache.jena.query.ResultSet;

public class  FusekiService {
    private String fusekiEndpoint;

    public FusekiService(String fusekiEndpoint) {
        this.fusekiEndpoint = fusekiEndpoint;
    }

    public ResultSet executeSparqlQueryFromFile(String sparqlQueryFilePath) {
        try {
            // Read the SPARQL query from the file
            String sparqlQuery = new String(Files.readAllBytes(Paths.get(sparqlQueryFilePath)));

            // Create a Query object from the extracted SPARQL query
            Query query = QueryFactory.create(sparqlQuery);

            try (QueryExecution qexec = QueryExecutionFactory.sparqlService(fusekiEndpoint, query)) {
                ResultSet results = qexec.execSelect();
                System.out.println(results+"result");
                return results;
            } catch (QueryExceptionHTTP e) {
                // Handle SPARQL query execution errors
                e.printStackTrace();
                System.out.println(e);
                return null;
            }
        } catch (IOException e) {
            // Handle file reading errors
            e.printStackTrace();
            System.out.println(e);

            return null;
        }
    }

}
