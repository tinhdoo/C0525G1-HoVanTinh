
import './App.css'
import {useState} from "react";
import ListComponent from "./component/ListComponent.jsx";

function App() {
    const [count, setCount] = useState(0)
    return (
        <>
        <ListComponent/>
        </>
    )
}

export default App
