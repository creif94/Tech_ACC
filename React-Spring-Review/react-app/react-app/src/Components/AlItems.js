import {useEffect, useState} from "react";
import axios from 'axios'
import IndividualItem from './IndividualItem'

const AllItems = (props) =>{

    const getIndividualItem = props.items.map((item)=>{
        return <IndividualItem key={item.id} item={item}  />
    })
    return(
        <>
            {getIndividualItem}
        </>
    )
}

export default AllItems