import {useEffect, useState} from "react";
import {
    deletePlayer,
    getAllPlayers,
    searchPlayer
} from "../service/players.jsx";

import DeleteComponent from "./DeleteComponent.jsx";
import {useNavigate} from "react-router-dom";

const ListComponent = () => {
    const [players, setPlayers] = useState([]);
    const [reloading, setReloading] = useState(false);
    const [deleteTarget, setDeleteTarget] = useState({id: 0, name: ""});
    const [showModal, setShowModal] = useState(false);
    const [search, setSearch] = useState("");

    const navigate = useNavigate();

    useEffect(() => {
        const loadData = async () => {
            const data = await getAllPlayers();
            setPlayers(data);
        };
        loadData();
    }, [reloading]);

    const handleSearchPlayer = async () => {
        if (!search.trim()) {
            setPlayers(await getAllPlayers());
        } else {
            setPlayers(await searchPlayer(search));
        }
    };

    const handleShowModal = (player) => {
        setDeleteTarget(player);
        setShowModal(true);
    };

    const closeModal = () => {
        setReloading(prev => !prev);
        setShowModal(false);
    };

    return (
        <div className="container-fluid py-4 px-3 px-md-5">

            <div className="text-center mb-4">
                <h1 className="display-5 fw-bold text-white mb-2">⚽ Quản Lý Cầu Thủ</h1>
                <p className="text-white-50">Hệ thống quản lý danh sách cầu thủ</p>
            </div>

            <div className="d-flex justify-content-between align-items-center mb-4">
                <div className="input-group" style={{maxWidth: "500px"}}>
                     <span className="input-group-text bg-white border-0">
                        <i className="fas fa-search text-muted"></i>
                    </span>
                    <input
                        type="text"
                        className="form-control form-control-custom border-0"
                        placeholder="Tìm kiếm cầu thủ..."
                        onChange={(e) => setSearch(e.target.value)}
                        onKeyPress={(e) => e.key === "Enter" && handleSearchPlayer()}
                    />
                    <button onClick={handleSearchPlayer} className="btn btn-search px-4">
                        Tìm
                    </button>
                </div>

                <button className="btn btn-add px-4 py-2" onClick={() => navigate('/add')}>
                    <i className="fas fa-plus-circle me-2"></i> Thêm Mới
                </button>
            </div>

            <div className="table-custom animate-slide-up">
                <div className="d-flex justify-content-between align-items-center mb-3 px-3 pt-3">
                    <h4 className="text-white mb-0">
                        <i className="fas fa-list-ul me-2"></i>
                        Danh Sách Cầu Thủ
                    </h4>
                    <span className="badge bg-light text-dark fs-6">
                        Tổng: {players.length}
                    </span>
                </div>

                <div className="table-responsive">
                    <table className="table table-hover mb-0 text-white">
                        <thead>
                        <tr>
                            <th style={{width: '60px'}}>STT</th>
                            <th>Mã CT</th>
                            <th>Tên Cầu Thủ</th>
                            <th>Ngày Sinh</th>
                            <th>Giá Chuyển Nhượng</th>
                            <th>Vị Trí</th>
                            <th style={{width: '120px'}}>Thao Tác</th>
                        </tr>
                        </thead>

                        <tbody>
                        {players.length > 0 ? (
                            players.map((player, i) => (
                                <tr key={player.id} className="table-row-hover">
                                    <td><span className="badge bg-secondary">{i + 1}</span></td>
                                    <td><strong>{player.code}</strong></td>
                                    <td className="text-start">
                                        <i className="fas fa-user-circle me-2 text-primary"></i>
                                        {player.name}
                                    </td>
                                    <td>{player.dob}</td>
                                    <td>
                                        <span className="badge bg-success fs-6">
                                            ${Number(player.price).toLocaleString()}
                                        </span>
                                    </td>
                                    <td>
                                        <span className="badge bg-info text-dark">
                                            {player.position ? player.position.name : "Chưa cập nhật"}
                                        </span>
                                    </td>
                                    <td className="d-flex gap-2">
                                        <button
                                            className="btn btn-warning btn-sm"
                                            onClick={() => navigate(`/edit/${player.id}`)}
                                        >
                                            <i className="fas fa-edit"></i>
                                        </button>
                                        <button
                                            className="btn btn-delete btn-sm"
                                            onClick={() => handleShowModal(player)}
                                        >
                                            <i className="fas fa-trash-alt"></i>
                                        </button>
                                    </td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="7" className="text-center py-5 text-muted">
                                    Chưa có cầu thủ nào.
                                </td>
                            </tr>
                        )}
                        </tbody>
                    </table>
                </div>
            </div>

            {showModal && (
                <DeleteComponent
                    deleteTarget={deleteTarget}
                    deleteFunction={async (id) => {
                        await deletePlayer(id);
                        closeModal();
                    }}
                    closeModal={closeModal}
                />
            )}
        </div>
    );
};

export default ListComponent;