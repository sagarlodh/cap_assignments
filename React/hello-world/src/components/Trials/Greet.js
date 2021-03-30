/* eslint-disable */
import React from 'react'

/* function Greet(){
    return <h1>Hello Sagar</h1>
}
 */
const Greet = props => {
    // destructuring
    const {name, heroname} = props
    return (
        <div>
            <h1>Hello {name} a.k.a {heroname}</h1>
            {props.children}
        </div>
    )
}
export default Greet