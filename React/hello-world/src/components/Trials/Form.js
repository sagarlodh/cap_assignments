import React, { Component } from 'react'

class Form extends Component {
    constructor(props) {
        super(props)
        this.state = {
             username: '',
             comments: '',
             topic: ''
        }
    }
    handleUsernameChange = (event) => {
        this.setState({
            username: event.target.value
        })
    }
    handleCommentsChange = (event) => {
        this.setState({
            comments: event.target.value
        })
    }
    handleTopicChange = (event) => {
        this.setState({
            topic: event.target.value
        })
    }
    handleSubmit = event => {
        console.log(this.state.username)
        console.log(this.state.comments)
        console.log(this.state.topic)
        event.preventDefault()
    }
    render() {
        const {username} = this.state
        return (
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label>Username: </label>
                    <input type='text' value={username} onChange={this.handleUsernameChange}></input>
                </div><br/>
                <div>
                    <label>Comments: </label>
                    <textarea value={this.state.comments} onChange={this.handleCommentsChange}></textarea>
                </div><br/>
                <div>
                    <label>Topic: </label>
                    <select value={this.state.topic} onChange={this.handleTopicChange}>
                        <option value='' disabled>Select Topic</option>
                        <option value='React'>React</option>
                        <option value='Angular'>Angular</option>
                        <option value='Vue'>Vue</option>
                    </select>
                </div><br/>
                <button type='submit'>Submit</button>
            </form>
            
        )
    }
}

export default Form
