import './App.css';
import {useEffect, useState} from "react";
import axios from 'axios'
import Grid2 from '@mui/material/Unstable_Grid2'
// import {Grid} from "@mui/material";
import { styled } from '@mui/material/styles';
import AllItems from './Components/AlItems'




const App = () =>{
  const [items, setAllItems] = useState([])
  const[currentItem, setCurrentItem] = useState({})

  const getAllItems =()=>{
    axios.get(`http://localhost:3001/api/items`)
        .then(function(response){
            setAllItems(response.data)
        })
  }

  useEffect(()=>{
    getAllItems()
  },[])

    return (
        <>

            <AllItems items={items} setCurrentItem={setCurrentItem} />

        </>




    )
}


export default App;
