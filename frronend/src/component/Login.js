import './login.css';
import Patient from './Patient';
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
function Login (){
    const navigate = useNavigate();
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
  
   
const onChange=(e)=>{
let user=e.target.value
setUsername(user);
}

 const log=()=>{
    console.log(username);
    <Patient username={username}/>
       navigate("/patient/"+username);
      
    }



return (
<div class="wrapper fadeInDown">
  <div id="formContent">
 
    

   
    <form>
    <label for="user" class="label">Username</label> 
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="username"onChange={onChange}/>
      <label for="pass" class="label">Password</label>
      <input type="text" id="password" class="fadeIn third" name="login" placeholder="password"/>
      <input type="submit" class="button" value="Sign In" onClick={log}/> 
      <input type="submit" class="button" value="Sign up"onClick={()=> navigate("/patient/signUp")}/> 
                            <div class="hr"></div>
                           
    </form>


    </div>

</div>
                   

)
}

export default Login;
