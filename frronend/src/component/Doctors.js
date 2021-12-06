import { useState, useEffect } from "react";
import axios from "axios";
import Doctor from './Doctor'
import './Doctor.css'
function Doctors(){
    console.log("In Doctors");
    const [allAallDoctors ,setAllDoctors] = useState([]);
    useEffect(() => {
        axios
          .get("http://localhost:8080/doctors")
          .then((response) => setAllDoctors(response.data))
           //response.data.items[0].snippet.thumbnails.high.url
          .catch((error) => console.log(error));
      
      },[allAallDoctors]);

      console.log(allAallDoctors);

return(
    <>
  
      {allAallDoctors.map((element)=>{
       return(
          <Doctor
     
          doctor={element}
         
          />
        )
        })} 
</>
) 

}

export default Doctors;