import model.Tree;
import parser.Parser;

import java.io.*;
import java.text.ParseException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        Parser parser = new Parser();

        String data;

        if (args.length == 0) {
            data = "  fun _simpleFun_11_gfdgd  (final:( Int  )->Int  ,_bar_11: _my_1string1):  _123 ";
//            data = "   fun _simpleFun_11_gfdgd(arg1: Int, args2: String) ";
//            data = "fun  __123___ (  arg1: Int): Int ";
        } else {
            data = String.join(" ", args);
        }

        Tree tree = parser.parse(new ByteArrayInputStream(data.getBytes()));
        visualize(tree);
    }

    private static void visualize(Tree tree) throws IOException {
        visualize(tree, "graph");
    }

    private static void visualize(Tree tree, String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(fileName + ".dot")) {
            out.println(tree.toDotFormat());
            try (InputStream input = new FileInputStream("src/resources/config.properties")) {

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
