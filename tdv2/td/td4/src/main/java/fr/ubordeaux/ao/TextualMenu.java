package fr.ubordeaux.ao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TextualMenu {
    private BufferedReader in;
    private PrintWriter out;
    private Catalog catalog;

    protected TextualMenu(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
        initCollection();
    }

    protected TextualMenu(InputStream in, PrintStream out) {
        InputStreamReader inputStreamReader;
        OutputStreamWriter writer;
        try {
            inputStreamReader = new InputStreamReader(in, "UTF-8");
            writer = new OutputStreamWriter(out, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        this.in = new BufferedReader(inputStreamReader);
        this.out = new PrintWriter(writer, true);
        initCollection();
    }

    private void initCollection() {
        catalog = new CatalogImpl("ab");
    }

    protected void handleUserInstructions() throws IOException {
        boolean end = false;
        while (!end) {
            out.println("(1) Add new Reference to Catalog,  (2) exit");
            out.println("Your choice 1-2:");
            String choice = in.readLine();
            if (choice == null) {
                throw new RuntimeException();
            }
            switch (choice) {
                case "1" : createReferenceAndAddItToCatalog();
                            break;
                case "2" : end = true;
                    break;
                default :
                    break;
            }
        }
    }

    private void createReferenceAndAddItToCatalog() throws IOException {
        out.println(
            "You ask to create a new reference and add it to the root catalog!"
            );
        out.println(
            "Reference id (any string, must be unique) : "
        );
        String refId = in.readLine();
        if (refId == null) {
            throw new RuntimeException();
        }
        out.println("Reference name : ");

        String refName = in.readLine();
        if (refName == null) {
            throw new RuntimeException();
        }
        out.println("Reference description : ");

        String refDescription = in.readLine();
        if (refDescription == null) {
            throw new RuntimeException();
        }

        out.println("Price : ");
        String price = in.readLine();
        if (price == null) {
            throw new RuntimeException();
        }
        Price refPrice = new Price(Integer.parseInt(price));

        Reference reference =
            new Reference(refId,
                refName,
                refDescription,
                refPrice);

        catalog.addReference(reference);
        out.println(
            "Reference ("
            + refId
            + ") has been created and added to the catalog !");
    }

}
