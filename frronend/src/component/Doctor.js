

function Doctor({doctor}){
console.log(doctor);


    return(
        <>

    <div class="card" >
  <div class="card-body">
  <h4>Name:{doctor.name}</h4>
<h4>Specialty:{doctor.specialty}</h4>
 
 <ul>
  {doctor.timeList.map((e)=>{
      if(e.available)
      return  <li>appointmentTime:{e.appointmentTime}</li>
  })}    

</ul> 
      </div>
</div>

        </>
    )
}
export default Doctor;

