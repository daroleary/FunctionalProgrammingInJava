package com.java8.collections;

import java.util.function.Predicate;

import static com.java8.collections.Folks.comrades;
import static com.java8.collections.Folks.editors;
import static com.java8.collections.Folks.friends;

public class FilterElementsMultipleCollections {

    public static void main(String[] args) {

        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final long countFriendsStartN =
                friends.stream()
                        .filter(startsWithN)
                        .count();

        final long countEditorsStartN =
                editors.stream()
                        .filter(startsWithN)
                        .count();

        final long countComradesStartN =
                comrades.stream()
                        .filter(startsWithN)
                        .count();

        System.out.println(countFriendsStartN);
        System.out.println(countComradesStartN);
        System.out.println(countEditorsStartN);
    }
}
