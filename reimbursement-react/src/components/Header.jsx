import { useLocation } from "react-router-dom";

export const Header = ({children}) => {
    
    const {pathname} = useLocation();
    let title;
    switch (pathname) {
        case "/": title = "List of Requests"; break;
        case "/form": title = "Add Request"; break;
        case "/table": title = "List of Requests"; break;
        default: break;
    }
    
    return(
        <header className="col-12 container-fluid">
            <div id="headerText" className="col-12 col-sm-8">
                <h1>Reimbursement System</h1>
                <h2>{title}</h2>
            </div>
            <nav className="col-12 col-sm-4">
                {children}
            </nav>
        </header>  
    )
}