import {useState} from "react";
import axios from 'axios'
import Button from '@mui/material/Button';

const IndividualItem = (props) =>{

    const booleanToString =()=>{
        if (props.item.completed){
            return "true"
        }else{ return "false" }
    }

    const deleteRequest =() =>{
        // props.setCurrentItem(id)
        // e.preventDefault();
        axios.delete(`http://localhost:3001/api/items/${props.item.id}`
        ).then(response => console.log(`deleted ${response}`))
    }
    return(
        <>
            <div>{props.item.content} : {booleanToString()} :
                <Button onClick={()=> deleteRequest()} label={"testing"} >Delete </Button>

            </div>
        </>
    )
}

export default IndividualItem;
