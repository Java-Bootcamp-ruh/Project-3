import axios from "axios";
import { useState, useEffect } from "react";
import DoctorName from "./DoctorName";
import { useParams } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
function AddAppointment(){
  const {username} = useParams()
  const navigate = useNavigate();
  const [Doctors, setDoctors] = useState([]);
  const [specialty, setSpecialty] = useState(); 
  const [doctor1, setDoctor1] = useState({});  
 



// if(Doctor){
//   axios
// .get(`http://localhost:8080/doctors/`+Doctor)
// .then((response) => setDoctor1(response.data))
// .catch((error) => console.log(error));
//   }


    function selectOnChange (e){
      setSpecialty(e.target.value)
        }

        function   book(){
          navigate("/doctors");
         
          <AddAppointment />
             navigate("/addAppointment/"+username);
        }
    return(
        <>
        
    
            <nav class="navbar navbar-expand-sm bg-light justify-content-center">
 
    <button onClick={book}>Book Appointemnt</button>
    <button onClick={()=>{navigate("/appointments/"+username);}}>My Appointemnts</button>
      <button onClick={()=>{navigate("/doctors");}}>Doctors</button>

</nav>
            <form class="requires-validation" novalidate>
       
        <div class="form-body">
        <div class="row">
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Book Appointment </h3>
                       
                           <div class="col-md-12">
                             <label>Selsect clinic</label>
                                <select class="form-select mt-3" required onChange={selectOnChange}>
                              
                                 <option id="op1" >Genral</option>
                                 <option id="op1">Dermatologist</option>
                                 <option id="op1" >Orthopedic</option>
                                 <option id="op1" >Dentist</option>

                               </select>
                            </div>
                            <label>Selsect Doctor</label>
       { specialty ?  < DoctorName specialty={specialty}  /> :""}
                  <br/>  
                        
                    </div>
                </div>
            </div>
        </div>
        </div> 

         <br/>    
       
    
            </form>      

 
  </>
    )
}
export default AddAppointment;