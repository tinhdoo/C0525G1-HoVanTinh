import React, { useState, useEffect } from "react";
// Đảm bảo đường dẫn import đúng với cấu trúc thư mục của bạn
import { facilityList } from "../../data/data";
import "bootstrap/dist/css/bootstrap.min.css";

function FacilityList() {
    const [facilities, setFacilities] = useState([]);
    const [searchTerm, setSearchTerm] = useState("");

    useEffect(() => {
        setFacilities(facilityList);
    }, []);

    const handleSearch = () => {
        const result = facilityList.filter((item) =>
            item.serviceName.toLowerCase().includes(searchTerm.toLowerCase())
        );
        setFacilities(result);
    };

    const handleInputChange = (e) => {
        setSearchTerm(e.target.value);
    };

    return (
        <div className="container mt-5">
            <h2 className="text-center mb-4">Danh Sách Dịch Vụ</h2>

            {/* Khung tìm kiếm */}
            <div className="d-flex justify-content-end mb-4">
                <input
                    type="text"
                    className="form-control w-25 me-2"
                    placeholder="Tìm kiếm dịch vụ..."
                    value={searchTerm}
                    onChange={handleInputChange}
                />
                <button className="btn btn-outline-success" onClick={handleSearch}>
                    Tìm kiếm
                </button>
            </div>

            {/* Danh sách hiển thị */}
            <div className="row">
                {facilities.length > 0 ? (
                    facilities.map((item) => (
                        <div className="col-md-4 mb-4" key={item.id}>
                            <div className="card h-100 shadow-sm">
                                <img
                                    src={item.image}
                                    className="card-img-top"
                                    alt={item.serviceName}
                                    style={{ height: "200px", objectFit: "cover" }}
                                />
                                <div className="card-body">
                                    <h5 className="card-title text-primary">{item.serviceName}</h5>

                                    <p className="card-text">
                                        <strong>Diện tích:</strong> {item.area} m² <br />
                                        <strong>Giá thuê:</strong> {item.cost?.toLocaleString()} VND <br />
                                        <strong>Sức chứa:</strong> {item.maxPeople} người <br />

                                        {(item.facilityType === "Villa" || item.facilityType === "House") && (
                                            <>
                                                <strong>Tiêu chuẩn:</strong> {item.standard} <br />
                                                <strong>Số tầng:</strong> {item.floors} <br />
                                            </>
                                        )}

                                        {item.facilityType === "Villa" && (
                                            <>
                                                <strong>Hồ bơi:</strong> {item.poolArea} m² <br />
                                            </>
                                        )}

                                        {/* Thông tin riêng chỉ Room mới có  */}
                                        {item.facilityType === "Room" && (
                                            <>
                                                <strong>Dịch vụ free:</strong> {item.freeService} <br />
                                            </>
                                        )}
                                    </p>
                                </div>
                                <div className="card-footer d-flex justify-content-between">
                                    <button className="btn btn-warning btn-sm">Sửa</button>
                                    <button className="btn btn-danger btn-sm">Xóa</button>
                                </div>
                            </div>
                        </div>
                    ))
                ) : (
                    <div className="alert alert-warning text-center">
                        Không tìm thấy dịch vụ nào phù hợp.
                    </div>
                )}
            </div>
        </div>
    );
}

export default FacilityList;