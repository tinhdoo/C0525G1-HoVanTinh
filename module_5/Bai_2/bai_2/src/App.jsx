import './App.css';
import { customers } from "./service/customer.js";

function App() {
    return (
        <table border="1" cellPadding="10" style={{ borderCollapse: "collapse" }}>
            <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Địa chỉ</th>
                <th>Loại khách hàng</th>
            </tr>
            </thead>

            <tbody>
            {customers.map(c => (
                <tr key={c.id}>
                    <td>{c.id}</td>
                    <td>{c.code}</td>
                    <td>{c.name}</td>
                    <td>{c.address}</td>
                    <td>{c.type}</td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}

export default App;
