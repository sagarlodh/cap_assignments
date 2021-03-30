import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
class Question3 extends Component {
    constructor(props) {
        super(props)
        this.name = React.createRef();
        this.state = {
             title:'Job Form',
             act:0,
             index:'',
             datas: []
        }
    }

    componentDidMount(){
        this.name.current.focus();
    }

    // SUBMIT FUNC 
    fSubmit = (e) => {
        e.preventDefault();
        console.log('try')

        // some error here, solve here before submitting
        let datas = this.state.datas
        let name = this.refs.name.value
        let job = this.refs.job.value

        if(this.state.act === 0){
            let data = {name, job}
            datas.push(data)
        } else {
            let index = this.state.index
            datas[index].name = name
            datas[index].job = job
        }

        this.setState({
            datas: datas,
            act: 0
        })

        // RESETING AFTER FORM SUBMIT
        document.getElementById("myForm").reset()
        this.name.current.focus();
    }

    // DELETE DOING HERE
    fRemove = (i) => {
        let datas = this.state.datas
        datas.splice(i,1)
        this.setState({
            datas: datas
        })
        document.getElementById("myForm").reset()
        this.name.current.focus();
    }
    
    render() {
        let datas = this.state.datas
        return (
            <div>
                <div>
                    <h2>{this.state.title}</h2>
                </div>
                <div>
                    <form id='myForm' style={{
                        width: '450px',
                        paddingLeft:'20px',
                        textAlign:'left',
                        float:'left'}}>
                        <div class="form-group">
                            <label>Name:</label>
                            <input type="text" ref={this.name} placeholder="Enter Name"
                            className="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Job:</label>
                            <input type="text" ref="job" className="form-control" 
                            placeholder="Enter Job"/>
                        </div>
                        <div>
                            <button onClick={(e)=>this.fSubmit(e)} type="submit" className="btn btn-primary">Submit</button>
                        </div><br></br>
                        <div>
                            <pre>
                                {datas.map((data, i)=>
                                    // WE CAN CRAFT A TABLE HERE AND INSERT THE VALUES
                                    <li key={i} className="myList">
                                        {i+1}. {data.name}, {data.job}
                                        <button onClick={()=>this.fRemove(i)} type="button" className="btn btn-secondary">Delete</button>
                                    </li>
                                )}
                            </pre>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}

export default Question3
