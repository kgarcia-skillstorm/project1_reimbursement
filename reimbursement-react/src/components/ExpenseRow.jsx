// import axios from "axios"
import { useEffect, useRef } from "react"
import { Pending, Approved, Denied } from "./StatusCell";


export const ExpenseRow = ({ setExpenses, expense }) => {
    const statusColor = useRef();

    useEffect(() => {
        let color;
        switch (expense.statusID) {
            case 1: color = "table-warning"; break;
            case 2: color = "table-success"; break;
            case 3: color = "table-danger"; break;
            default: color = "table-warning"; break;
        }
        statusColor.current.className = color;
    }, [expense.statusID]);
    // console.log(expense)
    return (

        <tr className="table-warning" ref={statusColor} >
            <td>{expense.name}</td>
            <td title={expense.reason.reasonDescription}>{expense.reason.reasonName}</td>
            <td style={{ textAlign: "right" }}>
                {`$${expense.amount.toFixed(2)}`}
                {/*formats amount from database to dollar format*/}
            </td>
            <td>{expense.notes}</td>
            <td>
                {{
                    1: <Pending setExpenses={setExpenses} expensesID={expense.expensesID} statusID={expense.statusID} />,
                    2: <Approved />,
                    3: <Denied />
                }[expense.statusID]}
            </td>
        </tr>
    )
}