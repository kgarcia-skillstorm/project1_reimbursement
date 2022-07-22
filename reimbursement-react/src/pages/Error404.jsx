import {useNavigate} from "react-router-dom";

export const Error404 = () => {
    const navigate = useNavigate();
    return (
        <div className="container col-11">
            <h1>You reached a page that doesn't exist</h1>
            <h2 onClick={() => navigate(-1)} className="errorLink">Click here to go back to your last page</h2>
        </div>
    )
}