package ru.ryauzov.springlearn.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ryauzov.springlearn.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Pavel", 20, "pavel@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Denis", 25, "denis@list.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Anton", 34, "anton@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Viktor", 16, "blackvision@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person updatedPerson = show(id);

        updatedPerson.setName(person.getName());
        updatedPerson.setAge(person.getAge());
        updatedPerson.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
