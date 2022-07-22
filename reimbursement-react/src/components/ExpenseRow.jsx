import { useEffect, useRef } from "react"


export const ExpenseRow = ({ expense, children }) => {
    const statusColor = useRef();

    useEffect(() => {
        let color;
        switch (expense.status.statusID) {
            case 1: color = "table-warning"; break;
            case 2: color = "table-success"; break;
            case 3: color = "table-danger"; break;
            default: color = "table-warning"; break;
        }
        statusColor.current.className = color;
    }, [expense.status.statusID]);
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
                {children}
            </td>
        </tr>
    )
}
