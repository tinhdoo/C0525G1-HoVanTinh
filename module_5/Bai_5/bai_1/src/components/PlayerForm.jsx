import {useFormik} from "formik";
import * as Yup from "yup";
import {addNew, getById, updatePlayer} from "../service/players.jsx";
import {useNavigate, useParams} from "react-router-dom";
import {useEffect} from "react";

export default function PlayerForm() {
    const {id} = useParams();
    const isEdit = !!id;
    const navigate = useNavigate();

    const form = useFormik({
        initialValues: {
            code: "",
            name: "",
            dob: "",
            price: "",
            position: ""
        },
        validationSchema: Yup.object({
            code: Yup.string().required("Mã cầu thủ bắt buộc"),
            name: Yup.string().required("Tên cầu thủ bắt buộc"),
            dob: Yup.string().required("Ngày sinh bắt buộc"),
            price: Yup.number()
                .required("Giá bắt buộc")
                .min(1, "Giá phải > 0"),
            position: Yup.string().required("Vị trí bắt buộc")
        }),
        onSubmit: (values) => {
            if (isEdit) {
                updatePlayer(id, values);
            } else {
                addNew({...values, id: Date.now()});
            }
            navigate("/players");
        }
    });

    useEffect(() => {
        if (isEdit) {
            const p = getById(id);
            if (p) form.setValues(p);
        }
    }, []);

    return (
        <div className="container mt-5 text-white">

            <h2 className="mb-4">{isEdit ? "✏ Sửa cầu thủ" : "➕ Thêm cầu thủ mới"}</h2>

            <form onSubmit={form.handleSubmit} className="card p-4 bg-dark shadow">

                {/* CODE */}
                <label className="mt-2">Mã cầu thủ</label>
                <input
                    name="code"
                    onChange={form.handleChange}
                    value={form.values.code}
                    className="form-control"
                />
                <div className="text-danger small">{form.errors.code}</div>

                {/* NAME */}
                <label className="mt-2">Tên cầu thủ</label>
                <input
                    name="name"
                    onChange={form.handleChange}
                    value={form.values.name}
                    className="form-control"
                />
                <div className="text-danger small">{form.errors.name}</div>

                {/* DOB */}
                <label className="mt-2">Ngày sinh</label>
                <input
                    type="date"
                    name="dob"
                    onChange={form.handleChange}
                    value={form.values.dob}
                    className="form-control"
                />
                <div className="text-danger small">{form.errors.dob}</div>

                {/* PRICE */}
                <label className="mt-2">Giá chuyển nhượng</label>
                <input
                    type="number"
                    name="price"
                    onChange={form.handleChange}
                    value={form.values.price}
                    className="form-control"
                />
                <div className="text-danger small">{form.errors.price}</div>

                {/* POSITION */}
                <label className="mt-2">Vị trí</label>
                <input
                    name="position"
                    onChange={form.handleChange}
                    value={form.values.position}
                    className="form-control"
                    placeholder="FW / MF / DF / GK"
                />
                <div className="text-danger small">{form.errors.position}</div>

                <button type="submit" className="btn btn-primary mt-4">
                    {isEdit ? "Cập nhật" : "Thêm mới"}
                </button>
            </form>
        </div>
    );
}
