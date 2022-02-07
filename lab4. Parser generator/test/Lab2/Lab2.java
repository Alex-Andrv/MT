package Lab2;

import util.Tree;

import java.io.*;
import java.text.ParseException;
import java.util.Properties;

public class Lab2 {
    public static void main(String[] args) throws IOException, ParseException {
        String in = "  fun simpleFun (final:( Int  ) -> Int  ,_bar_11: _my_1string1):_123  ";

        visualize(new Lab2Parser(new ByteArrayInputStream(in.getBytes())).s());
    }

    private static void visualize(Tree tree) throws IOException {
        visualize(tree, "graph");
    }

    private static void visualize(Tree tree, String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(fileName + ".dot")) {
            out.println(tree.toDotFormat());
            try (InputStream input = new FileInputStream("test/resources/config.properties")) {

                Properties prop = new Properties();

                // load a properties file
                prop.load(input);

                // get the property value
                String dotFullName = prop.getProperty("dot");

                Runtime.getRuntime().exec(
                        dotFullName + " -Tpng " + fileName + ".dot -o " + fileName + ".png");
            }
        }
    }
}
