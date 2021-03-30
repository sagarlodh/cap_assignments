import React, { Component } from 'react'
import PureComp from './PureComp'
import RComp from './RComp'

// extend PureComponent if not to re-render
class ParentComp extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name: 'Sagar'
        }
    }
    
    componentDidMount(){
        setInterval( () => {
            this.setState({
                name : 'Sagar'
            })
        },2000)
    }
    render() {
        console.log('*****************PARENT******************');
        return (
            <div>
                Parent Component
                <RComp name={this.state.name}></RComp>
                <PureComp name={this.state.name}></PureComp>
            </div>
        )
    }
}

export default ParentComp
