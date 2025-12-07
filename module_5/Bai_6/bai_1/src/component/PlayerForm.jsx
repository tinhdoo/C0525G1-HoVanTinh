import {useFormik} from "formik";
import * as Yup from "yup";
import {addNew, getById, updatePlayer} from "../service/players.jsx";
import {getAllPositions} from "../service/positions.jsx";
import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";

export default function PlayerForm() {
    const {id} = useParams();
    const isEdit = !!id;
    const navigate = useNavigate();
    const [positions, setPositions] = useState([]);

    useEffect(() => {
        const loadPositions = async () => {
            const data = await getAllPositions();
            setPositions(data);
        };
        loadPositions();
    }, []);

    const form = useFormik({
        initialValues: {
            code: "",
            name: "",
            dob: "",
            price: "",
            positionId: ""
        },
        validationSchema: Yup.object({
            code: Yup.string().required("Mã cầu thủ bắt buộc"),
            name: Yup.string().required("Tên cầu thủ bắt buộc"),
            dob: Yup.string().required("Ngày sinh bắt buộc"),
            price: Yup.number().required("Giá bắt buộc").min(1, "Giá phải > 0"),
            positionId: Yup.string().required("Vui lòng chọn vị trí")
        }),
        onSubmit: async (values) => {
            const dataToSend = {
                ...values,
                positionId: parseInt(values.positionId),
                price: Number(values.price)
            };

            if (isEdit) {
                await updatePlayer(id, dataToSend);
            } else {
                await addNew(dataToSend);
            }
            navigate("/players");
        }
    });

    useEffect(() => {
        const loadPlayer = async () => {
            if (isEdit) {
                const p = await getById(id);
                form.setValues(p);
            }
        };
        loadPlayer();
    }, [id]);

    return (
        <div className="container mt-5 text-white" style={{maxWidth: "600px"}}>
            <h2 className="mb-4 text-center">{isEdit ? "✏ Sửa thông tin" : "➕ Thêm cầu thủ mới"}</h2>

            <form onSubmit={form.handleSubmit} className="card p-4 bg-dark shadow border-secondary">

                <div className="mb-3">
                    <label className="form-label">Mã cầu thủ</label>
                    <input name="code" onChange={form.handleChange} value={form.values.code} className="form-control" placeholder="VD: CT001"/>
                    <div className="text-danger small">{form.errors.code}</div>
                </div>

                <div className="mb-3">
                    <label className="form-label">Tên cầu thủ</label>
                    <input name="name" onChange={form.handleChange} value={form.values.name} className="form-control" placeholder="Nhập tên cầu thủ"/>
                    <div className="text-danger small">{form.errors.name}</div>
                </div>

                <div className="row">
                    <div className="col-md-6 mb-3">
                        <label className="form-label">Ngày sinh</label>
                        <input type="date" name="dob" onChange={form.handleChange} value={form.values.dob} className="form-control"/>
                        <div className="text-danger small">{form.errors.dob}</div>
                    </div>

                    <div className="col-md-6 mb-3">
                        <label className="form-label">Giá chuyển nhượng ($)</label>
                        <input type="number" name="price" onChange={form.handleChange} value={form.values.price} className="form-control"/>
                        <div className="text-danger small">{form.errors.price}</div>
                    </div>
                </div>

                <div className="mb-4">
                    <label className="form-label">Vị trí thi đấu</label>
                    <select
                        name="positionId"
                        onChange={form.handleChange}
                        value={form.values.positionId}
                        className="form-control"
                    >
                        <option value="">-- Chọn vị trí --</option>
                        {positions.map(p => (
                            <option key={p.id} value={p.id}>{p.name}</option>
                        ))}
                    </select>
                    <div className="text-danger small">{form.errors.positionId}</div>
                </div>

                <div className="d-flex justify-content-between">
                    <button type="button" className="btn btn-secondary" onClick={() => navigate("/players")}>Quay lại</button>
                    <button type="submit" className="btn btn-primary px-4">{isEdit ? "Cập nhật" : "Thêm mới"}</button>
                </div>
            </form>
        </div>
    );
}