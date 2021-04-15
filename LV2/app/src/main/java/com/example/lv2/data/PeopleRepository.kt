package com.example.lv2.data

import com.example.lv2.model.Person

object PeopleRepository {
    private val people = mutableListOf<Person>(
        Person(
            "Nikola Tesla",
            "The day science begins to study non-physical phenomena, it will make more progress in one decade than in all the previous centuries of its existence."
        ),
        Person(
            "George Boole",
            "The general laws of Nature are not, for the most part, immediate objects of perception."
        ),
        Person(
            "Dennis Ritchie",
            "C++ and Java, say, are presumably growing faster than plain C, but I bet C will still be around."
        ),
        Person("Bill Gates", "If you can't make it good, at least make it look good.")
    )

    fun getPeople(): List<Person> = people
    fun insertPerson(person: Person) = people.add(person)
    fun removePerson(person: Person) = people.remove(person)
}