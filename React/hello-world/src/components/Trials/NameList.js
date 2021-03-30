import React from 'react'
function NameList() {
    const persons = [
        {
            id: 1,
            name: 'Bruce',
            age: 30,
            skill: 'React'
        },
        {
            id: 2,
            name: 'Clark',
            age: 28,
            skill: 'Angular'
        }
    ]
    // can be moved to another component 'Persons'
    // then we also can resolve the 'key needed' warning by 
    // mentioning a <Person key={person.id} person={person}/> inside the 'map
    const personList = persons.map(person =>(
    <h2>
        I am {person.name}, I am {person.age} yrs old, I am skilled in {person.skill}
    </h2>
    ))
    return <div>{personList}</div>
}
export default NameList
