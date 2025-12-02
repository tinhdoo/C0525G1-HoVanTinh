import "bootstrap/dist/css/bootstrap.min.css";

function App() {
    return (
        <div className="container mt-5" style={{ maxWidth: "400px" }}>
            <h3 className="text-center mb-4">Sign In</h3>

            <form>
                <div className="mb-3">
                    <label className="form-label">Email address</label>
                    <input
                        type="email"
                        className="form-control"
                        placeholder="Enter email"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Enter password"
                    />
                </div>
                <div className="form-check mb-3">
                    <input
                        type="checkbox"
                        className="form-check-input"
                        id="remember"
                    />
                    <label className="form-check-label" htmlFor="remember">
                        Remember me
                    </label>
                </div>
                <button type="submit" className="btn btn-primary w-100">
                    Sign In
                </button>
            </form>
        </div>
    );
}

export default App;
