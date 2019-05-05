package org.ufsc.client.orientdb;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import org.ufsc.client.model.Product;

public class Document {

    public void storeDocument(Product product){

        ODatabaseDocumentTx db = new ODatabaseDocumentTx("remote:localhost/petshop").open("admin", "admin");

        ODocument doc = new ODocument("Product");
        doc.field( "description", product.getDescription());
        doc.save();

        db.close();
    }
}
