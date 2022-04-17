package com.company1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;


public class FilteringApples {
  private  static  List<Apple> apples= Arrays.asList(new Apple(150, Color.RED), new Apple(150, Color.GREEN),
            new Apple(250, Color.RED), new Apple(110, Color.GREEN),
            new Apple(50, Color.RED), new Apple(120, Color.GREEN),
            new Apple(90, Color.RED), new Apple(110, Color.GREEN),
            new Apple(60, Color.RED), new Apple(130, Color.GREEN)
  );

    public static void main(String[] args) {
       /* Comparator<Apple> comparateur = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };
        */

/*
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        /*
        for (Apple apple:apples
             ) {
            System.out.println(apple);

        }
        */
        Comparator<Apple> comparator=(Apple o1, Apple o2) -> o1.getWeight() - o2.getWeight();
          //apples.sort(comparator);


        apples.sort(comparing(Apple :: getWeight));


        apples.forEach(apple -> System.out.println(apple));


        System.out.println("***************************Green Apples");
       /* Predicate<Apple> predicate=new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == Color.GREEN;
            }
        };*/
        //List<Apple> greenApples=filtrer(predicate);
        //greenApples.forEach(apple -> System.out.println(apple));

        List<Apple> gr=filtrer((Apple t)->t.getColor() == Color.GREEN);
        gr.forEach(apple -> System.out.println(apple));

        System.out.println("***************************Green Red");

        List<Apple> red1=filtrer((Apple t)->t.getColor() == Color.RED);
        red1.forEach(apple -> System.out.println(apple));

        System.out.println("***************************poid 150");
        List<Apple> p=filtrer((Apple t)->t.getWeight() >= 150);
        p.forEach(apple -> System.out.println(apple));
        System.out.println("***************************with class anonyme 150");
        List<Apple> s=filtrer(new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() >= 150;
            }
        });
        p.forEach(apple -> System.out.println(apple));

        System.out.println("***************************heavy and red apples 150");
        List<Apple> hR =filtrer((Apple t) ->
                t.getColor() == Color.RED && t.getWeight() >= 150

        );
        hR.forEach(apple -> System.out.println(apple));
        System.out.println("***************************red color");

        //programation conconretionnelle

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        runnable = ()-> System.out.println("ok");


    }



    public enum Color{
        RED,GREEN
    }

     public static class  Apple {
        private int weight;
        private  Color color;

         public Apple(int weight, Color color) {
             this.weight = weight;
             this.color = color;
         }

         public int getWeight() {
             return weight;
         }

         public void setWeight(int weight) {
             this.weight = weight;
         }

         public Color getColor() {
             return color;
         }

         public void setColor(Color color) {
             this.color = color;
         }

         @Override
         public String toString() {
             return "Apple{" +
                     "weight=" + weight +
                     ", color=" + color +
                     '}';
         }
     }
//predicate renvoi un boolean
     public static List<Apple> filtrer(Predicate<Apple> predicate){

        List<Apple> newApples =new ArrayList<Apple>();
        /*
         for (Apple apple:apples
              ) {
             if(predicate.test(apple)){
                 newApples.add(apple);
             }

         }
        return  newApples;

         */

         apples.forEach(apple -> {
             if(predicate.test(apple)){
                 newApples.add(apple);
             }


         });

         return newApples;
     }
     /*
    public static List<Apple> filtrer(BiPredicate<Apple,Color> biPredicate,Color color){
        List<Apple> newApples =new ArrayList<Apple>();

       apples.forEach(apple -> {
           if(biPredicate.test(apple,color))
               newApples.add(apple);
       });
    }
    */



}
