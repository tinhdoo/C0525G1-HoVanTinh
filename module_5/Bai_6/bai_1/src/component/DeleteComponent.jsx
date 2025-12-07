export default function DeleteComponent({ deleteTarget, deleteFunction, closeModal }) {
    return (
        <div className="modal-backdrop-custom">
            <div className="modal-box-custom">
                <h3 className="mb-3">Xóa cầu thủ?</h3>
                <p>Bạn có chắc chắn muốn xóa <strong>{deleteTarget.name}</strong>?</p>

                <div className="d-flex justify-content-end gap-2 mt-4">
                    <button className="btn btn-secondary" onClick={closeModal}>Hủy</button>
                    <button
                        className="btn btn-danger"
                        onClick={() => {
                            deleteFunction(deleteTarget.id);
                            closeModal();
                        }}
                    >
                        Xóa
                    </button>
                </div>
            </div>
        </div>
    );
}
