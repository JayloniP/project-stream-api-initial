package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamAPITutorial {

    public static void main(String[] args) {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        // C1
        // C2

        //stream.noneMatch(s -> true);   // exception ,error- java: cannot find symbol symbol:variable stream
        class Bar {
            String name;

            Bar(String name) {
                this.name = name;
            }
        }

        class Foo {
            String name;
            List<Bar> bars = new ArrayList<>();

            Foo(String name) {
                this.name = name;
            }
        }

        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- "+ f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

        class Inner {
            String foo;
        }

        class Nested {
            Inner inner;
        }

        class Outer {
            Nested nested;
        }




    }
}