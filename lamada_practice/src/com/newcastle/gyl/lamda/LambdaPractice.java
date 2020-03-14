package com.newcastle.gyl.lamda;

/**
 * lambda expression can only be implemented to the interface with one abstract method.
 *
 * Simplify: when there is only one method in the implementation code of lambda expression (within {})
 * the '{}' and ';' can be ignored.
 */
public class LambdaPractice {

    public static void main(String[] args){
        System.out.println("1. void method without parameter");
        useEatable(() -> {
            System.out.println("eat");
        });

        System.out.println("----------------------------------");

        //Simplify: when there is only one method in the implementation code of lambda expression (within {})
        //the '{}' and ';' can be ignored.
        useEatable(() -> System.out.println("eat"));

        System.out.println("==================================");

        System.out.println("2. void method with parameter");
        useFruit((String str) ->{
            System.out.println(str);;
        });
        System.out.println("----------------------------------");
        //Simplify: the data type of parameter can be ignored;
        // Also, when there is only one parameter, '()'can be ignored
        useFruit(str -> System.out.println(str));

        System.out.println("==================================");

        System.out.println("3. return method");
        useAddable((int a,int b)-> {return a+b;});
        System.out.println("----------------------------------");
        //Simplify: the data type of parameter can be ignored(both or neither);
        // And for one line implementation code, when ignoring '{}' and ';', 'return' should be ignored as well.
        useAddable((a,b)-> a+b);
    }

    public static  void useEatable(Eatable e){
        e.eat();
    }

    public static  void useFruit(Fruit fruit){
        fruit.eatFruit("apple");
    }

    public static void useAddable(Addable addable){
        System.out.println(addable.add(20,10));
    }
}
