
import axios from "axios";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import './Doctor.css'
// import Spicality from './Spicality'
import './appointment.css'
function Appointments() {
  const [allAppointments, setAllAppointments] = useState([]);
  const { username } = useParams()



  useEffect(() => {
    axios.get('http://localhost:8080/patients/allAppointment/' + username)
      .then(function (response) {
        setAllAppointments(response.data)
        console.log(response.data);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      })
      .then(function () {
        // always executed
      });
  }, []);
  return (
    <>
{
  allAppointments.map((e)=>{
    return <div>
      <h1>Appointment time:{e.time.appointmentTime}</h1>
      <h1>Doctor name: Dr.{e.doctor.name}</h1>
      <h1>Clinc: {e.doctor.specialty}</h1>
    </div>
  })
}
    </>)
}

export default Appointments;