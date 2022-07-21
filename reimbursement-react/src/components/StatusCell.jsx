import axios from 'axios';



export const Pending = ({ setExpenses, expensesID }) => {
    const updateStatus = async (expensesID, statusID) => {

        await axios.put("http://localhost:8080/reimbursement-java/",
            {
                expensesID: expensesID,
                status: statusID
            }
        )
        setExpenses(expenses => expenses.map(expense => {
            if (expense.expensesID === expensesID) {
                expense.status.statusID = statusID;
            }
            return expense;
        }));
    }

    return (
        <div className="pending">
            <span>Pending</span>
            <div className="buttons">
                <span className="material-symbols-outlined app" title="Approve request" onClick={() => { updateStatus(expensesID, 2) }}>check_circle</span>
                <span className="material-symbols-outlined deny" title="Deny request" onClick={() => { updateStatus(expensesID, 3) }}>cancel</span>
            </div>
        </div>
    )
}

export const Approved = ({ expensesID }) => {
    const deleteItem = async (expensesID) => {
        await axios.delete("http://localhost:8080/reimbursement-java/",
            {
                expensesID: expensesID
            }
        )

    }

    return (
        <div className="approved">
            <span>Approved </span>
            <span className="material-symbols-outlined">check</span>
            <div className="buttons"><span className="material-symbols-outlined delete" title='Delete item' onClick={() => { deleteItem(expensesID) }}> do_not_disturb_on</span></div>


        </div>
    )
}

export const Denied = ({setExpenses, expensesID}) => {
    const deleteItem = async (expensesID) => {
        await axios.delete("http://localhost:8080/reimbursement-java/", { data: { expensesID: expensesID } })
            .then(setExpenses)
    
    }
    
    return (
        <div className="denied">
            <span>Denied</span>
            <span className="material-symbols-outlined">close</span>
            <div className="buttons"><span className="material-symbols-outlined delete" title='Delete item' onClick={() => { deleteItem(expensesID) }}> do_not_disturb_on</span></div>
        </div>
    )
}