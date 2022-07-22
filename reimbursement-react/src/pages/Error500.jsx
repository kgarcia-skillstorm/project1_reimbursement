import {useNavigate} from "react-router-dom";

export const Error500 = () => {
    const navigate = useNavigate();
    return (
        <div className="container col-11">
            <h1>Something went wrong on our end</h1>
            <h2 onClick={() => navigate(-1)} className="errorLink">Click here to go back to your last page</h2>
        </div>
    )
}