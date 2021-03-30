import React from 'react'; 
import Navbar from '.'; 
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'; 
import Home from '../../pages/index';
import Projects from '../../pages/projects'
import Services from '../../pages/services'
import Contact from '../../pages/contact'

function Question6() { 
return ( 
	<Router> 
	    <Navbar /> 
	    <Switch> 
            <Route path='/' exact component={Home} /> 
            <Route path='/projects' component={Projects} /> 
            <Route path='/services' component={Services} /> 
            <Route path='/contact' component={Contact} />  
        </Switch> 
	</Router> 
); 
} 

export default Question6; 
