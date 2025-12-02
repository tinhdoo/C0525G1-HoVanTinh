import { useState } from 'react'
import './App.css'
import HeadComponent from "./component/HeadComponent.jsx";
import "bootstrap/dist/css/bootstrap.css"
import ListClassComponent from "./component/ListClassComponent.jsx";

function App() {
    return (
        <>
            <HeadComponent/>
            <ListClassComponent/>
        </>
    )
}

export default App
