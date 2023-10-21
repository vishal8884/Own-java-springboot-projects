import logo from './logo.svg';
import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import { RegisterUserPage } from './pages/RegisterUserPage';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
            <Route path = "/expense/registerUser" element = {<RegisterUserPage/>}/>
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
