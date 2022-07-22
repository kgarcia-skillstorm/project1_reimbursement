import axios from 'axios';
import { useNavigate } from "react-router-dom";


export const StatusCell = ({ updateData, expensesID, statusID }) => {
    const navigate = useNavigate();

    const updateStatus = async (expensesID, statusID) => {

            await axios.put("http://localhost:8080/reimbursement-java/",
                {
                    expensesID: expensesID,
                    status: statusID
                }
            )
            .catch(function (error) {
                // handle error
                navigate("../Error500")
            });
            updateData();


    }

    const deleteItem = async (expensesID) => {
            await axios.delete("http://localhost:8080/reimbursement-java/", { data: { expensesID: expensesID } })
            .catch(function (error) {
                // handle error
                navigate("../Error500")
            });
            updateData();

    }

    switch (statusID) {
        case 1: return (
            <div className="pending">
                <span>Pending</span>
                <div className="buttons">
                    <span className="material-symbols-outlined app" title="Approve request" onClick={() => { updateStatus(expensesID, 2) }}>check_circle</span>
                    <span className="material-symbols-outlined deny" title="Deny request" onClick={() => { updateStatus(expensesID, 3) }}>cancel</span>
                </div>
            </div>
        );
        case 2: return (
            <div className="approved">
                <span>Approved </span>
                <span className="material-symbols-outlined">check</span>
                <div className="buttons"><span className="material-symbols-outlined delete" title='Delete item' onClick={() => { deleteItem(expensesID) }}> do_not_disturb_on</span></div>


            </div>
        );
        case 3: return (
            <div className="denied">
                <span>Denied</span>
                <span className="material-symbols-outlined">close</span>
                <div className="buttons"><span className="material-symbols-outlined delete" title='Delete item' onClick={() => { deleteItem(expensesID) }}> do_not_disturb_on</span></div>
            </div>
        );

        default: break;
    }
}

