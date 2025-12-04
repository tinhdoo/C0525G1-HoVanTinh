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
                <div className="modal" onClick={handleClose}>
                    <div onClick={(e) => e.stopPropagation()} style={{
                        background: 'white',
                        padding: '40px',
                        borderRadius: '24px',
                        maxWidth: '500px',
                        width: '90%',
                        boxShadow: '0 20px 60px rgba(37, 99, 235, 0.3)',
                        animation: 'scaleIn 0.3s cubic-bezier(0.16, 1, 0.3, 1)',
                        border: '1px solid rgba(37, 99, 235, 0.1)'
                    }}>
                        <div style={{ marginBottom: '32px', textAlign: 'center' }}>
                            <div style={{
                                width: '80px',
                                height: '80px',
                                background: 'linear-gradient(135deg, #fecaca 0%, #ef4444 100%)',
                                borderRadius: '50%',
                                display: 'flex',
                                alignItems: 'center',
                                justifyContent: 'center',
                                margin: '0 auto 24px',
                                boxShadow: '0 8px 24px rgba(239, 68, 68, 0.3)',
                                animation: 'pulse 2s ease infinite'
                            }}>
                                <i className="fas fa-exclamation-triangle" style={{
                                    fontSize: '40px',
                                    color: 'white'
                                }}></i>
                            </div>

                            <h3 style={{
                                color: '#1e293b',
                                fontWeight: '700',
                                fontSize: '24px',
                                marginBottom: '12px',
                                letterSpacing: '-0.5px'
                            }}>
                                Xác Nhận Xóa
                            </h3>

                            <p style={{
                                color: '#64748b',
                                fontSize: '16px',
                                lineHeight: '1.6',
                                margin: '0'
                            }}>
                                Bạn có chắc muốn xóa cầu thủ<br/>
                                <strong style={{
                                    color: '#2563eb',
                                    fontSize: '18px',
                                    display: 'inline-block',
                                    marginTop: '8px'
                                }}>
                                    {deleteTarget.name}
                                </strong> ?
                            </p>
                        </div>

                        <div style={{
                            display: 'flex',
                            gap: '16px',
                            justifyContent: 'center',
                            flexWrap: 'wrap'
                        }}>
                            <button
                                onClick={handleClose}
                                style={{
                                    background: 'linear-gradient(135deg, #94a3b8 0%, #64748b 100%)',
                                    color: 'white',
                                    border: 'none',
                                    borderRadius: '12px',
                                    padding: '14px 32px',
                                    fontWeight: '600',
                                    fontSize: '15px',
                                    cursor: 'pointer',
                                    transition: 'all 0.3s ease',
                                    textTransform: 'uppercase',
                                    letterSpacing: '0.5px',
                                    boxShadow: '0 4px 12px rgba(100, 116, 139, 0.3)',
                                    minWidth: '140px'
                                }}
                                onMouseOver={(e) => {
                                    e.target.style.transform = 'translateY(-2px)';
                                    e.target.style.boxShadow = '0 6px 16px rgba(100, 116, 139, 0.4)';
                                }}
                                onMouseOut={(e) => {
                                    e.target.style.transform = 'translateY(0)';
                                    e.target.style.boxShadow = '0 4px 12px rgba(100, 116, 139, 0.3)';
                                }}
                            >
                                <i className="fas fa-times me-2"></i>
                                Hủy
                            </button>

                            <button
                                onClick={handleDelete}
                                className="btn btn-danger"
                                style={{
                                    background: 'linear-gradient(135deg, #ef4444 0%, #dc2626 100%)',
                                    color: 'white',
                                    border: 'none',
                                    borderRadius: '12px',
                                    padding: '14px 32px',
                                    fontWeight: '600',
                                    fontSize: '15px',
                                    cursor: 'pointer',
                                    transition: 'all 0.3s ease',
                                    textTransform: 'uppercase',
                                    letterSpacing: '0.5px',
                                    boxShadow: '0 4px 12px rgba(239, 68, 68, 0.4)',
                                    minWidth: '140px'
                                }}
                                onMouseOver={(e) => {
                                    e.target.style.transform = 'translateY(-2px) scale(1.05)';
                                    e.target.style.boxShadow = '0 6px 20px rgba(239, 68, 68, 0.5)';
                                }}
                                onMouseOut={(e) => {
                                    e.target.style.transform = 'translateY(0) scale(1)';
                                    e.target.style.boxShadow = '0 4px 12px rgba(239, 68, 68, 0.4)';
                                }}
                            >
                                <i className="fas fa-trash-alt me-2"></i>
                                Xóa
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
};

export default DeleteComponent;
