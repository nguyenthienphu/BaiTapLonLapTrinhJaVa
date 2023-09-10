import { useContext, useRef, useState } from "react";
import { MyUserContext } from "../App";
import { Alert, Form } from "react-bootstrap";
import { Button } from "bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const AddRoom = () => {
    const [user] = useContext(MyUserContext);
    const [room, setRoom] = useState({
        "name": "",
        "description": "",
        "address": "",
    });
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const image = useRef();
    const nav = useNavigate();

    const addroom = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let form = new FormData();

            form.append("image", image.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['room'], form);
            if (res.status === 201) {
                nav("/");
            } else
                setErr("Hệ thống bị lỗi!");
        }

        process();

    }

    const change = (evt, field) => {
        setRoom(current => {
            return { ...current, [field]: evt.target.value }
        })
    }
    return (
        <>
            <h1 className="text-center text-info">THÊM PHÒNG CỦA CHỦ PHÒNG {user.lastName} {user.firstName}</h1>

            {err === null ? "" : <Alert variant="danger">{err}</Alert>}

            <Form onSubmit={addroom}>
                <Form.Group className="mb-3">
                    <Form.Label>Tên phòng</Form.Label>
                    <Form.Control type="text" onChange={(e) => change(e, "name")} placeholder="Tên phòng" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Ghi chú</Form.Label>
                    <Form.Control type="text" onChange={(e) => change(e, "description")} placeholder="Ghi chú" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Địa chỉ</Form.Label>
                    <Form.Control type="text" onChange={(e) => change(e, "address")} placeholder="Địa chỉ" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    {loading === true ? <MySpinner /> : <Button variant="info" type="submit">Đăng ký phòng</Button>}

                </Form.Group>
            </Form>
        </>
    )
}
export default AddRoom