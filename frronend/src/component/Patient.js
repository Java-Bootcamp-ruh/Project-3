import axios from "axios";
import { useState, useEffect } from "react";
import './patient.css'
import { useParams } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
import AddAppointment from './AddAppointment'
function Patient () {
  const navigate = useNavigate();
  const [patient, setPatient] = useState({}); 
  const {username} = useParams()


let x="Amal1121"

  useEffect(() => {
    axios
      .get(`http://localhost:8080/patients/${username}`)
      .then((response) => setPatient(response.data))
     
      .catch((error) => console.log(error));
  
  },[patient]);
  
     

   function   book(){
        navigate("/doctors");
       
        <AddAppointment />
           navigate("/addAppointment/"+patient.username);
      }

        return (
          <>
             <div>
            <nav class="navbar navbar-expand-sm bg-light justify-content-center">
 
    <button onClick={book}>Book Appointemnt</button>
    <button onClick={()=>{navigate("/appointments/"+username);}}>My Appointemnts</button>
      <button onClick={()=>{navigate("/doctors");}}>Doctors</button>

</nav>


        </div>
        <div class="card" >
  <div class="card-body">
  <h4>Name: {patient.name}</h4>
<h4>Gender: {patient.gender}</h4>
<h4>Weight: {patient.weight}</h4>
<h4>Height: {patient.height}</h4>
<h4>phoneNO: {patient.phoneNO}</h4>
</div>
</div>
          </>
        );
      }
      
     
export default Patient;

