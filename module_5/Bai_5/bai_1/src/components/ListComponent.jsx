import {useEffect, useRef, useState} from "react";
import {addNew, deletePlayer, getAllPlayers, searchPlayer} from "../service/players.jsx";
import DeleteComponent from "./DeleteComponent.jsx";
import {useNavigate} from "react-router-dom";

const ListComponent = () => {
    const [players, setPlayers] = useState(null);
    const [reloading, setReloading] = useState(false);
    const [deletePlayers, setDeletePlayers] = useState({id: 0, name: "no name"});
    const [showModal, setShowModal] = useState(false);
    const [search, setSearch] = useState("");

    const idRef = useRef(null);
    const codeRef = useRef(null);
    const nameRef = useRef(null);
    const dobRef = useRef(null);
    const priceRef = useRef(null);
    const positionRef = useRef(null);

    const navigate = useNavigate();

    // Load danh sách
    useEffect(() => {
        setPlayers(getAllPlayers());
    }, [reloading]);

    // Tìm kiếm
    const handleSearchPlayer = () => {
        if (!search.trim()) {
            setPlayers(getAllPlayers());
        } else {
            setPlayers(searchPlayer(search));
        }
    };

    // Mở modal xóa
    const handleShowModal = (player) => {
        setDeletePlayers(player);
        setShowModal(true);
    };

    // Đóng modal
    const closeModal = () => {
        setReloading(prev => !prev);
        setShowModal(false);
    };

    // Thêm cầu thủ
    const handleAddPlayer = () => {
        const newPlayer = {
            id: idRef.current.value,
            code: codeRef.current.value,
            name: nameRef.current.value,
            dob: dobRef.current.value,
            price: priceRef.current.value,
            position: positionRef.current.value
        };

        addNew(newPlayer);
        setReloading(prev => !prev);

        idRef.current.value = "";
        codeRef.current.value = "";
        nameRef.current.value = "";
        dobRef.current.value = "";
        priceRef.current.value = "";
        positionRef.current.value = "";
    };

    return (
        <div className="container-fluid py-4 px-3 px-md-5">

            {/* Header */}
            <div className="text-center mb-4">
                <h1 className="display-5 fw-bold text-white mb-2">
                    ⚽ Quản Lý Cầu Thủ
                </h1>
                <p className="text-white-50">Hệ thống quản lý danh sách cầu thủ</p>
            </div>

            {/* Form thêm mới */}
            <div className="card-custom mb-4 animate-slide-up">
                <div className="d-flex align-items-center mb-4">
                    <div className="icon-box me-3">
                        <i className="fas fa-user-plus"></i>
                    </div>
                    <h3 className="text-white mb-0">Thêm Cầu Thủ Mới</h3>
                </div>

                <div className="row g-3">
                    <div className="col-md-2 col-sm-6">
                        <label className="form-label text-white-50 small">ID</label>
                        <input ref={idRef} className="form-control form-control-custom" placeholder="Nhập ID"/>
                    </div>

                    <div className="col-md-2 col-sm-6">
                        <label className="form-label text-white-50 small">Mã CT</label>
                        <input ref={codeRef} className="form-control form-control-custom" placeholder="VD: CT001"/>
                    </div>

                    <div className="col-md-3 col-sm-6">
                        <label className="form-label text-white-50 small">Tên cầu thủ</label>
                        <input ref={nameRef} className="form-control form-control-custom" placeholder="Nhập tên"/>
                    </div>

                    <div className="col-md-2 col-sm-6">
                        <label className="form-label text-white-50 small">Năm sinh</label>
                        <input ref={dobRef} type="date" className="form-control form-control-custom"/>
                    </div>

                    <div className="col-md-2 col-sm-6">
                        <label className="form-label text-white-50 small">Giá ($)</label>
                        <input ref={priceRef} type="number" className="form-control form-control-custom" placeholder="0"/>
                    </div>

                    <div className="col-md-1 col-sm-6">
                        <label className="form-label text-white-50 small">Vị trí</label>
                        <input ref={positionRef} className="form-control form-control-custom" placeholder="FW"/>
                    </div>
                </div>

                <div className="text-center mt-4">
                    <button className="btn btn-add px-5 py-2" onClick={handleAddPlayer}>
                        <i className="fas fa-plus-circle me-2"></i>
                        Thêm Mới
                    </button>
                </div>
            </div>

            {/* Search */}
            <div className="search-box mb-4 animate-slide-up" style={{animationDelay: '0.1s'}}>
                <div className="input-group input-group-lg">
                    <span className="input-group-text bg-white border-0">
                        <i className="fas fa-search text-muted"></i>
                    </span>
                    <input
                        type="text"
                        className="form-control form-control-custom border-0"
                        placeholder="Tìm kiếm theo tên, mã cầu thủ..."
                        onChange={(e) => setSearch(e.target.value)}
                        onKeyPress={(e) => e.key === "Enter" && handleSearchPlayer()}
                    />
                    <button onClick={handleSearchPlayer} className="btn btn-search px-4">
                        <i className="fas fa-search me-2"></i>
                        Tìm kiếm
                    </button>
                </div>
            </div>

            {/* Danh sách */}
            <div className="table-custom animate-slide-up" style={{animationDelay: '0.2s'}}>
                <div className="d-flex justify-content-between align-items-center mb-3 px-3 pt-3">
                    <h4 className="text-white mb-0">
                        <i className="fas fa-list-ul me-2"></i>
                        Danh Sách Cầu Thủ
                    </h4>
                    <span className="badge bg-light text-dark fs-6">
                        Tổng: {players?.length || 0} cầu thủ
                    </span>
                </div>

                <div className="table-responsive">
                    <table className="table table-hover mb-0">
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
                        {players?.length > 0 ? (
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
                                            ${player.price?.toLocaleString()}
                                        </span>
                                    </td>

                                    <td>
                                        <span className="position-badge">{player.position}</span>
                                    </td>

                                    <td className="d-flex gap-2">

                                        {/* EDIT */}
                                        <button
                                            className="btn btn-warning btn-sm"
                                            onClick={() => navigate(`/edit/${player.id}`)}
                                        >
                                            <i className="fas fa-edit"></i>
                                        </button>

                                        {/* DELETE */}
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
                                    <i className="fas fa-inbox fa-3x mb-3 d-block"></i>
                                    <p className="mb-0">Chưa có cầu thủ nào</p>
                                </td>
                            </tr>
                        )}
                        </tbody>
                    </table>
                </div>
            </div>

            {/* Modal xoá */}
            {showModal && (
                <DeleteComponent
                    deleteTarget={deletePlayers}
                    deleteFunction={deletePlayer}
                    showModal={showModal}
                    closeModal={closeModal}
                />
            )}
        </div>
    );
};

export default ListComponent;
