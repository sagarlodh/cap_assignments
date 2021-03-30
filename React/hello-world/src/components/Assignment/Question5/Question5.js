import React ,{useState,useEffect} from 'react'
import { Button } from '@material-ui/core';
	
function Question5() {

    const [clockState, setClockState] = useState(new Date())
    const [show,setShow] = useState(false)

    useEffect(() =>  setInterval(() => setClockState(new Date()),1000))

    function showDate(){

        const curr = new Date().toLocaleDateString();
        return curr
    }

    return (
    <div>
        <div>
            <button onClick={()=>setShow(!show)}>Click here to get Date</button>
            <p  style={{fontSize:"50px", margin:"20px"}}>{clockState.toLocaleTimeString()}</p>
        </div>
        <div>
            { 
                show ? <p>{clockState.toLocaleDateString()}</p> : null 
            }
        </div>
    </div>        
    )
}

export default Question5