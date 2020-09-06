import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Collection<Person> persons = Arrays.asList(
                new Person("Jack", "Evans", 16, Sex.MAN, Education.SECONDARY),
                new Person("Connor", "Young", 23, Sex.MAN, Education.FURTHER),
                new Person("Emily", "Harris", 42, Sex.WOMEN, Education.HIGHER),
                new Person("Harry", "Wilson", 69, Sex.MAN, Education.HIGHER),
                new Person("George", "Davies", 35, Sex.MAN, Education.FURTHER),
                new Person("Samuel", "Adamson", 40, Sex.MAN, Education.HIGHER),
                new Person("Marty", "Evans", 17, Sex.MAN, Education.SECONDARY),
                new Person("Connor", "Morison", 23, Sex.MAN, Education.FURTHER),
                new Person("Emily", "Dorison", 61, Sex.WOMEN, Education.HIGHER),
                new Person("John", "Brown", 44, Sex.MAN, Education.HIGHER)
        );

        findNotAdults(persons);
        findConscriptsSurnames(persons);
        findEfficientPeoples(persons);
    }

    public static void findNotAdults(Collection<Person> persons) {
        Stream<Person> stream = persons.stream();
        long count = stream
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + count);
        System.out.println();
    }

    public static void findConscriptsSurnames(Collection<Person> persons) {
        Stream<Person> stream = persons.stream();
        List<String> conscripts;
        conscripts = stream
                .filter(person -> person.getAge() > 18 && person.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Список призывников:");
        conscripts.forEach(System.out::println);
        System.out.println();
    }

    public static void findEfficientPeoples(Collection<Person> persons) {
        Stream<Person> stream = persons.stream();
        List<Person> personList;
        personList = stream
                .filter(person -> person.getSex().equals(Sex.MAN) && person.getAge() > 18 && person.getAge() < 65 ||
                        person.getSex().equals(Sex.WOMEN) && person.getAge() > 18 && person.getAge() < 60)
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        personList.forEach(System.out::println);

    }

}
