import {Link} from "react-router-dom";

export default function Header() {
    return (
        <nav className="navbar navbar-dark bg-dark px-4">
            <Link className="navbar-brand" to="/">Football Manager</Link>

            <div>
                <Link className="nav-link d-inline text-white me-4" to="/players">
                    Danh sách cầu thủ
                </Link>
                <Link className="btn btn-success" to="/add">
                    + Thêm cầu thủ
                </Link>
            </div>
        </nav>
    );
}
