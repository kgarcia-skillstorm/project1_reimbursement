// import "../components/scripts";
import axios from 'axios';
import { useEffect, useState } from "react";
import { ExpenseRow } from '../components';
import { StatusCell } from '../components/StatusCell';


export const Table = () => {

    const [expenses, setExpenses] = useState([]);

    useEffect(() => {
        updateData();
    }, []);

    const updateData = (() => {
        axios.get("http://localhost:8080/reimbursement-java/")
        .then(res => setExpenses(res.data));
    })
    return (
        <>

            <div className="container col-11">

                <div className="table-responsive">
                    <table className="table table-bordered">
                        <thead>
                            <tr className="table-secondary">
                                <th>Employee Name</th>
                                <th>Reason</th>
                                <th>Amount</th>
                                <th>Notes</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            {expenses.map((expense) => {
                                return (
                                    <ExpenseRow expense={expense} key={expense.expensesID.toString()}  >
                                        <StatusCell 
                                        updateData={updateData}
                                        expensesID={expense.expensesID}
                                        statusID={expense.status.statusID}
                                        />
                                    </ExpenseRow>
                                )
                            })}

                        </tbody>
                    </table>
                </div>

            </div>
        </>
    )
}

// setExpenses={setExpenses} 
// updateData={updateData} 
// expense={expense} 
// key={expense.expensesID.toString()}  