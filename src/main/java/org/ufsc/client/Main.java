package org.ufsc.client;

import org.apache.jena.graph.Triple;
import org.ufsc.client.model.Product;
import org.ufsc.client.model.Purchase;
import org.ufsc.client.model.User;
import org.ufsc.client.orientdb.OrientDBClient;
import org.ufsc.client.waRDF.WAClient;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void experimentWARDF(List<Purchase> purchases){

        WAClient client = new WAClient();

        Triple triple = Triple.create(null, null, null);

        client.store(triple);
    }

    public static void experimentOrientDB(List<Purchase> purchases){

        OrientDBClient orientDBClient = new OrientDBClient();
        orientDBClient.store(purchases);

    }

    public static void main(String [] args){

        User user = new User();
        user.setName("user1");
        Product product = new Product();
        product.setDescription("product1");

        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setProduct(product);
        purchase.setDate(new Date());

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchase);

        experimentOrientDB(purchases);
        experimentWARDF(purchases);

    }
}
