import {BrowserRouter,Routes,Route} from "react-router-dom";
import Login from './component/Login';
import Patient from './component/Patient';
import Appointments from "./component/Appointments";
import './App.css'
import Doctors from "./component/Doctors";
import Doctor from "./component/Doctor";
import AddAppointment from './component/AddAppointment'
import DoctorName from "./component/DoctorName";
import SignUp from "./component/SignUp";



function App() {
 
  return (
  
      <BrowserRouter>
    
      <div>
      <Routes>
      
          <Route path="/" element={<Login />} />
          <Route path="/patient/:username" element={<Patient />} />
          <Route path="/appointments/:username" element={<Appointments />} />
          <Route path="/addAppointment/:username" element={<AddAppointment />} />
          <Route path="/addAppointment/doctorName/:username" element={<DoctorName />} />
          <Route path="//:username" element={<AddAppointment />} />
          <Route path="/doctors" element={<Doctors />} />
          <Route path="/doctors/doctor" element={<Doctor />} />

          <Route path="/patient/signUp" element={<SignUp />} />

       
      </Routes>
      </div>

      </BrowserRouter>
    
  );
}

export default App;
