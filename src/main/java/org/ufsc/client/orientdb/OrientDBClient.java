package org.ufsc.client.orientdb;

import org.ufsc.client.model.Purchase;

import java.util.List;

public class OrientDBClient {

    Document document = new Document();
    Graph graph = new Graph();
    Relational relational = new Relational();

    public void store(List<Purchase> purchases) {

        for(Purchase purchase:purchases){

            document.storeDocument(purchase.getProduct());

            graph.storeGraph(purchase);
        }
    }
}
