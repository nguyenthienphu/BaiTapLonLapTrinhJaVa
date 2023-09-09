import { useContext, useState } from "react";
import { MyUserContext } from "../App";
import { Form } from "react-bootstrap";
import { Button } from "bootstrap";

const AddRoom = () => {
    const [user] = useContext(MyUserContext);
    const [room, setRoom] = useState({
        "name": "", 
        "description": "", 
        "address": "", 
        "lastName": "", 
        "email": "",
        "phone": "",
        "confirmPass": ""
    });
    return (
        <>
            <h1 className="text-center text-info">THÊM PHÒNG CỦA CHỦ PHÒNG {user.lastName} {user.firstName}</h1>
            <Form>
                <Form.Group className="mb-3">
                    <Form.Label>Tên bài viết</Form.Label>
                    <Form.Control type="text" placeholder="Tên bài viết" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Tên</Form.Label>
                    <Form.Control type="text" placeholder="Tên" required />
                </Form.Group>
            </Form>
        </>
    )
}
export default AddRoom