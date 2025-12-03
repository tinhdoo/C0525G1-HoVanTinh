import {getAllPlayers} from "../service/players.jsx";

const DeleteComponent = ({ deleteTarget, deleteFunction, closeModal, showModal  }) => {

    const handleClose = () => {
        closeModal();
    }

    const handleDelete = () => {
        deleteFunction(deleteTarget.id);
        console.log(getAllPlayers());
        closeModal();
    }

    return (
        <>
            {showModal && (
                <div className="modal">
                    <h3>Bạn có chắc muốn xóa: {deleteTarget.name} ?</h3>

                    <button onClick={handleClose}>Hủy</button>

                    <button onClick={handleDelete} className="btn btn-danger">
                        Xóa
                    </button>
                </div>
            )}
        </>
    );
};

export default DeleteComponent;
