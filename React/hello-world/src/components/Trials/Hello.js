/* eslint-disable */
import React from 'react'

// jsx version
const Hello = () =>{
    /* return (
        <div className:'dummyClass'>
            <h1>Hello Sagar from Inside</h1>
        </div>
    ) */

    return React.createElement(
        'div',
        {id:'hello', className:'dummyClass'},
        React.createElement('h1',null,'Hello Sagar from Inside'));
}

export default Hello