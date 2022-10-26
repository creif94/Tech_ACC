import {useState} from "react";
import axios from 'axios'

// import {Button, Stack, Switch} from "@mui/material";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Switch from '@mui/material/Switch';
import { styled } from '@mui/material/styles';
import {FormControlLabel, FormGroup} from "@mui/material";


const CreateItem = () =>{
    const [content, setContent] = useState("")
    const [completed, setCompleted] = useState(false)

    const postRequestItem = () =>{
        axios.post("http://localhost:3001/api/items",{
            content: content,
            completed: completed
        })
    }
    const switchButton =(e)=>{
        setCompleted(e.target.checked)
    }

    return(
        <>
            <Stack  spacing={1} direction="row">
                <form onSubmit={(e)=> {postRequestItem(e)}}>
                    <TextField
                        required
                        id="outlined-required"
                        label="content"
                        defaultValue="Content to Add"
                        value={content}
                        onChange={(e) => {setContent(e.target.value)}}
                    />
                    <FormGroup>
                       <FormControlLabel control={<Switch  checked={completed} onChange={switchButton}  />} label={"Completed?"} />
                    </FormGroup>
                        <Button type= "submit" color="inherit" >Submit</Button>
                </form>
            </Stack>

        </>
    )
}

export default CreateItem;
