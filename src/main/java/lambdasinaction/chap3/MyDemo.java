package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author: shenz
 * @date: 2019/10/15
 * @description:
 */
public class MyDemo {
    //Consumer的demo
    public static <T> void  forEach(List<T> list, Consumer<T> c){
        for(T i : list){
            c.accept(i);
        }
    }

    public static void main(String [] agrs){
        Consumer c = (Object i) -> System.out.println(i);
        forEach(Arrays.asList(1,2,3,4,5),c);

        List<Integer> l = map(
                Arrays.asList("lambdas","in","action"),
                (String s) -> s.length()    //←─Lambda是Function接口的apply方法的实现
        );
        System.out.println(l);

    }
    //---
    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }
}
