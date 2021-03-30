/* eslint-disable */
import React, {Component} from 'react'

class Welcome extends Component{
    render(){
        const {name, heroname} = this.props
        return  <h1>Welcome {name} a.k.a {heroname}</h1>
    }
}

export default Welcome 