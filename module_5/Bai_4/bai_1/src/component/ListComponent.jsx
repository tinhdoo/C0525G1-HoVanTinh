import {useEffect, useRef, useState} from "react";
import {addNew, deletePlayer, getAllPlayers} from "../service/players.jsx";
import DeleteComponent from "./DeleteComponent.jsx";
import { searchPlayer } from "../service/players.jsx";


const ListComponent =()=>{
    const [players, setPlayers] = useState(null);
    const [reloading, setReloading] = useState(false);
    const [deletePlayers, setDeletePlayers] = useState({"id": 0, "name": "no name"});
    const [showModal, setShowModal] = useState(false);
    const [search, setSearch] = useState(null);


    const idRef = useRef(null);
    const codeRef = useRef(null);
    const nameRef = useRef(null);
    const dobRef = useRef(null);
    const priceRef = useRef(null);
    const positionRef = useRef(null);
    const searchRef = useRef(null);

    useEffect(()=>{
        console.log("-----effect-run-----");
        setPlayers(getAllPlayers())
    }, [reloading]);

    const handleSearchPlayer = () => {
        const result = searchPlayer(search);

        // Nếu trống -> load lại toàn bộ danh sách
        if (!search) {
            setPlayers(getAllPlayers());
        } else {
            setPlayers(result);
        }
    };


    const handleShowModal = (player) => {
        setDeletePlayers(player);
        setShowModal(true);
    }
    const closeModal = () => {
        setReloading(pre => !pre);
        setShowModal(false);
    }
    const handleAddPlayer = (player) => {
        const id = idRef.current.value;
        const code = codeRef.current.value;
        const name = nameRef.current.value;
        const dob = dobRef.current.value;
        const price = priceRef.current.value;
        const position = positionRef.current.value;

        const newPlayer = {
            "id": id,
            "code": code,
            "name": name,
            "dob": dob,
            "price": price,
            "position": position
        }
        addNew(newPlayer);
        console.log(getAllPlayers());
        setReloading(pre => !pre);
    }

    return (
        <>
            {console.log("------list------")}
            <form >
                ID: <input  ref={idRef} name="id"/>
                Code: <input ref={codeRef} name="code"/>
                Name: <input ref={nameRef} name="name"/>
                Dob: <input ref={dobRef} name="dob"/>
                Price: <input ref={priceRef} name="price"/>
                Position: <input ref={positionRef} name="position"/>
                <button onClick={handleAddPlayer} type={'button'}>Thêm mới</button>
            </form>

            <div style={{margin: "20px 0"}}>
                <input
                    type="text"
                    placeholder="Nhập từ khóa..."
                    onChange={(e) => setSearch(e.target.value)}
                    style={{padding: "8px", marginRight: "10px", borderRadius: "6px"}}
                />

                <button
                    type="button"
                    onClick={handleSearchPlayer}
                    className="btn btn-primary"
                >
                    Tìm
                </button>
            </div>


            <h1 style={{"textAlign": "center"}}>Danh sách cầu thủ</h1>
            <table className="table table-striped">
                <thead>
                <tr>
                    <td>STT</td>
                    <td>Mã cầu thủ</td>
                    <td>Tên cầu thủ</td>
                    <td>Ngày sinh</td>
                    <td>Giá chuyển nhượng</td>
                    <td>Vị trí</td>
                    <td>Xóa</td>
                </tr>
                </thead>

                <tbody>
                {
                    players && players.map((player,i) => (
                        <tr key={player.id}>
                            <td>{player.id}</td>
                            <td>{player.code}</td>
                            <td>{player.name}</td>
                            <td>{player.dob}</td>
                            <td>{player.price} $</td>
                            <td>{player.position}</td>
                            <td>
                                <button
                                    onClick={() => handleShowModal(player)}
                                    className="btn btn-danger btn-sm"
                                >
                                    Xóa
                                </button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            {showModal &&
                <DeleteComponent
                    deleteTarget={deletePlayers}
                    deleteFunction={deletePlayer}
                    showModal={showModal}
                    closeModal={closeModal}
                />


            }
        </>
    )

}
export default ListComponent;