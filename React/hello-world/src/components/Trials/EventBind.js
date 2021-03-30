/* eslint-disable */
import React, { Component } from 'react'
// there are 4 ways of doing event handling
class EventBind extends Component {
    constructor(props) {
        super(props)
        this.state = {
             message: 'Hello'
        }
        //this.clickHandler = this.clickHandler.bind(this)
    }
    /* clickHandler(){
        this.setState({
            message: 'Good Bye'
        })
        console.log(this);
    }*/
    clickHandler = () => {
        this.setState({
            message: 'Good Bye'
        })
    }
    render() {
        return (
            <div>
                <div>{this.state.message}</div>
                <button onClick={this.clickHandler}>Click</button>
            </div>
   )
    }
}

export default EventBind
