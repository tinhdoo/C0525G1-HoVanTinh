import {BrowserRouter, Routes, Route} from "react-router-dom";
import Header from "./components/Header.jsx";
import Footer from "./components/Footer.jsx";
import Home from "./components/Home.jsx";
import ListComponent from "./components/ListComponent.jsx";
import PlayerForm from "./components/PlayerForm.jsx";

function App() {
    return (
        <BrowserRouter>
            <Header />

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/players" element={<ListComponent />} />
                <Route path="/add" element={<PlayerForm />} />
                <Route path="/edit/:id" element={<PlayerForm />} />
            </Routes>

            <Footer />
        </BrowserRouter>
    );
}

export default App;
