package com.example.lv2.data

import com.example.lv2.model.Person

object PeopleRepository {
    private val people = mutableListOf<Person>(
        Person(
            "Nikola Tesla",
            "July 10, 1856",
            "Nikola Tesla was a Serbian-American inventor, electrical engineer, mechanical engineer, and futurist best known for his contributions to the design of the modern alternating current electricity supply system.",
            "The day science begins to study non-physical phenomena, it will make more progress in one decade than in all the previous centuries of its existence.",
            "https://upload.wikimedia.org/wikipedia/commons/7/79/Tesla_circa_1890.jpeg",
        ),
        Person(
            "George Boole",
            "November 2, 1815",
            "George Boole was a largely self-taught English mathematician, philosopher and logician, most of whose short career was spent as the first professor of mathematics at Queen's College, Cork in Ireland.",
            "The general laws of Nature are not, for the most part, immediate objects of perception.",
            "https://static.independent.co.uk/s3fs-public/thumbnails/image/2015/11/02/08/georgeboole.jpg?width=1200"
        ),
        Person(
            "Dennis Ritchie",
            "September 9, 1941",
            "Dennis MacAlistair Ritchie was an American computer scientist. He created the C programming language and, with long-time colleague Ken Thompson, the Unix operating system and B programming language.",
            "C++ and Java, say, are presumably growing faster than plain C, but I bet C will still be around.",
            "https://www.invent.org/sites/default/files/styles/inductee_detail_media/public/inductees/2019-02/Ritchie%2C-Dennis_b%26w.jpg?h=157d851b&itok=HAZRfT8c"
        ),
        Person(
            "Bill Gates",
            "October 28, 1955",
            "William Henry Gates III is an American business magnate, software developer, investor, author, landowner and philanthropist. He is a co-founder of Microsoft Corporation.",
            "If you can't make it good, at least make it look good.",
            "https://ep01.epimg.net/estaticos/arc/2021/02/entrevista/img/bill.jpg"
        )
    )

    fun getPeople(): List<Person> = people
    fun insertPerson(person: Person) = people.add(person)
    fun removePerson(person: Person) = people.remove(person)
}