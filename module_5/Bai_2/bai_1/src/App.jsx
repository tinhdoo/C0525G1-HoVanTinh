import './App.css';
import { cities } from "./service/city.js";

function App() {
    return (
        <ul>
            {cities.map(city => (
                <li key={city.id} style={{ color: "red" }}>
                    {city.name}
                </li>
            ))}
        </ul>
    );
}

export default App;
