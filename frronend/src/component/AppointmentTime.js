import axios from "axios";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
function AppointmentTime({ user }) {

  const { username } = useParams()
  const [idPatient, setPatient] = useState({});
  const [appointment, setAppointment] = useState({ });
  const [doctor1, setDoctor1] = useState();
  const [idDoctor,setDoctorId]=useState();
  const [timeDoctor, setTimeDoctor] = useState([]);
  const [appTime, setAppTime] = useState();
  const [idTime, setTimeId] = useState();

  //Get paitent
  useEffect(() => {
    console.log(1);
    axios
      .get(`http://localhost:8080/patients/${username}`)
      .then((response) => setPatient(response.data.id))
      .catch((error) => console.log(error));

    axios
      .get(`http://localhost:8080/doctors/` + user)
      .then((response) => setDoctor1(response.data))
      .catch((error) => console.log(error));
      axios
      .get(`http://localhost:8080/doctors/time/`+user)
      .then((response) => setTimeDoctor(response.data))
      .catch((error) => console.log(error));
      axios
     .get(`http://localhost:8080/doctors/` + user)
     .then((response) => setDoctorId(response.data.idDoctor))
     .catch((error) => console.log(error));

  }, [appTime]);

 
  


  function selectOnChange(e) {
    setAppTime(e.target.value)
    addTime()


  }
  
  function addTime(){
    timeDoctor.map((ele)=>{
      if(ele.appointmentTime==appTime){
        console.log("in iff");
      setTimeId(ele.idTime)
   }
      else
      console.log("  not in  "+appTime);
      })
  }
  



  const clickBtn = (e) => {

    e.preventDefault()
    const appointment1={appointment,idPatient,idDoctor ,idTime}
    
    console.log(appointment1)
    fetch("http://localhost:8080/appointments",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(appointment1)
    }).then(()=>{
        console.log("New Appointment Added")
    })
  }
  
  // function newApp(){

  
  // }
  console.log("idtime: "+idTime);
  return (
    <>
      <div class="col-md-12 mt-3">
        <select class="form-select mt-3" required onChange={selectOnChange}>
          {doctor1? doctor1.timeList.map((e) => {
            return (<option id="op1" >{e.appointmentTime}</option>
            )

          }): ""}
        </select>
        <button type="submit" onClick={clickBtn}> Submit</button>
      </div>

    </>
  )

}
export default AppointmentTime;

