package org.ufsc.client.orientdb;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import org.ufsc.client.model.Purchase;

public class Graph {

    public void storeGraph(Purchase purchase){
        OrientGraphFactory factory = new OrientGraphFactory("plocal:/tmp/graph/db").setupPool(1,10);

        OrientGraph graph = factory.getTx();

        try {
            Vertex luca = graph.addVertex(null); // 1st OPERATION: IMPLICITLY BEGINS TRANSACTION
            luca.setProperty( "name", "Luca" );
            Vertex marko = graph.addVertex(null);
            marko.setProperty( "name", "Marko" );
            Edge lucaKnowsMarko = graph.addEdge(null, luca, marko, "knows");
            graph.commit();
        } finally {
            graph.shutdown();
        }
    }
}
