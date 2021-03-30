/* eslint-disable */
import React, {Component} from 'react'

class Message extends Component{
    constructor(){
        super()
        this.state = {
            message: 'Welcome Visitor'
        }
    }
    changeMessage(){
        this.setState({
            message: 'Thankyou for subscribing'
        })
    }
    render(){
        return  (
            <div>
                <p>
                    <h1>{this.state.message}</h1>
                    <button onClick={()=>this.changeMessage()}>Subscribe</button>
                </p>
            </div>
        )
    }
}

export default Message