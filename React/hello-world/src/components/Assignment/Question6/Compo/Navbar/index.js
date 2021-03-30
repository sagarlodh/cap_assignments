import React from 'react'; 
import { Nav, NavLink, Bars, NavMenu } from './NavbarElements'; 

const Navbar = () => { 
return ( 
	<> 
	<Nav> 
		<Bars/> 
			<NavMenu> 
				<NavLink to='/' activeStyle> 
					Home
				</NavLink> 
				<NavLink to='/projects' activeStyle> 
					Projects 
				</NavLink> 
				<NavLink to='/services' activeStyle> 
					Services 
				</NavLink> 
				<NavLink to='/contact' activeStyle> 
					Contact
				</NavLink>
			</NavMenu> 
	</Nav> 
	</> 
); 
}; 

export default Navbar;
