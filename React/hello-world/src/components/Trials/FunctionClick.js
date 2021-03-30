/* eslint-disable */
import React from 'react'
function FunctionClick() {
    function clickHandler(){
        console.log('Function button clicked');
    }
    return (
        <div>
            <button onClick={clickHandler}>Function Click</button>
        </div>
    )
}
export default FunctionClick
