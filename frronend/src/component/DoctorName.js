import axios from "axios";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import './addApp.css'
import AppointmentTime from './AppointmentTime'
function DoctorName({ specialty }) {
    const [Doctors, setDoctors] = useState([]);
    const { username } = useParams()
    const [doctor1, setDoctor1] = useState({});
    const [user, setUser] = useState();


    // useEffect(() => {
    //       axios
    //       .get(`http://localhost:8080/doctors`)
    //       .then((response) => setDoctors(response.data))

    //       .catch((error) => console.log(error));

    //   },[Doctors]);


    function selectOnChange(e) {

        setUser(e.target.value)
    }

    // if(Doctor){
    //     axios
    // .get(`http://localhost:8080/doctors/`+Doctor)
    // .then((response) => setDoctor1(response.data))
    // .catch((error) => console.log(error));
    //     }
    useEffect(() => {
        console.log(3);
        if (specialty) {
            axios
                .get(`http://localhost:8080/doctors/specialty/` + specialty)
                .then((response) => setDoctors(response.data))
                .catch((error) => console.log(error));
        }
    }, [specialty]);




    return (
        <>
            <div class="col-md-12 mt-3">
                <select class="form-select mt-3" required onChange={selectOnChange}>
                    {Doctors ? Doctors.map((e) => {

                        return (<option id="op1" >{e.username}</option>
                        )

                    })
                        : ""}
                </select>
                <label>Selsect Time</label>
                {user ?  < AppointmentTime user={user}   /> :""}
            </div>
        </>
    )

}
export default DoctorName;

