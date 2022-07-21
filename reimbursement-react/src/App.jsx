import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import {Form, Table} from "./pages";
import { Header } from './components';



export const App = () => {

    
    return (
        <>
            
            <BrowserRouter>
                <Header>
                    <Link to="/table" id='one'>View Requests</Link>
                    <Link to="/form"  id='two'>New Request</Link>
                </Header>
                
                <Routes>
                    <Route path='/' element={<Table />}></Route>
                    <Route path='/form' element={<Form />}></Route>
                    <Route path='/table' element={<Table />}></Route>
                </Routes>
            </BrowserRouter>
        </>
    );
}


export default App;
