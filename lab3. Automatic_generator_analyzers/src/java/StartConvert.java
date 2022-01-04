import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

/*  Пример функционала.
          fun1:: (Int ->Int-> Int  ) -> Int ->Int
          fun1 x0 x1 = x0 x1 x1
          fun2::(Int->String)->(Int->Int)->(Int)
          fun2 mul 2 = mul 2 2
          fun2 mul 1 = mul 1
          fun2 mul x | > x  0 = mul 2 3
                     | < x 0 = mul 3 1
          fun2 mul x | == x 0 = mul 2 3
          fun3::Int->Int->Int
          fun3 1 2 = 3
          fun3 2 x = 2
          fun3 x 4 = 2
          fun3 x y | > x 0 = 3
                   | < x 0 = 9

 */

/* Проверка на простоту.
          isPrime::Int->Bool
          isPrime n = == (cntDel n n) 2
            cntDel:: Int->Int   ->Int
          cntDel _ 1  = 1
           cntDel n x | == (% n x) 0 = + 1 (cntDel n (- x 1))
                      | != (% n x) 0 = cntDel n (- x 1)
 */

/* Быстрое возведение в степень.
          fastPow::Int->Int->Int
          fastPow p 0 = 1
          fastPow p n | == (% n 2) 0 = ^ (fastPow p (/ n 2)) 2
                      | != (% n 2) 0 = * p (fastPow p (- n 1))
 */

// don't forget to remove it нахрен. говнокод.
public class StartConvert {
    public static void main(String[] args) throws IOException {
        FunctionalLexer lexer = new FunctionalLexer(CharStreams.fromStream(System.in));
        FunctionalParser parser = new FunctionalParser(new CommonTokenStream(lexer));
        System.out.println(parser.program().p.getImperativeProgram());
    }
}
