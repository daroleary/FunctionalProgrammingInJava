package com.java8.collections;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import static com.java8.collections.Folks.friends;

public class FilterElements {

    public static void pickName(final List<String> names, final String startingLetter) {
        Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();

        System.out.println(MessageFormat.format("A name starting with {0}: {1}",
                startingLetter, foundName.orElse("No name found")));
    }

    public static void main(String[] args) {
        System.out.println("//" + "START:NAME_OUTPUT");
        pickName(friends, "N");
        pickName(friends, "Z");
        System.out.println("//" + "END:NAME_OUTPUT");

        final Optional<String> foundName =
                friends.stream()
                        .filter(name ->name.startsWith("N"))
                        .findFirst();

        foundName.ifPresent(name -> System.out.println("Hello " + name));
    }
}
