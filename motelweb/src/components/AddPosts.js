import { useState } from "react";
import { Button, Form } from "react-bootstrap"
import { authApis, endpoints } from "../configs/Apis";
import { useNavigate } from "react-router-dom";

const Posts = () => {
    const [name, setName] = useState("")
    const [content, setContent] = useState("")
    const [address, setaddress] = useState("")
    const [posts, setPosts] = useState([])
    const nav = useNavigate();

    const addPosts = () => {
        let process = async () => {
            let res = await authApis().post(endpoints['posts'], {
                "name": name,
                "address": address,
                "description": content
            });
            setPosts([...posts, res.data]);
            if (res.status === 201) 
                nav("/");
        }
        process();
    }

    return (
        <>
            <h1 className="text-center text-info">ĐĂNG BÀI VIẾT TÌM PHÒNG</h1>
            <Form>
                <Form.Group className="mb-3">
                    <Form.Label>Tên bài viết</Form.Label>
                    <Form.Control as="textarea" aria-label="With textarea" value={name} onChange={e => setName(e.target.value)} placeholder="Tên bài viết" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Nội dung</Form.Label>
                    <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Tên bài viết" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Địa chỉ</Form.Label>
                    <Form.Control as="textarea" aria-label="With textarea" value={address} onChange={e => setaddress(e.target.value)} placeholder="Tên bài viết" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Button onClick={addPosts} variant="info">Đăng bài</Button>
                </Form.Group>
            </Form>

        </>
    )
}
export default Posts