import React, { Component } from 'react'

class RComp extends Component {
    render() {
        console.log('REGULAR');
        return (
            <div>
                Regular Component {this.props.name}
            </div>
        )
    }
}

export default RComp
