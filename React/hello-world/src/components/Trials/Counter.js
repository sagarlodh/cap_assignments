/* eslint-disable */
import React, { Component } from 'react'

class Counter extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             count: 0
        }
    }
    incrementMethod(){
        this.setState({
            count : this.state.count + 1
        }, () => {
            console.log('Call Back Value : ' , this.state.count)
            }
        )

        /* this.setState(prevState => ({
            count: prevState + 1
        })) */
        console.log(this.state.count); 
    }
    incrementThree(){
        this.incrementMethod
        this.incrementMethod
        this.incrementMethod
    }
    render() {
        return (
            <div>
                count - {this.state.count}
                <p><button onClick={()=>this.incrementMethod()}>Increment One</button></p>
                {/* <p><button onClick={()=>this.incrementThree()}>Increment Three</button></p> */}
            </div>        
        )
    }
}

export default Counter
