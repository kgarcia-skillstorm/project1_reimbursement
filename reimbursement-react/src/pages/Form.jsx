import { useRef } from "react";
import axios from 'axios';
import {useNavigate} from "react-router-dom";


export const Form = () => {
    
    const name       = useRef()
    const reasonID   = useRef()
    const amount     = useRef()
    const notes      = useRef()
    const reasonDesc = useRef()
    const navigate = useNavigate();

    
    const reasonChange = (event) => {
        colorSelector(event);
        descriptionSelector(event);
    }

    const colorSelector = (event) => {
        event.target.className = `form-select ${event.target.value !== "" ? "filled" : "empty"}`
    }

    const descriptionSelector = (event) => {
        const desc = [
            "Please select a reason from the menu above",
            "Reimburse gas, hotel, and flight costs for business purposes",
            "Reimburse stationary, technology, and other office supplies",
            "Reimburse continued education costs, like seminars or certifications",
            "Reimburse shared food, like communal coffee or pastries, or office-wide luncheons",
            "Reimburse expenses not otherwise specified"
        ]
        let value = event.target.value;
        if (value === "") { value = 0 }
        reasonDesc.current.innerText = desc[value];
    }

     const handleSubmit = async (event) => {
            event.preventDefault(); 
            await axios.post("http://localhost:8080/reimbursement-java/",  
                {
                    name:   name.current.value,
                    reason: reasonID.current.value,
                    amount: amount.current.value,
                    notes:  notes.current.value
                })
                .catch(function (error) {
                    // handle error
                    navigate("../Error500")
                });
                

            
            name.current.value = null;
            reasonID.current.value = "";
            amount.current.value = null;
            notes.current.value = null;
            reasonID.current.className = "form-select empty";
            reasonDesc.current.innerText = "Please select a reason from the menu above";

            navigate("../table");

    }

    return (
        <>

            <div className="container col-11">

                <form onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="name"> Name </label>
                        <input className="form-control" type="text" name="name" id="name" required ref={name}/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="reason"> Reason </label>
                        <select name="reason" id="reason" className="form-select empty" onChange={reasonChange} ref={reasonID} required>
                            <option value="">(Select an option)</option>
                            <option value="1">Transportation</option>
                            <option value="2">Supplies</option>
                            <option value="3">Education</option>
                            <option value="4">Food</option>
                            <option value="5">Other</option>
                        </select>
                        <div className="form-text" ref={reasonDesc} id="reasonDesc">Please select a reason from the menu above</div>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="amount"> Amount </label>
                        <input className="form-control" name="amount" required type="text" id="amount" pattern="^\d{0,4}?\.\d*" ref={amount}/>
                        <div className="form-text">Include decimal point. Do not include dollar sign. Amount must be less than $10,000. </div>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="notes"> Notes </label>
                        <input className="form-control" name="notes" type="text" id="notes" required ref={notes}/>
                        <div className="form-text">100 character limit</div>
                    </div>

                    <button type="submit" className="btn btn-primary">Submit
                        <span className="material-symbols-outlined">
                            arrow_circle_right
                        </span>

                    </button>
                </form>

            </div>
        </>
    )
}


