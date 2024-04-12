
import {NavLink} from "react-router-dom"
const navbar = () =>{


    return(
        <>  
            <nav className="navbar">
                <ul className="NavList">
                    <li className="NavItem">
                        <NavLink to="/">
                            Home
                        </NavLink>
                    </li>
                    <li className="NavItem">
                        <NavLink>
                            
                        </NavLink>
                    </li>
                </ul>
            </nav>
        </>
    )
}

export default navbar;