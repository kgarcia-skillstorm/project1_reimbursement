import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import {Error404, Error500, Form, Table} from "./pages";
import { Header } from './components';
import { useState } from "react";




export const App = () => {

    const [expenses, setExpenses] = useState([]);
    
    return (
        <>
            
            <BrowserRouter>
                <Header>
                    <Link to="/table" id='one'>View Requests</Link>
                    <Link to="/form"  id='two'>New Request</Link>
                </Header>
                
                <Routes>
                    <Route path='/' element={<Table expenses={expenses} setExpenses={setExpenses} />}></Route>
                    <Route path='/form' element={<Form />}></Route>
                    <Route path='/table' element={<Table />}></Route>
                    <Route path='/Error500' element={<Error500 />}></Route>
                    <Route path='/*' element={<Error404 />}></Route>
                </Routes>
            </BrowserRouter>
        </>
    );
}


export default App;
