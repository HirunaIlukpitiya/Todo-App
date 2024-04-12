
import {NavLink} from "react-router-dom"
const navbar = () =>{


    return(
        <>  
            <nav className="navbar">
                <ul className="NavList">
                    <li className="NavItem">
                        <NavLink to="/">

                        </NavLink>
                    </li>
                </ul>
            </nav>
        </>
    )
}

export default navbar;