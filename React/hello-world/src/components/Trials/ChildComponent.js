/* eslint-disable */
import React from 'react'

function ChildComponent(props) {
    return (
        <div>
            <button onClick={()=>props.greetHandler('child')}>Greet Parent from Child</button>
        </div>
    )
}
export default ChildComponent
