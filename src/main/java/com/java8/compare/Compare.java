package com.java8.compare;

import com.google.common.collect.ImmutableList;
import com.java8.compare.dto.Person;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare {

    private static final ImmutableList<Person> people = ImmutableList.of(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35));

    public static void printPeople(final String message,
                                   final List<Person> people) {

        System.out.println(message);
        people.forEach(System.out::println);
    }

    public static void main(String[] args) {

        {
            System.out.println("//" + "START:AGE_ASCEND_OUTPUT");
            List<Person> ascendingAge =
                    people.stream()
                            .sorted(Person::ageDifference)
                            .collect(Collectors.toList());
            printPeople("Sorted in ascending order by age: ", ascendingAge);
            System.out.println("//" + "END:AGE_ASCEND_OUTPUT");
        }

        {
            System.out.println("//" + "START:AGE_ASCEND_MR_OUTPUT");
            List<Person> ascendingAge =
                    people.stream()
                            .sorted(Person::ageDifference)
                            .collect(Collectors.toList());

            printPeople("Sorted in ascending order by age: ", ascendingAge);
            System.out.println("//" + "END:AGE_ASCEND_MR_OUTPUT");
        }

        {
            System.out.println("//" + "START:AGE_DESCEND_OUTPUT");
            printPeople("Sorted in descending order by age: ",
                    people.stream()
                            .sorted((person1, person2) -> person2.ageDifference(person1))
                            .collect(Collectors.toList()));
            System.out.println("//" + "END:AGE_DESCEND_OUTPUT");

            System.out.println("//" + "START:REVERSE_ORDER_OUTPUT");
            Comparator<Person> compareAscending = Person::ageDifference;
            Comparator<Person> compareDescending = compareAscending.reversed();

            printPeople("Sorted in ascending order by age: ",
                    people.stream()
                            .sorted(compareAscending)
                            .collect(Collectors.toList())
            );
            printPeople("Sorted in descending order by age: ",
                    people.stream()
                            .sorted(compareDescending)
                            .collect(Collectors.toList())
            );
            System.out.println("//" + "END:REVERSE_ORDER_OUTPUT");

            System.out.println("//" + "START:NAME_ASCEND_OUTPUT");
            printPeople("Sorted in ascending order by name: ",
                    people.stream()
                            .sorted((person1, person2) ->
                                    person1.getName().compareTo(person2.getName()))
                            .collect(Collectors.toList()));
            System.out.println("//" + "END:NAME_ASCEND_OUTPUT");
        }

        {
            System.out.println("//" + "START:YOUNGEST_OUTPUT");
            people.stream()
                    .min(Person::ageDifference)
                    .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
            System.out.println("//" + "END:YOUNGEST_OUTPUT");
        }

        {
            System.out.println("//" + "START:ELDEST_OUTPUT");
            people.stream()
                    .max(Person::ageDifference)
                    .ifPresent(eldest -> System.out.println("Eldest: " + eldest));
            System.out.println("//" + "END:ELDEST_OUTPUT");
        }

        {
            System.out.println("//" + "START:SORT_NAME_AND_AGE_OUTPUT");

            final Function<Person, Integer> byAge = Person::getAge;
            final Function<Person, String> byTheirName = Person::getName;

            printPeople("Sorted in ascending order by age and name: ",
                    people.stream()
                            .sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
                            .collect(Collectors.toList()));
            System.out.println("//" + "END:SORT_NAME_AND_AGE_OUTPUT");
        }
    }
}
