package com.java8.compare;

import com.google.common.collect.ImmutableList;
import com.java8.compare.dto.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class OlderThan20 {

    private static final ImmutableList<Person> people = ImmutableList.of(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35));

    public static void main(String[] args) {
        {
            System.out.println("//" + "START:COLLECT_TO_LIST_OUTPUT");
            List<Person> olderThan20 =
                    people.stream()
                            .filter(person -> person.getAge() > 20)
                            .collect(Collectors.toList());
            System.out.println("People older than 20: " + olderThan20);
            System.out.println("//" + "END:COLLECT_TO_LIST_OUTPUT");
        }

        {
            System.out.println("//" + "START:GROUP_BY_OUTPUT");
            Map<Integer, List<Person>> peopleByAge =
                    people.stream()
                            .collect(Collectors.groupingBy(Person::getAge));
            System.out.println("Grouped by age: " + peopleByAge);
            System.out.println("//" + "END:GROUP_BY_OUTPUT");
        }

        {
            System.out.println("//" + "START:GROUP_BY_AGE_NAME_OUTPUT");
            Map<Integer, List<String>> nameOfPeopleByAge =
                    people.stream()
                            .collect(
                                    Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
            System.out.println("People grouped by age: " + nameOfPeopleByAge);
            System.out.println("//" + "END:GROUP_BY_AGE_NAME_OUTPUT");
        }

        {
            System.out.println("//" + "START:OLDEST_IN_EACH_LETTER_OUTPUT");
            Comparator<Person> byAge = Comparator.comparing(Person::getAge);
            Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                    people.stream()
                            .collect(Collectors.groupingBy(person -> person.getName().charAt(0),
                                    Collectors.reducing(BinaryOperator.maxBy(byAge))));
            System.out.println("Oldest person of each letter:");
            System.out.println(oldestPersonOfEachLetter);
            System.out.println("//" + "END:OLDEST_IN_EACH_LETTER_OUTPUT");
        }
    }
}
