import './App.css';
import {useEffect, useState} from "react";
import axios from 'axios'
import AllItems from './Components/AlItems'
import CreateItem from './Components/CreateItem'



const App = () =>{
  const [items, setAllItems] = useState([])
  const [currentItem, setCurrentItem] = useState()

  const getAllItems =()=>{
    axios.get(`http://localhost:3001/api/items`)
        .then(function(response){
            setAllItems(response.data)
        })
  }
  useEffect(()=>{
    getAllItems()
  },[])
    useEffect(()=>{
        getAllItems()
    },[items])

    return (
        <>
            <AllItems items={items} setCurrentItem={setCurrentItem} currentItem={currentItem} />
            <CreateItem />


        </>
    )
}

export default App;
