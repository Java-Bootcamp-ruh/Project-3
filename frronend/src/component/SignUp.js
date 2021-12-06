
import './login.css';
import Patient from './Patient';
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import './login.css';
function SignUp() {
    const navigate = useNavigate();
    const [username, setUsername] = useState();
    const [name, setName] = useState();
    const [password, setPassword] = useState();
    const [dob, setdob] = useState();
    const [phoneNO, setPhoneNO] = useState();
    const [gender, setGender] = useState();
    const [bloodType, setBloodType] = useState();
    const [weight, setWeight] = useState();
    const [height, setHeight] = useState();

    const clickBtn = (e) => {

        e.preventDefault()
        const patient = { name, username, password, dob, phoneNO, gender, bloodType, weight, height }

        console.log(patient)
        fetch("http://localhost:8080/patients", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(patient)
        }).then(() => {
            console.log("New patient Added")
        })

        navigate("/patient/" + username);
    }

    return (
        <>
            <div class="sign-up-form">
                <div class="group">
                    <div class="group">  <label for="user" class="label">Name</label> <input id="user" type="text" class="input" placeholder="Enter your username" onChange={(e) => setName(e.target.value)} /> </div>
                    <div class="group"> <label for="user" class="label">Username</label> <input id="user" type="text" class="input" placeholder="Create your Username" onChange={(e) => setUsername(e.target.value)} /> </div>
                    <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Create your password" onChange={(e) => setPassword(e.target.value)} /> </div>
                    <div class="group"> <label for="pass" class="label">Repeat Password</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Repeat your password" /> </div>
                    <div class="group"> <label for="pass" class="label">Phone number</label> <input id="pass" type="text" class="input" placeholder="Enter your phone number" onChange={(e) => setPhoneNO(e.target.value)} /> </div>
                    <div class="group"> <label for="pass" class="label">Date of birth</label> <input id="pass" type="date" class="input" data-type="date" onChange={(e) => setdob(e.target.value)} /> </div>
                    <div class="group"> <label for="pass" class="label">Gender</label> <input id="pass" type="text" class="input" data-type="text" onChange={(e) => setGender(e.target.value)} /> </div>
                    <div class="group"> <label for="pass" class="label">Blood type</label> <input id="pass" type="text" class="input" data-type="text" onChange={(e) => setBloodType(e.target.value)} /> </div>
                    <div class="group"> <label for="pass" class="label">Weight</label> <input id="pass" type="text" class="input" data-type="text" onChange={(e) => setWeight(e.target.value)} /> </div>
                    <div class="group"> <label for="pass" class="label">Height</label> <input id="pass" type="text" class="input" data-type="text" onChange={(e) => setHeight(e.target.value)} /> </div>

                    <div class="group"> <input type="submit" class="button" value="Sign Up" onClick={clickBtn} /> </div>


                </div>
            </div>
        </>
    )
}
export default SignUp;