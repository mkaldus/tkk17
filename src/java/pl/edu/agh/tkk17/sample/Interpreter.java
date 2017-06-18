package pl.edu.agh.tkk17.sample;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.Math;
import java.nio.charset.StandardCharsets;

public class Interpreter
{
    public static void main(String []args)
    {
        try {
//            InputStream stream = new ByteArrayInputStream("2+3*5+6\n".getBytes(StandardCharsets.UTF_8));
//            InputStream stream = new ByteArrayInputStream("(9/0)\n".getBytes(StandardCharsets.UTF_8));
            Scanner scanner = new Scanner(System.in);
//            Scanner scanner = new Scanner(stream);
            Node tree = Parser.parse(scanner);
            float result = Evaluator.evaluate(tree);
            String repr;
            if (result - Math.floor(result) > 0) {
                repr = String.valueOf(result);
            } else {
                int intval = Math.round(result);
                repr = String.valueOf(intval);
            }
            System.out.println(repr);
        } catch (OutputableException e) {
            String message = e.getMessage();
            e.printStackTrace();
            System.err.println("Interpretation failed. " + message);
        }
    }
}
